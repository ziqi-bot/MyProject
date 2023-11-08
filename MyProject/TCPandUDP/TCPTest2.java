package MyProject.TCPandUDP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TCPTest2 {

    @Test
    public void client() throws IOException {

        //1. create socket
        int port = 9090;
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, port);

        //2. create File instance and FileInputStream instance
        File file = new File("C:\\Users\\DouZi\\Downloads\\SpringBoot.png");
        FileInputStream fileInputStream = new FileInputStream(file);

        //3. get OutPutStream from socket, sent from server
        OutputStream outputStream = socket.getOutputStream();

        //4. write data to local
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        System.out.println("Data has been sent!");

        //client stop sending data, server can start read (prevent deadlock)
        socket.shutdownOutput();


        //5. receive feedback from server
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] newBuffer = new byte[10];
        int newLen;
        while ((newLen = inputStream.read(newBuffer)) != -1) {
            byteArrayOutputStream.write(newBuffer, 0, newLen);
        }
        System.out.println(byteArrayOutputStream.toString());

        //6. close socket and streams
        byteArrayOutputStream.close();
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();

    }

    @Test
    public void Server() throws IOException {
        //1. create server socket
        int port = 9090;
        ServerSocket serverSocket = new ServerSocket(port);

        //2. receive client's socket accept() method
        Socket socket = serverSocket.accept();

        //3. get an input stream from socket
        InputStream inputStream = socket.getInputStream();

        //4. create file and FileOutputStream instance
        File file = new File("C:\\Users\\DouZi\\Downloads\\SpringBoot_newCopy.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //5. read and write process
        byte[] buffer = new byte[1024];
        int len;

        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }
        System.out.println("Data transmission completed!");


        //6. server send feedback to client
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Data has been received by Server!".getBytes());


        //7. close all sockets and streams
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }


}
