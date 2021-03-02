package NetWorkProgram.Demo04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLException;

public class UdpReceive {
    public static void main(String[] args) {
        byte[] data = new byte[64];
        DatagramSocket datagramSocket = null;
        //准备接收数据的对象
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
        try {
            //接收数据
            datagramSocket = new DatagramSocket(9999);
            datagramSocket.receive(datagramPacket);

            //显示接收到的数据 将字节转换成字符串
            String receiveData = new String(datagramPacket.getData(),0,data.length);
            System.out.println("接收到的数据:"+receiveData);
            System.out.println("显示发送方的信息"+datagramPacket.getAddress().getHostAddress());

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
