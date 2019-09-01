package cn.lantian.InterruptTest;

/**
 * @author sky
 * @since 2019/8/10 17:40
 */
public class MyRunnable implements Runnable {
	private volatile Boolean flag = true;

	public void setFlag(Boolean flag) {
		this.flag = flag;

		//MyRunnable1 myRunnable1
		MyRunnable1 myRunnable1 = new MyRunnable1();
		String a = "MyRunnable1+myRunnable1";
	}

	@Override
	public void run() {
		System.out.println("线程开始:" + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (flag) {

		}
		System.out.println("线程退出:" + Thread.currentThread().getName());
	}
}
