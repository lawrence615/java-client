package com.mobidev.pdsl;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Component
public class Client2 {

    private Socket socketClient;
    private PrintWriter out;
    private BufferedReader in;

    public String connect(String message) throws IOException {
        socketClient = new Socket("41.204.194.188", 8902);
        out = new PrintWriter(socketClient.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        if (socketClient.isConnected()) {
            System.out.println("Client2: " + "Connection Established");

            return send(message);
        }

        return "Connection failed";
    }

    public String send(String message) throws IOException {
        out.println(message);
        out.flush();
        System.out.println("Message2: " + message);

        String resp = in.readLine();
        System.out.println("Response3: " + resp);
        return resp;
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socketClient.close();
    }
}
