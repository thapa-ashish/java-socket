package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        int port=4000;
        ServerSocket socket= null;
        try {
            socket = new ServerSocket(port);
            while(true){
                Socket client=socket.accept();
                System.out.println(client.getInetAddress().getHostAddress()+ " is connecting at "+port);
                PrintStream output=new PrintStream(client.getOutputStream());
                output.print("Hello ??? write anything you want to say to server..");
                output.flush();


                BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
                String line=reader.readLine();
                System.out.println(line);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

	// write your code here
    }
}
