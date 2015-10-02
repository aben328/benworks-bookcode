package c10;

// : FreezeAlien.java
// Create a serialized output file
import java.io.*;

// 用于创建和序列化一个 Alien 对象的文件位于相同的目录下：
public class FreezeAlien {
	public static void main(String[] args) throws Exception {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.x"));
		Alien zorcon = new Alien();

		out.writeObject(zorcon);
	}
} // /:~
