
package zadaci_31_08_2016;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Method counts words from string. */
	public static int countWords(String content) {
		int count = 0;
		// loop over all lines
		for (String line : content.split("\n")) {
			// loop over all words from spliced line
			for (String word : line.split(" ")) {
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
		}
		return count;
	}
	/** 
	 * Program counts words from Lincoln speech. 
	 * @throws IOException 
	 * @see <a href="http://stackoverflow.com/questions/6259339/how-to-read-a-text-file-directly-from-internet-using-java">How to read files from web</a>
	 */
	public static void main(String[] args) throws IOException {
		// get Lincoln's file and create scanner from that file
		URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
		Scanner fileInput = new Scanner(url.openStream());
        // read whole file and count words
		String content = fileInput.useDelimiter("\\Z").next();
		int count = countWords(content);
		// print word count
		System.out.println("Word count is: " + count);
		
		fileInput.close();
	}
}

