package MyProject.TCPandUDP;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    @Test
    public void client() {
        //crate a socket
        Socket socket = null;//
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.79.1");//IP
            int port = 9090;//port number
            socket = new Socket(inetAddress, port);
            // transmit data

            outputStream = socket.getOutputStream();
            outputStream.write("This is data from client.  ".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close Socket
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void server() {
        // create server socket
        int port = 9090;

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(port);

            // accept(), receive client's socket
            socket = serverSocket.accept();
            System.out.println("Server start!");

            System.out.println("Connect with" + socket.getInetAddress().getHostAddress());

            // receive data
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
            System.out.println("Data transmission is completed!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close Socket, ServerSocket
            try {
                if (socket != null) {
                    socket.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
