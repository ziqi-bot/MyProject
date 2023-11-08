package MyProject.TCPandUDPandURL;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {

    @Test
    public void sender() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();

        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        byte[] bytes = "This is sender!".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inetAddress, 9090);
        datagramSocket.send(packet);
        datagramSocket.close();
    }

    @Test
    public void receiver() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024 * 64];     //less than 64kb
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        datagramSocket.receive(packet);

        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println(str);
        datagramSocket.close();


    }


}
