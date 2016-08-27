
package zadaci_27_08_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	public static boolean contains(ArrayList<Integer> list, int i) {
		if (list == null || list.size() == 0) return false;
		for (Integer integer : list) {
			if (integer == i) return true;
		}
		return false;
	}
	public static void removeDuplicate(ArrayList<Integer> list) {
		// create list to store all unique numbers
		ArrayList<Integer> unique = new ArrayList<>();
		// loop over list
		for (int i = 0; i < list.size(); i++) {
			// get item at current iteration
			int item = list.get(i);
			// if item is uniqiue
			if (!contains(unique, item)) {
				// add to both lists
				unique.add(item);
				list.add(item);
				// loop back
				i--;
			}
			// remove first item from list
			list.remove(0);
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(0);
		list.add(4);
		list.add(4);
		list.add(5);
		removeDuplicate(list);
		Zadatak_02.print(list);
	}

}

