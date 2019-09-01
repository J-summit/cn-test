package cn.lantian.synchronizedCollect;

/**
 * @author sky
 * @since 2019/8/13 22:31
 */
public class SynchrMethodTest {
	public static void main(String[] args) throws InterruptedException {
		SynchrMethod m1 = new SynchrMethod();
		SynchrMethod m2 = new SynchrMethod();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("开始");
					m1.syncTest3();
					System.out.println("结束");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		m2.syncTest4();

		System.out.println("end");
	}
}
