package NetWorkProgram.Demo02;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class StudentClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        ObjectOutputStream oos = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            Student student = new Student(101,"xumingyang",23);
            out = socket.getOutputStream();//用装饰模式将其包装
            //将输出流转为对象流
            oos = new ObjectOutputStream(out);
            oos.writeObject(student);//发送对象
            socket.shutdownOutput();//结束发送

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (out != null) {
                    out.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
