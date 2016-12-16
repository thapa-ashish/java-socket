package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wizard on 11/19/16.
 */
public class ClientListner extends Thread {

    private Socket client;
    private ServerSocket socket = null;
    private final int port = 4000;

    public ClientListner(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = socket.accept();
                System.out.println(client.getInetAddress().getHostAddress() + " is connecting at " + port);
                PrintStream output = new PrintStream(client.getOutputStream());
                output.print("Hello ???? write anything you want to say to server..");
                output.flush();


                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String line = reader.readLine();
                System.out.println(line);


                ProcessBuilder processBuilder = new ProcessBuilder("notepad");
                Process process = processBuilder.start();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
