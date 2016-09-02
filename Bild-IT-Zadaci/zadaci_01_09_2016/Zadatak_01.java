
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
	public static void main(String[] args) throws IOException {
		// get file with salary database
		URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
		Scanner fileInput = new Scanner(url.openStream());
		
		ArrayList<Double> salaryAssistant = new ArrayList<Double>();
		ArrayList<Double> salaryAssociate = new ArrayList<Double>();
		ArrayList<Double> salaryFull = new ArrayList<Double>();
		
        // create scanner from file
		while(fileInput.hasNext()) {
			String[] line = fileInput.nextLine().split(" ");
			String rank = line[2];
			String salary = line[3];
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
			System.out.println(salary + " " + rank);
		}

		double sumAssistant = sum(salaryAssistant);
		double sumAssociate = sum(salaryAssociate);
		double sumFull = sum(salaryFull);
		
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
				, sumAssistant
				, sumAssistant / salaryAssistant.size()
				, sumAssociate
				, sumAssociate / salaryAssociate.size()
				, sumFull
				, sumFull / salaryFull.size()
				);
		fileInput.close();
	}

}

