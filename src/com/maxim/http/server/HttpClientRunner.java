package com.maxim.http.server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientRunner {
    
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        HttpClient httpCient = HttpClient.newBuilder()
                            .version(HttpClient.Version.HTTP_1_1)
                            .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                            .uri(URI.create("http://localhost:9000"))
                            .header("content-type", "application/json")
                            .POST(HttpRequest.BodyPublishers.ofFile(Path.of("resources", "first.json")))
                            .build();

        CompletableFuture<HttpResponse<String>> response = httpCient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response2 = httpCient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response3 = httpCient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        // System.out.println(response.headers());
        // System.out.println(response.body());
        System.out.println(response3.get().body());
    }
}
