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
            socketClient = new Socket("41.204.194.188", 8902);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String write(String message) {
        try {
            if (socketClient.isConnected()) {
                System.out.println("Client: " + "Connection Established");
                System.out.println("Message: \n" + message);


                //create input stream attached to socket
                InputStream in = socketClient.getInputStream(); // read data from server
                OutputStream out = socketClient.getOutputStream();// write data to the server


                out.write(message.getBytes());
                out.flush();

                byte[] response = new byte[65535];
                in.read(response);

                System.out.println("Received from server - " + new String(response).trim());

                return new String(response).trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketClient.close();
                System.out.println("Connection closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public String write2(String message) {
        String displayBytes;
        try {
            if (socketClient.isConnected()) {
                System.out.println("Client: " + "Connection Established");


                //create input stream attached to socket
                DataInputStream inFromServer = new DataInputStream(socketClient.getInputStream());
//                InputStream in = socketClient.getInputStream(); // read data from server
                OutputStream out = socketClient.getOutputStream();// write data to the server


                out.write(message.getBytes());
                out.flush();

//                byte[] response = new byte[65535];
//                in.read(response);

//                System.out.println("Received from server - " + new String(response).trim());

//                socketClient.close();

                while ((displayBytes = inFromServer.readUTF()) != null) {
                    System.out.print(displayBytes);
                    return displayBytes;
                }

                return displayBytes;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
