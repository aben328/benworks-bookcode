package benworks.bookcode.wsjc.suggestion18;

import java.util.Date;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean b1 = "String" instanceof Object;
		boolean b2 = new String() instanceof String;
		boolean b3 = new Object() instanceof String;
		// boolean b4 = "A" instanceof Character;
		boolean b5 = null instanceof String;
		boolean b6 = (String) null instanceof String;
		// boolean b7 = new Date() instanceof String;
		boolean b8 = new GenericClass<String>().isDateInstance("");
		
	}
}

class GenericClass<T> {
	// 判断是否是Date类型
	public boolean isDateInstance(T t) {
		return t instanceof Date;
	}
}