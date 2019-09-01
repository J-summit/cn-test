package cn.lantian.volatiletest;

import lombok.Data;

/**
 * @author sky
 * @since 2019/8/15 22:30
 */
public class VolatileT {
	public static void main1(String[] args) {

		VolThread vo = new VolThread();
		new Thread(vo).start();

		while (true) {
			if (vo.isA()) {
				System.out.println("结束");
				break;
			}
		}
	}

	public static void main(String[] args) {
		int a = 1;
		int b = a;
		a = a + 1;
		System.out.println(b);
	}
}

@Data
class VolThread implements Runnable {
	private volatile boolean a = false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a = true;
		System.out.println("a=" + a);
	}
}