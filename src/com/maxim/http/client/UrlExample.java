package com.maxim.http.socket.client;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        File path = new File("src/com/maxim/http/socket/DataGramRunner.java");
        URL url = new URL("file:" + path.getAbsolutePath());
        URLConnection openConnection = url.openConnection();

        System.out.println(new String(openConnection.getInputStream().readAllBytes()));

    }

    private static void checkGoogle() throws MalformedURLException, IOException {
        URL url = new URL("https://www.google.cam");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (OutputStream os = urlConnection.getOutputStream()) {
        }
    }
}
