package com.maxim.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws UnknownHostException, IOException {

        InetAddress byName = Inet4Address.getByName("localhost");

        try (Socket socket = new Socket(byName, 7777);
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                DataInputStream is = new DataInputStream(socket.getInputStream());
                Scanner scan = new Scanner(System.in)) {
            while (scan.hasNextLine()) {
                String request = scan.nextLine();
                os.writeUTF(request);
                System.out.println("Response from server : " + is.readUTF());
            }
        } catch (Exception e) {
            System.out.println("Coonection was closed");
        }
    }
}
