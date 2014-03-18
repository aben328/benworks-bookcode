package benworks.bookcode.wsjc.suggestion31;

/**
 * @author Ben
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B.s.doSomething();
	}

}

interface B {
	public final S s = new S() {
		public void doSomething() {
			System.out.println("我在接口中实现 ！");
		}
	};
}

interface S {
	public void doSomething();
}