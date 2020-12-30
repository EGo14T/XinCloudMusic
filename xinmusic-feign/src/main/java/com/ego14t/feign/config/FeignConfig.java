package com.ego14t.feign.config;

import com.ego14t.common.entity.Result;
import com.ego14t.common.entity.ResultEntity;
import com.ego14t.common.exception.XMException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Configuration
public class FeignConfig implements RequestInterceptor, ErrorDecoder {

    /**
     * feign转发请求头,dd
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                requestTemplate.header(name, values);

            }
        }
    }

    @Override
    public Exception decode(String s, Response response) {
        Exception exception = null;
        Gson gson = new Gson();
        String json = null;
        try {
            // 获取原始的返回内容
            json = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResultEntity result = gson.fromJson(json, ResultEntity.class);
        exception = new XMException(result);
        return exception;
    }
}
