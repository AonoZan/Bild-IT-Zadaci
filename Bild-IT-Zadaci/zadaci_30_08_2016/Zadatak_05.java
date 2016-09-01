
package zadaci_30_08_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Method processes string that contains numbers and returns sum and average. */
	public static int[] getSumAverage(String content) {
		// variables for sum and number count
		int sum = 0, count = 0;
		content = content.replace("\n", " ").replace("\r", " ");
		// loop over list of numbers as string
		System.out.println(content.split(" ").length);
		for (String number : content.split(" ")) {
			try {
				// try to parse number, count it and add to sum
				System.out.println(count + " :" + number + ": " + sum);
				int num = Integer.valueOf(number);
				count++;
				sum += num;
			} catch (Exception e) {
				// if error skip that number
				continue;
			}
		}
		// return sum and average (sum/count)
		return new int[] {sum, sum / count};
	}
	/**
	 * Program asks from user file path of number list.
	 * Calculates sum and average from file and prints it.
	 */
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
        // read whole file
		String content = fileInput.useDelimiter("\\Z").next();
		// get sum and average and print it
		int[] stats = getSumAverage(content);
		System.out.printf("Sum is: %d\nAverage is: %d\n", stats[0], stats[1]);
		
		fileInput.close();
		input.close();
	}
}

