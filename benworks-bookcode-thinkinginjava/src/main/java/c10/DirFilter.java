package c10;

import java.io.File;
import java.io.FilenameFilter;

class DirFilter implements FilenameFilter {
	String afn;

	DirFilter(String afn) {
		this.afn = afn;
	}

	public boolean accept(File dir, String name) {
		// Strip path information:
		String f = new File(name).getName();
		return f.indexOf(afn) != -1;
	}
} // /:~