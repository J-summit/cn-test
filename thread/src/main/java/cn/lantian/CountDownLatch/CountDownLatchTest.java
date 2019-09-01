package cn.lantian.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author sky
 * @since 2019/8/7 10:46
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);

		latch.countDown();
		inf[] infs = new inf[0];
		Thread thread = Thread.currentThread();
		thread.start();
		System.out.println(System.getProperty("sun.arch.data.model"));
		aa t = new aa();

	}
}
