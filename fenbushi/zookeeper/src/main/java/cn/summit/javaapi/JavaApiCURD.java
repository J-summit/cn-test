package cn.summit.javaapi;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author onlyo
 * @since 2019/4/9 15:01
 */
public class JavaApiCURD {

    private static String CONNECTING = "192.168.43.130:2181,192.168.43.160:2181,192.168.43.192:2181,192.168.43.222:2181";
    private static CountDownLatch cdl = new CountDownLatch(1);
    private static ZooKeeper zoo;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zoo = new ZooKeeper(CONNECTING, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    cdl.countDown();
                    System.out.println(zoo.getState());
                }
            }
        });
        cdl.await();


        zoo.create("/node", "321".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }
}
