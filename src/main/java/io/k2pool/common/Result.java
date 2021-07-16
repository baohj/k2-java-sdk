package io.k2pool.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    //响应码，000000 表示成功;其他为请求失败
    private String code;

    //响应描述信息
    private String msg;

    //响应数据
    private T data;

}
