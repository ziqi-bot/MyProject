package MyProject.ChatRoom;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientTest {
    public static void main(String[] args) throws Exception {

        //1.connect to the server
        Socket socket = new Socket("127.0.0.1", 8989);

        //2.create two threads. one for receiving message from the server
        Receive receive = new Receive(socket);
        receive.start();


        //2.create two threads. the other one for sending message to the server
        Send send = new Send(socket);
        send.start();

        send.join();// close current main thread after sending message(sub thread for send)

        socket.close();// main thread


    }


}


class Send extends Thread {
    private Socket socket;

    public Send(Socket socket) {
        super();
        this.socket = socket;
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);  // type in my message

            OutputStream outputStream = socket.getOutputStream();

            PrintStream printStream = new PrintStream(outputStream); //print

            while (true) {
                System.out.println("My messages:");   // keep sending my messages until bye
                String str = input.nextLine();// blocking methods
                if ("bye".equals(str)) {
                    break;
                }
                printStream.println(str);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


class Receive extends Thread {

    private Socket socket;


    public Receive(Socket socket) {
        super();
        this.socket = socket;
    }


    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner input = new Scanner(inputStream);

            while (input.hasNextLine()){
                String line=input.nextLine();
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

