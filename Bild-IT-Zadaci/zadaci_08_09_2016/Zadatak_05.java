
package zadaci_08_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Method searches list for key index using binary search approach. */
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		// set low and high index
		int low = 0;
		int high = list.length - 1;
		// loop until low and high don't cross in value
		while (high >= low) {
			// get midle index based on low and high
			int mid = (high - low) / 2 + low;
			// if key matches value on midle index return that index
			if (list[mid].compareTo(key) == 0) return mid;
			// when value on mid index is higher than key
			// search lower half of the list
			// else search higher half of the list
			if (list[mid].compareTo(key) > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// return -1 if value is not found
		return -1;
	}
	/** Program creates sorted list and searches for key value using binary search approach. */
	public static void main(String[] args) {
		// create sorted list
		Integer[] list = new Integer[] {1, 2, 3, 4, 5};
		// find key value index and print it.
		int index = binarySearch(list, 4);
		System.out.println("Index of 4 is: " + index);
		
	}
}

