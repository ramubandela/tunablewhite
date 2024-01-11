package com.lcm.example.tunablewhite.service;

import com.lcm.example.tunablewhite.config.HandlerConfig;
import jdk.internal.net.http.HttpClientBuilderImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import java.io.IOException;
import java.net.http.HttpClient;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest({ HttpClient.class})

public class LCMServiceTest {

    @InjectMocks
    private LCMService lcmService;

    @Mock
    HandlerConfig handlerConfig;


    @Test
    public void getDataProfileTest(){
        String url="localhost:8080";

       // HttpClient httpClient=mock(HttpClient.class);
        PowerMockito.mockStatic(HttpClient.class);

        HttpClient.Builder impl= mock(HttpClient.Builder.class);
        when(handlerConfig.getGetDataProfileUrl()).thenReturn(url);
        when(HttpClient.newHttpClient()).thenReturn(null);
        //.newHttpClient();
        lcmService.getDataProfile("");

    }



}

/*{
        "state": "DRAFT",
        "tags": [
        "demo-test-25"
        ],
        "dataDefinition": {
        "dataItems": [
        {
        "data": {
        "schedule": {
        "id": 1,
        "action": {
        "type": "Tunable White Setpoint",
        "payload": {
        "dim level": 254,
        "lights_ct": 250,
        "transition_time": 60
        }
        },
        "recurrence": {
        "time": {
        "time": 1641027600000
        },
        "weekdays": [
        "Sunday"
        ]
        }
        }
        },
        "schemaIdentity": "device-management: distributed-scheduling-test7:1"
        }
        ]
        },
        "dataProfileIdentity": "device-management:aff9058c-c86d:1"
        }*/
