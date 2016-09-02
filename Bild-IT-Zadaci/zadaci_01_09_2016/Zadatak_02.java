
package zadaci_01_09_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	public static void printOccurences(String content) {
		int[] chars = new int[128];
		for (char ch : content.toCharArray()) {
			if (ch < 128) {
				chars[ch]++;
			}
		}
		for (int i = 'A'; i <= 'Z'; i++) {
			if (chars[i] > 0) {
				System.out.printf("Character \'%c\' have occured %d time%s.\n", (char) (i), chars[i],
						chars[i] > 1 ? "'s" : "");
			}
		}
		for (int i = 'a'; i <= 'z'; i++) {
			if (chars[i] > 0) {
				System.out.printf("Character \'%c\' have occured %d time%s.\n", (char) (i), chars[i],
						chars[i] > 1 ? "'s" : "");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		// initialize variables with temporary values
		String filepath = "";
		File file = new File(filepath);
		Scanner fileInput = input;

		while (true) {
			try {
				// get file path from user and create file from that
				System.out.println("Enter filepath: ");
				filepath = input.nextLine();
				file = new File(filepath);
				if (!file.exists()) {
					// file doesn't exist loop again
					System.out.println("\nFile doesn't exist!\n");
					continue;
				} else {
					// create file scanner
					fileInput = new Scanner(file);
				}
				break;
			} catch (Exception e) {
				System.exit(0);
			}
		}
        // read whole file and print occurrences
		String content = fileInput.useDelimiter("\\Z").next();
		printOccurences(content);
		
		fileInput.close();
		input.close();
	}

}

