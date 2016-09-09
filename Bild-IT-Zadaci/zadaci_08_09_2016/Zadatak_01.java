
package zadaci_08_09_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Method that cleans list from duplicates. */
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		// create new list
		ArrayList<E> newList = new ArrayList<E>();
		// loop over items and add only unique items from list 
		for (E e : list) {
			if (!newList.contains(e)) {
				newList.add(e);
			}
		}
		return newList;
	}
	/** Method prints list. */
	public static <E> void print(ArrayList<E> list) {
		for (E e : list) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	/** Program creates list and prints it with duplicates removed. */
	public static void main(String[] args) {
		// create list and add few items
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(8);
		list.add(7);
		
		// print list
		System.out.print("List: ");
		print(list);
		
		// remove duplicates
		list = removeDuplicates(list);
		
		// print again
		System.out.print("Cleaned: ");
		print(list);
		
	}
}

