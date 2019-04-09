package cn.summit.javaapi;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author onlyo
 * @since 2019/4/9 14:28
 */
public class CreateSeesionDemo implements Watcher {
    private static String CONNECTING = "192.168.43.130:2181,192.168.43.160:2181,192.168.43.192:2181,192.168.43.222:2181";
    private static CountDownLatch cdl = new CountDownLatch(1);
    private static ZooKeeper zoo;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zoo = new ZooKeeper(CONNECTING, 5000, new CreateSeesionDemo());
        cdl.await();
        zoo.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zoo.getData("/test", new CreateSeesionDemo(), stat);
        zoo.setData("/test", "test1".getBytes(), -1);
        TimeUnit.SECONDS.sleep(2000);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                cdl.countDown();
                System.out.println("None:" + watchedEvent.getState() + "-->" + watchedEvent.getType());
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println("node 数据修改：" + watchedEvent.getPath() + "->改变后的值：" +
                            zoo.getData(watchedEvent.getPath(), true, stat));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                //子节点的数据变化会触发
                try {
                    System.out.println("子节点数据变更路径：" + watchedEvent.getPath() + "->节点的值：" +
                            zoo.getData(watchedEvent.getPath(), true, stat));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                //创建子节点的时候会触发
                try {
                    System.out.println("节点创建路径：" + watchedEvent.getPath() + "->节点的值：" +
                            zoo.getData(watchedEvent.getPath(), true, stat));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {//子节点删除会触发
                System.out.println("节点删除路径：" + watchedEvent.getPath());
            }
            System.out.println(watchedEvent.getType());
        }
    }
}
