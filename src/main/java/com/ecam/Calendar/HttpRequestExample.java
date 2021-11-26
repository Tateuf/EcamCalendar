package com.ecam.Calendar;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class HttpRequestExample {

    public HttpRequestExample() throws IOException, InterruptedException, URISyntaxException {
    }

    private static final String POSTS_API_URL="https://jsonplaceholder.typicode.com/posts";

    HttpClient client = HttpClient.newBuilder().build();

    URI uri = new URIBuilder(POSTS_API_URL)
            //.addParameter("param1", "value1")
            //.addParameter("param2", "value2")
            .build();

    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build();

    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

    public void Print(){
        System.out.println(response.body());
    }

    
}
