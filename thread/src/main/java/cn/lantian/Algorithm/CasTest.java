package cn.lantian.Algorithm;

import java.beans.Transient;

/**
 * @author sky
 * @since 2019/8/17 19:05
 * <p>
 * CAS（Compare-And-Swap）算法保证数据操作的原子性。
 * <p>
 * CAS 算法是硬件对于并发操作共享数据的支持。
 * <p>
 * CAS 包含了三个操作数：
 * 　　内存值 V
 * 　　预估值 A
 * 　　更新值 B
 * <p>
 * 当且仅当 V == A 时，V 将被赋值为 B，否则循环着不断进行判断 V 与 A 是否相等。
 */
public class CasTest {

	public static void main(String[] args) {
		System.out.println(String.format("%06d",12));
	}

	private  int value;

	public synchronized int getValue() {
		return value;
	}

	public synchronized int compareAndSwap(int expectVal, int newVal) {
		int oldValue = value;
		if (oldValue == expectVal) {
			this.value = newVal;
		}
		return oldValue;
	}

	public synchronized boolean compareAndSet(int expectVal, int newVal) {
		return expectVal == compareAndSwap(expectVal, newVal);
	}
}
