package cn.lantian.InterruptTest;

/**
 * @author sky
 * @since 2019/8/10 17:40
 */
public class MyRunnable1 implements Runnable {

	@Override
	public void run() {


		System.out.println("线程开始:" + Thread.currentThread().getName());
//		try {

//			this.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		int a = 3 / 0;

		System.out.println("线程退出:" + Thread.currentThread().getName());
	}

//	private void myRun1() {
//		for(int i=0; i<500000; i++){
//			if(this.interrupted()) {
//				System.out.println("线程已经终止， for循环不再执行");
//				throw new InterruptedException();
//			}
//			System.out.println("i="+(i+1));
//		}
//
//	}
}
