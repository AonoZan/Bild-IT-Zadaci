
package zadaci_08_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method searches list for key. */
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
	}
}

