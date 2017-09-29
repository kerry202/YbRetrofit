package com.yb.retrofit.http;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * User:yangbo(903023560@qq.com)
 * Date:2017-05-02
 */
class StringConverter implements Converter<ResponseBody, String> {

    public static final StringConverter INSTANCE = new StringConverter();

    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
