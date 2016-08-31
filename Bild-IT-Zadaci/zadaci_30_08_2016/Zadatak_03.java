
package zadaci_30_08_2016;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Method reformats java source code. */
	public static String formatSC(String sourceCode) {
		// convert from next-line style to end-line style format
		sourceCode = sourceCode.replace("\n{", " {");
		sourceCode = sourceCode.replace("\n\t{", " {");
		sourceCode = sourceCode.replace("\n {", " {");
		sourceCode = sourceCode.replace("\n  {", " {");
		return sourceCode;
	}
	/** 
	 * Program converts next line style java source code to end line style.
	 * Source code filename is taken from parameters.
	 */
	public static void main (String[] args) throws IOException {
		// get filename from parameters and create file
        File file = new File(args[0]);
        Scanner fileInput = new Scanner(file);
        // read whole file and print formated
		String content = fileInput.useDelimiter("\\Z").next();
		System.out.println(formatSC(content));
		
		fileInput.close();
    }

}

