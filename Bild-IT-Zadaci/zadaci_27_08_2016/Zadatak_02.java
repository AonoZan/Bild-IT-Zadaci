
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**Method for printing whole list.*/
	public static void print(ArrayList<Integer> list) {
		// for each integer print it with space
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		// go to next line
		System.out.println();
	}
	/**Method for sorting an array list.*/
	public static void sort(ArrayList<Integer> list) {
		final int OFFSET = 1;
		for (int i = 0; i < list.size() - OFFSET; i++) {
			boolean finished = true;
			for (int j = 0; j < list.size() - i - OFFSET; j++) {
				if (list.get(j) > list.get(j + OFFSET)) {
					Integer tmp = list.get(j);
					list.set(j, list.get(j + OFFSET));
					list.set(j + OFFSET, tmp);
					finished = false;
				}
			}
			if (finished) return;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		final int LENGTH = 5;
		System.out.println("Enter 5 integer values.");
		for (int i = 0; i < LENGTH; i++) {
			try {
				System.out.printf("Enter %d value: ", i);
				list.add(input.nextInt());
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		// sort and print list
		System.out.print("Sorted list: ");
		sort(list);
		print(list);
		
		input.close();
	}
}

