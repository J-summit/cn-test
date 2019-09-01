package cn.lantian.synchronizedCollect;

/**
 * @author sky
 * @since 2019/8/13 22:30
 */
public class SynchrMethod {

	public synchronized void syncTest1() throws InterruptedException {
		System.out.println("执行 syncTest1");
		Thread.sleep(5000);
	}

	public synchronized void syncTest2() throws InterruptedException {
		System.out.println("执行 syncTest2");
		Thread.sleep(5000);
	}

	public  void syncTest3() throws InterruptedException {
		synchronized(SynchrMethod.class){
			System.out.println("执行 syncTest3");
			Thread.sleep(5000);
		}
	}

	public  void syncTest4() throws InterruptedException {
		synchronized(SynchrMethod.class){
			System.out.println("执行 syncTest4");
			Thread.sleep(5000);
		}
	}
}
