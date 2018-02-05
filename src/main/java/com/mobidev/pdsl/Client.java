package com.mobidev.pdsl;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

@Component
public class Client {

    private Socket socketClient;

    @PostConstruct
    public void connectToServer() {
        connect();
    }

    private void connect() {
        try {
            socketClient = new Socket("127.0.0.1", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String write(String message) {
        try {
            if (socketClient.isConnected()) {
                System.out.println("Client: " + "Connection Established");


                InputStream in = socketClient.getInputStream(); // read data from server
                OutputStream out = socketClient.getOutputStream();// write data to the server


                out.write(message.getBytes());

                byte[] response = new byte[1024];
                in.read(response);

                System.out.println("Received from server - " + new String(response).trim());

                socketClient.close();


                return new String(response).trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
