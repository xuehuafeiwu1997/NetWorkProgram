package NetWorkProgram.Demo05;

import jdk.internal.util.xml.impl.Input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlConnection = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            url = new URL("https://www.163.com/");
            urlConnection = url.openConnection();
            in = urlConnection.getInputStream();//输入到内存
//            out = urlConnection.getOutputStream();//从内存输出  这样写是错的，输入流是从url到内存，这样写是从内存输出到url
            out = new FileOutputStream("/Users/xumingyang/Desktop/test.txt ");
            byte[] bytes = new byte[64];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                System.out.println(new String(bytes));
                out.write(bytes,0,len);//从内存出去
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
