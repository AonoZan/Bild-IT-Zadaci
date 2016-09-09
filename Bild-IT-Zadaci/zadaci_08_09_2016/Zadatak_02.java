
package zadaci_08_09_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method searches list for key. If nothing found -1 is returned. */
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		// loop over all items with index and if key matches any return index
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(key)) {
				return i;
			}
		}
		// return -1 if nothing found
		return -1;
	}
	/** Program creates simple string list and searches for index of some key. */
	public static void main(String[] args) {
		// create list and add few items
		String[] list = new String[]
				{ "Doboj"
				, "Banja Lika"
				, "Mostar"
				, "Pribava"
				, "Modrica"
				, "Tuzla"
				};
		// create key for search
		String key = "Mostar";
		// print index of the key
		System.out.printf("%s is on index: ", key);
		System.out.println(linearSearch(list, key));
	}
}

