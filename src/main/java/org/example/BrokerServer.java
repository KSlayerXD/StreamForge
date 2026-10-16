package org.example;

import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class BrokerServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting StreamForge Broker....");
        ServerSocket server = new ServerSocket(9092);

        System.out.println("Broker is listening on port 9092");
        Socket client = server.accept();
        InputStream input = client.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = input.read(buffer);
        System.out.println("Producer Connected Successfully");
        client.close();
        server.close();
    }
}
