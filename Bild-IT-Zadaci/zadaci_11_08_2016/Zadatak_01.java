/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_11_08_2016;

import java.util.Scanner;

public class Zadatak_01 {
	/**
	 * Program asks user for three city names and then prints them sorted.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for three names
		System.out.println("Enter three city names.");
		System.out.print("First city name:");
		String city01 = input.nextLine();
		System.out.print("Second city name:");
		String city02 = input.nextLine();
		System.out.print("Third city name:");
		String city03 = input.nextLine();
		// print city names in alphabetical order
		System.out.println("City's in alphabetical order:");
		if (city01.compareTo(city02) <= 0 && city01.compareTo(city03) <= 0) {		// if first city needs to be printed
			System.out.print(city01 + " ");											//
			if (city02.compareTo(city03) <= 0) {									//
				System.out.println(city02 + " " + city03);							// if then second and third needs to be printed
			} else {																//
				System.out.println(city03 + " " + city02);							// else print third and second
			}
		} else if (city02.compareTo(city01) <= 0 && city02.compareTo(city03) <= 0) {// if second city needs to be printed
			System.out.print(city02 + " ");											//
			if (city01.compareTo(city03) <= 0) {									//
				System.out.println(city01 + " " + city03);							// if first and third needs to be printed
			} else {																//
				System.out.println(city03 + " " + city01);							// else print third and second
			}
		} else {																	// else third needs to be printed
			System.out.print(city03 + " ");											//
			if (city02.compareTo(city01) <= 0) {									//
				System.out.println(city02 + " " + city01);							// if second and first needs to be printed
			} else {																//
				System.out.println(city01 + " " + city02);							// else print first and second
			}
		}
		input.close();
	}
}
