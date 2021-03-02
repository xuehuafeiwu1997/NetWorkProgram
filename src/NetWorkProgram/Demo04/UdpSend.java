package NetWorkProgram.Demo04;

import java.io.IOException;
import java.net.*;
import java.sql.SQLException;

public class UdpSend {
    public static void main(String[] args) {
        InetAddress ip = null;
        DatagramSocket socket = null;
        try {
            ip = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String msg = "Hello,Server...";
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),msg.length(),ip,9999);
        try {
            socket = new DatagramSocket();
            socket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            //因为udp是无链接的，所以不需要关闭链接,只需要关闭收发器
            if (socket != null) {
                socket.close();
            }
        }

    }
}
