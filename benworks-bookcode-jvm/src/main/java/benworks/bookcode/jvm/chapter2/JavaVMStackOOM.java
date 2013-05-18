package benworks.bookcode.jvm.chapter2;

/**
 * VM args: -Xss2M
 * @author Ben
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {

		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
