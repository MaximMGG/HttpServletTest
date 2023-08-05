package com.maxim.http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {
    
    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            pocessSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pocessSocket(Socket socket) {
        try (socket;
        InputStream inputSrream = new DataInputStream(socket.getInputStream());
        OutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            // step 1 handle request
            System.out.println("Request: " + new String(inputSrream.readNBytes(400)));
            // step 2 handle response
            byte[] body = Files.readAllBytes(Path.of("resources", "example.html"));
            byte[] headers = "HTTP/1.1 200 OK content-type: test/html content-length: %s".formatted(body.length).getBytes();
                //   byte[] headers= """
                //         HTTP/1.1 200 OK
                //         content-type: text/html
                //         content-length: %s
                //     """.formatted(body.length).getBytes();
                    outputStream.write(headers);
                    // outputStream.write(System.lineSeparator().getBytes());
                    outputStream.write(body);
        } catch (IOException e) {
            // TODO: 05.08. log error message
            e.printStackTrace();
        }
    }
    
}
