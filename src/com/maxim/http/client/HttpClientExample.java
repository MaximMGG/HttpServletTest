package com.maxim.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientExample {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpCient = HttpClient.newBuilder()
            .version(Version.HTTP_1_1)
            .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                            .GET()
                            .build();
        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                            .POST(HttpRequest.BodyPublishers.ofFile(Path.of("path", "to","file")))
                            .build();
        HttpResponse<String> response = httpCient.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println(response.body());
    }

}
