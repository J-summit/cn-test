package cn.lantian.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author onlyo
 * @since 2019/1/27 11:00
 */
public class ConditionCommunTest {
    public static void main(String[] args) {
        Condi1 condi1 = new Condi1();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                condi1.sub2(i);
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                condi1.sub3(i);
            }
        }).start();
        for (int i = 0; i <10 ; i++) {
            condi1.main(i);
        }
    }


    static class Condi1{
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        Integer flag = 2;

        public void sub2(int i ) {
            lock.lock();
            while (flag != 2){
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10 ; j++) {
                System.out.println("sub2:"+j+":index"+i);
            }
            flag =3;
            c3.signal();
            lock.unlock();
        }

        public void sub3(int i ) {
            lock.lock();
            while (flag != 3){
                try {
                    c3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10 ; j++) {
                System.out.println("sub3:"+j+":index"+i);
            }
            flag =1;
            c1.signal();
            lock.unlock();
        }

        public void main(int i ) {
            lock.lock();
            while (flag != 1){
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < 10 ; j++) {
                System.out.println("main:"+j+":index"+i);
            }
            flag =2;
            c2.signal();
            lock.unlock();
        }
    }
}
