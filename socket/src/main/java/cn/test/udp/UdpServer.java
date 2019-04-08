package cn.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author onlyo
 * @since 2019/3/4 20:59
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        //1.ip地址+端口号
        DatagramSocket ds = new DatagramSocket(8080);

        System.out.println("启动udp服务。。。");
        byte[] b =new byte[1024];
        DatagramPacket bp = new DatagramPacket(b,b.length);
        ds.receive(bp);

        System.out.println(bp.getAddress()+":"+bp.getPort()+"数据:"+new String(bp.getData(),0,bp.getLength()));
        ds.close();

    }
}
