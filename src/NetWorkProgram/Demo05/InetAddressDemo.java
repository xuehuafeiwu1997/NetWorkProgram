package NetWorkProgram.Demo05;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            //获取本地主机地址
            InetAddress host = InetAddress.getLocalHost();
            System.out.println("当前主机的地址为"+host);
            //获取网络任意主机地址
            InetAddress host163 = InetAddress.getByName("www.163.com");
            System.out.println(host163);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
