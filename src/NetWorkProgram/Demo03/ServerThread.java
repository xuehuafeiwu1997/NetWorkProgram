package NetWorkProgram.Demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //接收客户端数据
        InputStream in = null;
        ObjectInputStream ois = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            ois = new ObjectInputStream(in);
            Student student = (Student) ois.readObject();
            System.out.println(Thread.currentThread().getName() + "子线程" + student.getName());
            socket.shutdownInput();

            //给客户端反馈
            out = socket.getOutputStream();
            out.write("已收到".getBytes());
            socket.shutdownOutput();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (ois != null) {
                    ois.close();
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
