
package zadaci_08_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/** Method finds largest item in a list using compareTo() method. */
	public static <E extends Comparable<E>> E max(E[] list) {
		// constant for zero
		final int ZERO = 0;
		// if list is null or empty return null
		if (list == null || list.length == ZERO) return null;
		// get first item from list as starting
		E item = list[ZERO];
		// compare all items in list and update item if larger is found
		for (E e : list) {
			if (e.compareTo(item) > 0) item = e;
		}
		return item;
	}
	/** Method creates list and finds max item in a list. */
	public static void main(String[] args) {
		Integer[] list = new Integer[]{1, 2, 3, 7, 1, 2, 3};
		System.out.println("Max item in list is : " + max(list));
		
	}
}

