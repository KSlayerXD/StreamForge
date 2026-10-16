package org.example;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Producer {
    public static void main(String[] args) throws IOException{
        System.out.println("Starting StreamForge Producer...");
    Socket socket = new Socket("localhost", 9092);
        OutputStream output = socket.getOutputStream();
        String message = "Hello from StreamForge Producer";
        output.write(message.getBytes(StandardCharsets.UTF_8));
        System.out.println("Connected to StreamForge Broker!");
        socket.close();
    }
}
