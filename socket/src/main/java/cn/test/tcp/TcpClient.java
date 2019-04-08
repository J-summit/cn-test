package cn.test.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author onlyo
 * @since 2019/3/5 22:03
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        Socket ss = new Socket("127.0.0.1",8080);
       OutputStream os =  ss.getOutputStream();
       os.write("tcp Client 连接".getBytes());
       ss.close();

    }
}
