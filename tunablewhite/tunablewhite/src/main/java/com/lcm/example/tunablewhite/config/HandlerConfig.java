package com.lcm.example.tunablewhite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("handlers.url.iotp")
public class HandlerConfig {


    @Value("${handlers.url.iotp.createdataprofileurl}")
    private String createdataprofileurl;


    @Value("${handlers.url.iotp.getDataProfileUrl}")
    private String getDataProfileUrl;

    public String getCreatedataprofileurl() {
        return createdataprofileurl;
    }

    public String getGetDataProfileUrl() {
        return getDataProfileUrl;
    }
}


