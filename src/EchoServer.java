import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
   服务端 服务器类
 */
public class EchoServer {
    //服务器使用的类
    private ServerSocket serverSocket;
    public EchoServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    获取bufferedReader包装类
     */
    private BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /*
    获取printWriter包装类
     */
    private PrintWriter getWriter(Socket socket) throws IOException {
        //没写一行自动刷新
        return new PrintWriter(socket.getOutputStream(),true);
    }
}
