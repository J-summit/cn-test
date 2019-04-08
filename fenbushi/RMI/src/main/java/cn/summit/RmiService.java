package cn.summit;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author onlyo
 * @since 2019/4/4 16:55
 */
public interface RmiService extends Remote {

    String testRmiSer(String name) throws RemoteException;

}
