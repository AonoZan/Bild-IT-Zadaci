
package zadaci_31_08_2016;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	
	public static void main(String[] args) throws IOException {
		// get scores from web address and open url stream
		URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
		Scanner fileInput = new Scanner(url.openStream());
        // read whole file and count words
		String content = fileInput.useDelimiter("\\Z").next();
		int[] stats = zadaci_30_08_2016.Zadatak_05.getSumAverage(content);
		// print word count
		System.out.printf("Sum is: %d\nAverage is: %d\n", stats[0], stats[1]);
		
		fileInput.close();
	}

}

