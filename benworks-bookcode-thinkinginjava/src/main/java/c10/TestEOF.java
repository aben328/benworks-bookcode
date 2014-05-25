//: TestEOF.java
// Testing for the end of file while reading
// a byte at a time.
package c10;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
	public static void main(String[] args) {
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream("TestEof.java")));
			while (in.available() != 0)
				System.out.print((char) in.readByte());
		} catch (IOException e) {
			System.err.println("IOException");
		}
	}
} // /:~
