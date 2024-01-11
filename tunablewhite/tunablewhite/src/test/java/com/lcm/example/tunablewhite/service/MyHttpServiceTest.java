package com.lcm.example.tunablewhite.service;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.when;
public class MyHttpServiceTest {

    @Test
    void testFetchData() throws Exception {
        // Arrange
        String url = "http://example.com";
        String responseBody = "Mocked response";
        String token = "some token";

        // Mock HttpClient and HttpResponse
        HttpClient mockedHttpClient = Mockito.mock(HttpClient.class);
        HttpResponse<String> mockedResponse = Mockito.mock(HttpResponse.class);
                //HttpResponse.BodyHandlers.ofString();
               // createResponse(responseBody);
        CompletableFuture<HttpResponse<String>> responseFuture = CompletableFuture.completedFuture(mockedResponse);

        when(mockedHttpClient.sendAsync(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(responseFuture);

        // Create an instance of MyHttpService
        MyHttpService myHttpService = new MyHttpService();

        // Act
        CompletableFuture<String> resultFuture = myHttpService.fetchData(url);
        String result = resultFuture.join();

        // Assert
        assertEquals(responseBody, result);

        // Verify that the appropriate methods with the expected parameters were called
        HttpRequest expectedHttpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", token)
                .GET()
                .build();

        Mockito.verify(mockedHttpClient).sendAsync(eq(expectedHttpRequest), eq(HttpResponse.BodyHandlers.ofString()));
    }

    private HttpResponse<String> createResponse(String msg){
return  null;
    }
}

