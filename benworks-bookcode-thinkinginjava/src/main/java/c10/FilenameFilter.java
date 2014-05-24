package c10;

import java.io.File;

public interface FilenameFilter {

	boolean accept(File dir, String name);

}