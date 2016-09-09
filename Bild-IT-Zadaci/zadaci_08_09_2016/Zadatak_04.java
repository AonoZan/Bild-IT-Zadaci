
package zadaci_08_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Method finds max item in 2D list. */
	public static <E extends Comparable<E>> E max(E[][] list) {
		// constant for zero
		final int ZERO = 0;
		// if list is null or empty return null
		if (list == null || list.length == ZERO) return null;
		// create item and search list for first valuable item
		E item = null, rowMax;
		for (E[] es : list) {
			// if row is not null
			if (es != null) {
				// set item for first one in list and break
				item = es[ZERO];
				break;
			}
		}
		// loop over list
		for (E[] es : list) {
			// get max item in a row
			rowMax = Zadatak_03.max(es);
			// if row max is not null and is larger set item to rowMax
			if (rowMax != null && rowMax.compareTo(item) > 0) item = rowMax;
		}
		
		return item;
	}
	/** Program creates 2D list and prints largest item in list.*/
	public static void main(String[] args) {
		// create list of items
		Double[][] list = new Double[][]
				{ {0.0, 1.0, 2.0}
				, {2.0, 7.0, 2.0}
				, {14.0, 6.0, 4.0}
				, {21.0, 7.0, 7.0}
				};
		// find max and print it
		Double max = max(list);
		System.out.println("Max element in a list is: " + max);
	}
}

