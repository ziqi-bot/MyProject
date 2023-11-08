package MyProject.ChatRoom;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerTest {
    // this collection is used for store all the online clients
    static ArrayList<Socket> online = new ArrayList<Socket>();  //socket list for clients

    public static void main(String[] args) throws Exception {
        //1.start the server
        ServerSocket serverSocket = new ServerSocket(8989);

        //2.receive messages from clients
        while (true) {
            Socket socket = serverSocket.accept();// blocking method

            online.add(socket);// add new client socket into list(online)

            MessageHandler messageHandler = new MessageHandler(socket);//get current socket message and send it to everyone

            messageHandler.start();// start method from sub-thread, operating run method


        }


    }

    static class MessageHandler extends Thread {
        private Socket socket;

        private String ip;

        public MessageHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            try {
                ip = socket.getInetAddress().getHostAddress();

                //send back online message to others
                sendToOther(ip + " Back online");
                //receive message from current client

                InputStream inputStream = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    sendToOther(ip + ":" + str);
                }
                sendToOther(ip + " Go offline");
            } catch (IOException e) {
                try {
                    sendToOther(ip + " Lost connection");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } finally {
                //remove that client
                online.remove(socket);

            }
        }

        public void sendToOther(String message) throws IOException {
            // send to every client
            for (Socket on : online) {
                OutputStream everySocketStream = on.getOutputStream();
                PrintStream printStream = new PrintStream(everySocketStream);
                printStream.println(message);//use its println method
            }
        }

    }
}