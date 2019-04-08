package cn.summit;

import java.rmi.RemoteException;

/**
 * @author onlyo
 * @since 2019/4/4 16:56
 */
public class RmiServiceImpl implements RmiService{

    public RmiServiceImpl() throws RemoteException{
    }

    @Override
    public String testRmiSer(String name) throws RemoteException {
        return "Zzzz!!"+name;
    }
}
