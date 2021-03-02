package NetWorkProgram.Demo01;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream in = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            OutputStream out = socket.getOutputStream();
            out.write("hello,server".getBytes());

            //报错，这里必须告诉服务器这边停止输出了
            socket.shutdownOutput();
            //接收服务端的反馈
            in = socket.getInputStream();
            //字节流转换为字符流
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("接收到服务器信息" + info);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
