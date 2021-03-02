package NetWorkProgram.Demo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//网络编程传递对象的实现
public class StudentServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        ObjectInputStream ois = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();

            //接收客户端发来的对象
            in = socket.getInputStream();
            ois = new ObjectInputStream(in);
            Student student = (Student)ois.readObject();
            System.out.println(student.getName());
            socket.shutdownInput();
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
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
