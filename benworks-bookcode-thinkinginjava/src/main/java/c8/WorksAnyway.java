package c8;

import java.util.Vector;

class Mouse {
	private int mouseNumber;

	Mouse(int i) {
		mouseNumber = i;
	}

	// Magic method:
	public String toString() {
		return "This is Mouse #" + mouseNumber;
	}

	void print(String msg) {
		if (msg != null)
			System.out.println(msg);
		System.out.println("Mouse number " + mouseNumber);
	}
}

class MouseTrap {
	static void caughtYa(Object m) {
		Mouse mouse = (Mouse) m; // Cast from Object
		mouse.print("Caught one!");
	}
}

public class WorksAnyway {
	public static void main(String[] args) {
		Vector mice = new Vector();
		for (int i = 0; i < 3; i++)
			mice.addElement(new Mouse(i));
		for (int i = 0; i < mice.size(); i++) {
			// No cast necessary, automatic call
			// to Object.toString():
			System.out.println("Free mouse: " + mice.elementAt(i));
			MouseTrap.caughtYa(mice.elementAt(i));
		}
	}
} // /:~
