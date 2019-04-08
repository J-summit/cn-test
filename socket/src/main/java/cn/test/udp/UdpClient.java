package cn.test.udp;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.val;

import java.io.IOException;
import java.net.*;

/**
 * @author onlyo
 * @since 2019/3/4 20:58
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        byte[] b = "upd 发送".getBytes();
        DatagramPacket dp = new DatagramPacket(b,b.length, InetAddress.getByName("127.0.0.1"),8080);
        ds.send(dp);
        ds.close();
    }
}
