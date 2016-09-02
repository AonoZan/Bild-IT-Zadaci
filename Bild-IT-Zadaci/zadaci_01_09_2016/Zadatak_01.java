
package zadaci_01_09_2016;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	// calculate sum of a list
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		for (Double double1 : list) {
			sum += double1;
		}
		return sum;
	}
	/** Program reads database from file and calculates sum and average for salary. */
	public static void main(String[] args) throws IOException {
		// get file with salary database
		URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
		Scanner fileInput = new Scanner(url.openStream());
		// create separate array list for each rank of faculty members
		ArrayList<Double> salaryAssistant = new ArrayList<Double>();
		ArrayList<Double> salaryAssociate = new ArrayList<Double>();
		ArrayList<Double> salaryFull = new ArrayList<Double>();
		// loop until EOF
		while(fileInput.hasNext()) {
			// read line in list of strings
			String[] line = fileInput.nextLine().split(" ");
			// rank is third chunk and salary fourth
			String rank = line[2];
			String salary = line[3];
			// based on which rank this line is add to appropriate list salary
			switch (rank) {
				case "assistant":
					salaryAssistant.add(Double.parseDouble(salary));
					break;
				case "associate":
					salaryAssociate.add(Double.parseDouble(salary));
					break;
				case "full":
					salaryFull.add(Double.parseDouble(salary));
					break;
	
				default:
					break;
			}
		}
		// calculate sum for each rank
		double sumAssistant = sum(salaryAssistant);
		double sumAssociate = sum(salaryAssociate);
		double sumFull = sum(salaryFull);
		// calculate average
		double averageAssistant = sumAssistant / salaryAssistant.size();
		double averageAssociate = sumAssociate / salaryAssociate.size();
		double averageFull = sumFull / salaryFull.size();
		// calculate total for whole database
		double sumTotal = sumAssistant + sumAssociate + sumFull;
		double averageTotal = sumTotal / (salaryAssistant.size()
										+ salaryAssociate.size()
										+ salaryFull.size());
		// print status formated
		System.out.printf
				( "Status for assistants:\n"
				+ "\ttotal: %.2f\n"
				+ "\taverage %.2f\n"
				+ "Status for associate:\n"
				+ "\ttotal: %.2f\n"
				+ "\taverage %.2f\n"
				+ "Status for full:\n"
				+ "\ttotal: %.2f\n"
				+ "\taverage %.2f\n"
				+ "\t\tTotal:\n"
				+ "\t\t  total: %.2f\n"
				+ "\t\t  average %.2f\n"
				, sumAssistant
				, averageAssistant
				, sumAssociate
				, averageAssociate
				, sumFull
				, averageFull
				, sumTotal
				, averageTotal
				);
		fileInput.close();
	}

}
