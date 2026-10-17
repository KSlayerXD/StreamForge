package org.example;

import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class BrokerServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting StreamForge Broker....");

        ServerSocket server = new ServerSocket(9092);

        ArrayList<String> list = new ArrayList<>();

        System.out.println("Broker is listening on port 9092");

        while(true){
            Socket client = server.accept();
            System.out.println("Client Connected Successfully");


        InputStream input = client.getInputStream();

        byte[] buffer = new byte[1024];

        int bytesRead = input.read(buffer);

        if(bytesRead != -1){
            String message = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
           if(message.startsWith("PRODUCE:")){
               String actualMessage = message.substring(8);
               list.add(actualMessage);
               System.out.println("Recieved Message: "+ actualMessage);
               System.out.println("Stored Messages: "+ list);

           } else if(message.equals("CONSUME")){
               System.out.println("Consumer command Detected!");
           }else {
               System.out.println("Unkwon Command!");
           }
        }
        client.close();
        }

    }
}
