package cn.lantian.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sky
 * @since 2019/8/17 18:41
 */
public class zixuanLock {

	private AtomicReference<Thread> flag = new AtomicReference<>();


	public void lock() {
		Thread current = Thread.currentThread();
		//如果预期值是null 则set current 返回true
		while (!flag.compareAndSet(null, current)) {
			Thread.yield();
		}
	}

	public void unlock() {
		Thread current = Thread.currentThread();
		//设置为空
		flag.compareAndSet(current, null);
	}
}
