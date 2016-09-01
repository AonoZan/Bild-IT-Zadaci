
package zadaci_31_08_2016;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Program creates large database of employees salary and writes it to the file.*/
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		final String RANK_0 = "assistant";
		final String RANK_1 = "associate";
		final String RANK_2 = "full";
		// write file Salary.txt in current directory
		PrintWriter writer = new PrintWriter(
				System.getProperty("user.dir")
				+ "\\zadaci_31_08_2016\\Salary.txt", "UTF-8");
		// new buffer for
		StringBuffer line = new StringBuffer();
		int amount = 100;
		for (int i = 1; i <= amount; i++) {
			// reset line and append new employee name
			line.setLength(0);
			line.append(String.format("FirstName%-4d LastName%-4d ", i, i));
			// generate new random rank and salary based on the rank
			int random = (int)(Math.random() * 3);
			String rank = null;
			double salary = 0;
			switch (random) {
				case 0:
					rank = RANK_0;
					salary = 50000 + Math.random() * 30000;
					break;
				case 1:
					rank = RANK_1;
					salary = 60000 + Math.random() * 50000;
					break;
				case 2:
					rank = RANK_2;
					salary = 75000 + Math.random() * 65000;
					break;
				default:
					break;
			}
			// add rank and salary to the line and write it
			line.append(String.format("%-9s %.2f\n", rank, salary));
			writer.write(line.toString());
		}
		writer.close();
	}
}

