package c10;

// : Echo.java
// How to read fro m standard input
import java.io.*;

public class Echo {
	public static void main(String[] args) {
		DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
		String s;
		try {
			while ((s = in.readLine()).length() != 0)
				System.out.println(s);
			// An empty line terminates the program
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} // /:~