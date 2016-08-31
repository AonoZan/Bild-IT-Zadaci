
package zadaci_30_08_2016;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** 
	 * Program take file path and string from arguments.
	 * Program then reads file using file path and removes all occurrences in the file.
	 */
	public static void main (String[] args) throws IOException {
		// check if arguments are correct
		if (args.length != 2) {
			System.out.println("Wrong arguments length. Exit.");
			System.exit(0);
		}
		// get filename from parameters and create file
		File file = new File(args[1]);
		// exit if file doesn't exist
		if (!file.exists()) {
			System.out.println("File doesnt exist! Exit.");
			System.exit(0);
		}
        Scanner fileInput = new Scanner(file);
        // read whole file and print formated
		String content = fileInput.useDelimiter("\\Z").next();
		content.replace(args[0], "");
		
		// create new writer and write content to the file
		PrintWriter writer = new PrintWriter(args[1], "UTF-8");
		writer.print(content);
		
		writer.close();
		fileInput.close();
    }

}

