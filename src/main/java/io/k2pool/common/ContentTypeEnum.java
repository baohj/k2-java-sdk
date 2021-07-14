package io.k2pool.common;

public enum ContentTypeEnum {

    JSON("application/json"),
    TEXT("text/plain");

    private String contentType;

    public String getContentType() {
        return contentType;
    }

    ContentTypeEnum(String contentType){
        this.contentType = contentType;
    }


}
