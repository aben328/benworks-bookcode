package benworks.bookcode.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试 VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOofMemoryError eg: -verbose:gc -Xms20m -Xmx20m -Xmn10m
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author Ben
 */
public class HeapOOM {

	static class OOMObject {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}

}
