package NetWorkProgram.Demo01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        BufferedReader bufferedReader = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();//一直阻塞，直到有客户端连接
            System.out.println("客户端连接成功");

            //通过socket生成inputStream/outputStream（准备发送数据）
            //字节流
            in = socket.getInputStream();
            //转化为字符流，可以不转的，但是转化为字符流的化，效率会高一点
            //带缓冲区的字符流 （字节流->转换流->字符流）
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String info = null;
            //客户端会不停的发消息，所以使用循环
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是server，接收到客户端的消息是"+info);
            }
            socket.shutdownInput();
            //服务器做出反馈
            out = socket.getOutputStream();
            out.write("welcome client".getBytes());
            socket.shutdownOutput();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                //关闭的原则，最后写的先关闭
                if (out != null) {
                    out.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
