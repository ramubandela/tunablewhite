package com.lcm.example.tunablewhite.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcm.example.tunablewhite.TunablewhiteApplication;
import com.lcm.example.tunablewhite.config.HandlerConfig;
import com.lcm.example.tunablewhite.model.DataProfile;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.UUID;
import   java.net.http.HttpRequest;
@Service
@Transactional
public class LCMService {

   // private static final Logger log = LoggerFactory.getLogger(LCMService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HandlerConfig handlerConfig;

    public DataProfile saveDataProfile(DataProfile dataProfile) {



        System.out.println(handlerConfig.getCreatedataprofileurl()+"......getCreatedataprofileurl");
        String url=String.format(handlerConfig.getCreatedataprofileurl(), "root","saveDataProfile");
        System.out.println(url+"......url");

        HttpHeaders httpHeaders=new HttpHeaders();
        //httpHeaders.set("Authorization","some token");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity httpEntity=new HttpEntity(dataProfile,httpHeaders);

        ResponseEntity<DataProfile> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, DataProfile.class);

        return exchange.getBody();

    }

    public DataProfile getDataProfile(String dataProfileId){

        System.out.println(handlerConfig.getGetDataProfileUrl()+"......getGetDataProfileUrl");
        String url=String.format(handlerConfig.getGetDataProfileUrl(), "root","getProfile")+"/"+dataProfileId;
        System.out.println(url+"......geturl");

        HttpHeaders httpHeaders=new HttpHeaders();
        //httpHeaders.set("Authorization","some token");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        DataProfile dataProfile=null;
        HttpClient client=HttpClient.newHttpClient();
       // HttpRequest  httpRequest=HttpRequest.new
       HttpRequest httpRequest = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "some token")
                .GET()
                .build();
        HttpResponse<String> response=null;
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
           // HttpClient client=HttpClient.newHttpClient();
         response=client.send(httpRequest,HttpResponse.BodyHandlers.ofString());
         if(!ObjectUtils.isEmpty(response)){
             if(response.statusCode()==HttpStatus.OK.value()){
                 if(response.body() !=null){
                     dataProfile=objectMapper.readValue(response.body(), new TypeReference<DataProfile>(){} );
                 }
             }
         }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
return dataProfile;
    }


}
