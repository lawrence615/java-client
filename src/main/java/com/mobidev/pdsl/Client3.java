package com.mobidev.pdsl;

import org.springframework.stereotype.Component;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.Security;

@Component
public class Client3 {


    private SSLSocket socketClient;
    private PrintWriter out;
    private BufferedReader in;

    public void connect() throws IOException {
        Security.addProvider(
                new com.sun.net.ssl.internal.ssl.Provider());
        SSLSocketFactory factory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        socketClient = (SSLSocket) factory.createSocket("41.204.194.188", 8902);
        out = new PrintWriter(socketClient.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        if (socketClient.isConnected()) {
            System.out.println("Client3: " + "Connection Established");
        }
    }

    public String send(String message) throws IOException {
        out.println(message);
        out.flush();
        System.out.println("Message3: " + message);

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
