
package zadaci_01_09_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method prints occurrences of each letter in a string */
	public static void printOccurences(String content) {
		// constant for limit (ignore every char above this)
		final int MAX_CHAR = 128;
		// create list of chars
		int[] chars = new int[MAX_CHAR];
		// go trough whole string and count chars
		for (char ch : content.toCharArray()) {
			if (ch < MAX_CHAR) {
				chars[ch]++;
			}
		}
		// print all counts (if any) for chars A to Z
		for (int i = 'A'; i <= 'Z'; i++) {
			if (chars[i] > 0) {
				System.out.printf("Character \'%c\' have occured %d time%s.\n"
						, (char) (i), chars[i]
						, chars[i] > 1 ? "'s" : "");
			}
		}
		// print all counts (if any) for chars a to z
		for (int i = 'a'; i <= 'z'; i++) {
			if (chars[i] > 0) {
				System.out.printf("Character \'%c\' have occured %d time%s.\n"
						, (char) (i), chars[i]
						, chars[i] > 1 ? "'s" : "");
			}
		}
	}
	/** Program asks from user file path and counts each character occurrences. */
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

