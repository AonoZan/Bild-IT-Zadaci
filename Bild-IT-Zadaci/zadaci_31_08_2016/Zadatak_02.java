
package zadaci_31_08_2016;

import java.io.File;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method checks path from argument and lists all java files with package prefix.*/
	public static void listJavaFiles(File folder) {
		// loop trough all entries in folder
	    for (File fileEntry : folder.listFiles()) {
	    	// get last index of dot (extension is after dot)
	    	int i = fileEntry.getName().lastIndexOf('.');
	    	String ext = null;
	    	if (i > 0) {// get extension
	    	    ext = fileEntry.getName().substring(i+1);
	    	}
	    	// if entry is file and extension is java
	        if (fileEntry.isFile() && ext.toLowerCase().equals("java")) {
	        	// print package and filename
	            System.out.println(folder.getName() + "." + fileEntry.getName());
	        }
	    }
	}
	
	/**
	 *  Program lists all java files with package declaration. Path to the
	 *  directory is taken from first argument.
	 */
	public static void main(String[] args) {
		// get filename from parameters and create file
		File folder = new File(args[0]);
		if (!folder.isDirectory()) {
			System.out.println("Argument:\n" + args[0] + "\nis not directory...");
			System.exit(0);
		}
		listJavaFiles(folder);
	}
}

