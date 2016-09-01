
package zadaci_31_08_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Method counts words from string. */
	public static int countWords(String content) {
		int count = 0;
		// loop over all words from spliced string
		for (String word : content.split(" ")) {
			// loop over characters in word
			for (char ch : word.toCharArray()) {
				// if alphabetical character is found
				// then count as word and move on
				if (Character.isAlphabetic(ch)) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	/** Program counts words from Lincoln speech. */
	public static void main(String[] args) throws FileNotFoundException {
		// get Lincoln's file and create scanner from that file
		File lincolnF = new File("http://cs.armstrong.edu/liang/data/Lincoln.txt");
		Scanner fileInput = new Scanner(lincolnF);
        // read whole file and count words
		String content = fileInput.useDelimiter("\\Z").next();
		int count = countWords(content);
		// print word count
		System.out.println("Word count is: " + count);
		
		fileInput.close();
	}
}

