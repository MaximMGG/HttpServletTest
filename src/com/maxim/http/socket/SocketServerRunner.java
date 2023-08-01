package com.maxim.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        Scanner scan = new Scanner(System.in)) {
            String request = is.readUTF();
            while (!(request.equals("stop"))) {
                System.out.println("Client request: " + request);
                String response = scan.nextLine();
                os.writeUTF(response);
                request = is.readUTF();
            }
        }
    }
}
