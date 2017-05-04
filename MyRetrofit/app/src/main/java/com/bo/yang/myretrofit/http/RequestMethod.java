package com.bo.yang.myretrofit.http;

/**
 * User:yangbo(903023560@qq.com)
 * Date:2017-05-02
 */
public enum RequestMethod {
    GET("GET"),

    POST("POST");
    private final String value;

    RequestMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
