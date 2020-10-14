package com.loatr.learning;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class SocketClientTest {

    public void startClient(){
        try{
            Socket socket = new Socket("127.0.0.1",8081);
//            socket.bind(new InetSocketAddress("127.0.0.1",8081));
            InputStream in = new BufferedInputStream(socket.getInputStream());
            OutputStream out = new BufferedOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while(true){
//                String line = scanner.nextLine();
                String line = "test";
                out.write(line.getBytes());
                out.flush();
                byte[] data = new byte[512];
                in.read(data);
                String res = new String(data);
                System.out.println("response:" + res);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }
}
