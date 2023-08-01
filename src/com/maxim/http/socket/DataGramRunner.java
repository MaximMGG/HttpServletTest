package com.maxim.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DataGramRunner {
    public static void main(String[] args) throws IOException {
        InetAddress byName = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, byName, 7777);
            datagramSocket.send(packet);
        }
    }
}
