package io.k2pool.common.util;

import io.k2pool.common.Constants;
import io.k2pool.common.ContentTypeEnum;
import io.k2pool.common.config.K2PoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpUtil {

	private static K2PoolConfig config;

	public static void setConfig(K2PoolConfig config) {
		HttpUtil.config = config;
	}

	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;  
	private static final int MAX_TIMEOUT = 60000;  

	static {
		// 设置连接池  
		connMgr = new PoolingHttpClientConnectionManager();  
		// 设置连接池大小  
		connMgr.setMaxTotal(100);  
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());  
		RequestConfig.Builder configBuilder = RequestConfig.custom();  
		// 设置连接超时  
		configBuilder.setConnectTimeout(MAX_TIMEOUT);  
		// 设置读取超时  
		configBuilder.setSocketTimeout(MAX_TIMEOUT);  
		// 设置从连接池获取连接实例的超时  
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);  
		requestConfig = configBuilder.build();  
	}
	
	public static String doPost(String url, String body, Map<String, String> heads,ContentTypeEnum contentTypeEnum) {
		url = config.getDomain()+url;
		log.info("@请求地址:"+url);
		log.info("@请求包体:"+body);
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;  
		try { 
			httpClient = HttpClients.createDefault();
			if(isHttps(url)){
				httpClient = wrapClient(httpClient);
			}
			HttpPost httpPost = new HttpPost(url); 
			//头信息
			if(heads != null){
				for (String key : heads.keySet()) {
					httpPost.setHeader(key, heads.get(key));
				}
			}
			httpPost.setConfig(requestConfig);  
			if(StringUtils.isNotEmpty(body)){
				StringEntity stringEntity = new StringEntity(body,"UTF-8");//解决中文乱码问题
				stringEntity.setContentEncoding("UTF-8");
				stringEntity.setContentType(contentTypeEnum.getContentType());
				httpPost.setEntity(stringEntity);
			}
			response = httpClient.execute(httpPost);  
			int statusCode = response.getStatusLine().getStatusCode();
			log.info("@响应状态码：statusCode = {}",statusCode);
			String httpStr = null;
			if(statusCode == 200){
				HttpEntity entity = response.getEntity();  
				httpStr = EntityUtils.toString(entity, "UTF-8");
				log.info("@响应包体：{}",httpStr);
			}
			return httpStr;
		} catch (Exception e) {
			log.error("请求失败", e);
			throw new RuntimeException(e);
		} finally {  
			if(response != null){
				closeResponse(response);
			}
			if(httpClient != null){
				closeClient(httpClient);
			}
		}
	}

	/** 
	 * 发送 POST 请求（支持HTTP和https），JSON形式 
	 * @param url 地址
	 * @param json json对象 
	 * @return string
	 */

	public static String doPost(String url, String json,String token) {
		Map<String, String> heads = new HashMap<>();
		if(StringUtils.isNotEmpty(token)){
			heads.put(Constants.TOKEN,token);
		}
		return doPost(url,json,heads,ContentTypeEnum.JSON);
	}

	/**
	 * 避免HttpClient的”SSLPeerUnverifiedException: peer not authenticated”异常
	 * 不用导入SSL证书
	 * @param httpclient 参数
	 * @return CloseableHttpClient
	 */
	public static CloseableHttpClient wrapClient(CloseableHttpClient httpclient) {  
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");  
			X509TrustManager tm = new X509TrustManager() {  
				public X509Certificate[] getAcceptedIssuers() {  
					return null;  
				}  

				public void checkClientTrusted(X509Certificate[] arg0,  
						String arg1) throws CertificateException {  
				}  

				public void checkServerTrusted(X509Certificate[] arg0,  
						String arg1) throws CertificateException {  
				}  
			};  
			ctx.init(null, new TrustManager[] { tm }, null);  
			SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx,NoopHostnameVerifier.INSTANCE);  
			httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();  
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return httpclient;
	}  

	/**
	 * 判断网路访问是否为https,如果是则返回true
	 * @param url 地址
	 * @return boolean
	 */
	private static boolean isHttps(String url){
		String scheme = url.substring(0,url.indexOf(":"));
		if("HTTPS".equals(scheme.toUpperCase())){
			return true;
		}
		return false;
	}
	/**
	 * 关闭CloseableHttpClient对象
	 * @param httpClient 参数
	 */
	public static void closeClient(CloseableHttpClient httpClient){
		if(httpClient != null){
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭CloseableHttpResponse对象
	 * @param response
	 */
	public static void closeResponse(CloseableHttpResponse response){
		if(response != null){
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

