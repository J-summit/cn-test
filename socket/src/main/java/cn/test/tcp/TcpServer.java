package cn.test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author onlyo
 * @since 2019/3/5 22:01
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("tcp 服务启动");
        ServerSocket ss = new ServerSocket(8080);

        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();

        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println("收到+++++" + new String(b, 0, len));

        ss.close();
    }
}
