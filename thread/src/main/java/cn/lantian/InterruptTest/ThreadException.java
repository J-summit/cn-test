package cn.lantian.InterruptTest;

/**
 * @author sky
 * @since 2019/8/10 22:05
 */
public class ThreadException implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("自定义线程出错。。");
	}
}
