
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
	/** Method retrieves score for person in list*/
	public static String getScore(String name, ArrayList<String[]> list) {
		// create rank
		int rank = 1;
		// loop for each string list from array
		for (String[] strings : list) {
			// if name is found retrieve score
			if (strings[0].equals(name)) return rank + " with score " + strings[1];
			rank++;
		}
		return "not found";
	}
	/** Program is search engine for baby name popularity. */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		// create year and prompt user for value
		int year = 0;
		while (year < 2010 || year > 2010) {
			try {
				// get year
				System.out.print("Enter year: ");
				year = input.nextInt();
			} catch (InputMismatchException e) {
				// wrong input ask again
				System.out.println("Please enter number.");
			}
			// clean console
			input.nextLine();
		}
		// get file with baby names
		File file = new File(System.getProperty("user.dir") + "\\zadaci_01_09_2016\\babyNames" + year + ".txt");
		Scanner fileInput = new Scanner(file);
		// create array for baby names (male and female)
		ArrayList<String[]> babiesMale = new ArrayList<>();
		ArrayList<String[]> babiesFemale = new ArrayList<>();
		// loop until EOF
		do {
			// read line in list of strings
			String[] line = fileInput.nextLine().split(" ");
			// separate names and popularity strings
			babiesMale.add(new String[]{line[0], line[1]});
			babiesFemale.add(new String[]{line[2], line[3]});
			
		}while(fileInput.hasNext());
		// create variables for statistics
		String gender = null, name = null, score = null;
		while(true) {
			try {
				// if gender not set
				if (gender == null) {
					// ask for gender
					System.out.print("Enter baby gender: ");
					gender = input.nextLine();
					// if gender is invalid reset and ask again
					if (!gender.equals("F") && !gender.equals("M")) {
						System.out.println("Invalid geneder.");
						gender = null;
						continue;
					}
				}
				// ask for baby name
				System.out.print("Enter baby name: ");
				name = input.nextLine();
				// get baby score based on name
				switch (gender) {
				case "M":
					score = getScore(name, babiesMale);
					break;
				case "F":
					score = getScore(name, babiesFemale);
					break;
				default:
					break;
				}
				// print statistics
				System.out.printf("In year %d baby name %s ranked #%s.\n"
						, year
						, name
						, score);
				// ask if user wants to search more
				System.out.print("Search more? (true false)");
				boolean search = input.nextBoolean();
				if (search) {
					gender = null;
					continue;
				}
				// exit
				break;
			} catch (Exception e) {
				break;
			}
		}
		
		input.close();
		fileInput.close();
	}

}

