package cn.lantian.synchronizedCollect;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sky
 * @since 2019/8/14 9:03
 */
public class InnterClazz {
	private String id;

	private static String name;

	public class clazz1 {
		public clazz1() {
					id = "id";
			name = "name";
		}
	}

	public static void main(String[] args) {


		InnterClazz i = new InnterClazz();
		clazz1 a = i.new clazz1();
	}
}
