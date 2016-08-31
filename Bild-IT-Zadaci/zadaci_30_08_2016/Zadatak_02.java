
package zadaci_30_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method hacks... */
	public static void hackCB() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 548; j++) {
				for (int j2 = 0; j2 < 9875; j2++) {
					if (j2 > i + j) {
						throw new OutOfMemoryError("Eclipse is out of memory!!"
								+ "\nAbort!! ");
					}
				}
			}
		}
	}
	/**
	 * Program tries to hack unfortunately eclipse will always lose memory in this care.
	 * Do not attempt! :)
	 */
	public static void main(String[] args) {
		// try to hack4¢¢
		try {
			hackCB();
		} catch (OutOfMemoryError e) {
			System.out.println(e.getMessage());
		}
	}

}

