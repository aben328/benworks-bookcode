//: PrintFile.java
// Shorthand class for opening an output file
// for human-readable output.

package com.bruceeckel.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintFile extends PrintStream {
	public PrintFile(String filename) throws IOException {
		super(new BufferedOutputStream(new FileOutputStream(filename)));
	}

	public PrintFile(File file) throws IOException {
		this(file.getPath());
	}
} // /:~
