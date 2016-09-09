
package zadaci_08_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	public static <E extends Comparable<E>> E max(E[] list) {
		final int ZERO = 0;
		if (list == null || list.length == ZERO) return null;
		E item = list[ZERO];
		for (E e : list) {
			if (e.compareTo(item) > 0) item = e;
		}
		return item;
	}
	public static void main(String[] args) {
		Integer[] list = new Integer[]{1, 2, 3, 7, 1, 2, 3};
		System.out.println("Max item in list is : " + max(list));
		
	}
}

