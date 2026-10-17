package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Consumer {
    public static void main(String[] args) throws IOException {
        System.out.println("System Steamforge Consumer...");

        Socket socket = new Socket("localhost", 9092);

        OutputStream output = socket.getOutputStream();

        String command = "CONSUME";

        output.write(command.getBytes(StandardCharsets.UTF_8));

        System.out.println("Consumer Connected To Broker!");

        socket.close();



    }
}
