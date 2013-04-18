package benworks.bookcode.jcip.c10;

public class LeftRightDeadlock {
	private final Object left = new Object();
	private final Object right = new Object();
	
	public void leftRight(){
		synchronized (left) {
			synchronized (right) {
				System.out.println("do Something leftRight!");
			}
		}
	}
	
	public void rightLeft(){
		synchronized (right) {
			synchronized (left) {
				System.out.println("do Something rightLeft!");
			}
		}
	}
	
}
