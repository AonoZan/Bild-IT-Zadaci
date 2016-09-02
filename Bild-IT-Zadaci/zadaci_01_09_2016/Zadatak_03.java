
package zadaci_01_09_2016;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int year = 0;
		while (year < 2010 || year > 2010) {
			try {
				System.out.println("Enter year: ");
				year = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		// get file with baby names
		File file = new File(System.getProperty("user.dir") + "\\zadaci_01_09_2016\\babyNames" + year + ".txt");
		Scanner fileInput = new Scanner(file);
		// create array for baby names (male and female)
		ArrayList<String[]> babiesMale = new ArrayList<>();
		ArrayList<String[]> babiesFemale = new ArrayList<>();
		// loop until EOF
		while(fileInput.hasNext()) {
			// read line in list of strings
			String[] line = fileInput.nextLine().split(" ");
			// separate names and popularity strings
			babiesMale.add(new String[]{line[0], line[1]});
			babiesFemale.add(new String[]{line[2], line[3]});
		}
		
		input.close();
		fileInput.close();
	}

}

