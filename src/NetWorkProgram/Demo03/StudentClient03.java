package NetWorkProgram.Demo03;
import java.io.*;
import java.net.Socket;

public class StudentClient03 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        ObjectOutputStream oos = null;
        InputStream in = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            Student student = new Student(101,"xiaowenbin",23);
            out = socket.getOutputStream();//用装饰模式将其包装
            //将输出流转为对象流
            oos = new ObjectOutputStream(out);
            oos.writeObject(student);//发送对象
            socket.shutdownOutput();//结束发送

            //接收服务端的数据 （字符串）
            in = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("收到的来自服务端的信息为"+info);
            }
            socket.shutdownInput();

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

