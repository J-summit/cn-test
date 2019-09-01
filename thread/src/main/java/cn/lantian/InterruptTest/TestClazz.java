package cn.lantian.InterruptTest;

/**
 * @author sky
 * @since 2019/8/10 17:42
 */
public class TestClazz {

	public static void main(String[] args) throws Exception {
		//test1();
		//test2();
		test3();
	}

	public static void test3() throws InterruptedException {
		MyRunnable1 myRunnable = new MyRunnable1();
		Thread thread = new Thread(myRunnable, "interrupt-Thread");
		thread.setUncaughtExceptionHandler(new ThreadException());
		thread.start();
		thread.interrupt();
//		thread.getUncaughtExceptionHandler()
	}

	public static void test2() throws InterruptedException {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "volatile-Thread");
		thread.start();

		Thread.sleep(2000);
		myRunnable.setFlag(false);
	}

	/**
	 * 测试线程 stop终止线程
	 * <p>
	 * 太霸道了，直接终止正在运行的，正在执行的线程直接中断 会导致某些数据的只操作了一半 而且并不知道 执行到哪一步
	 */
	public static void test1() throws InterruptedException {
		Thread thread = new Thread(new MyRunnable(), "stop-Thread");
		thread.start();

		Thread.sleep(2000);
		thread.stop();
	}
}
