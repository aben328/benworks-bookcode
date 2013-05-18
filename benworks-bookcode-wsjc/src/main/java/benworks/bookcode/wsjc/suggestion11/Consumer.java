/**
 * 
 */
package benworks.bookcode.wsjc.suggestion11;

import benworks.bookcode.wsjc.utils.SerializationUtils;

/**
 * @author Ben
 */
public class Consumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 反序列化
		Person p = (Person) SerializationUtils.readObject();
		System.out.println("name=" + p.getName());
	}

}
