
package zadaci_18_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	public static boolean isConsecutiveFour(int[] values) {
		for (int i = 0; i < values.length - 4; i++) {
			if (values[i] == values[i+1] &&
					values[i] == values[i+2] &&
					values[i] == values[i+3]) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isConsecutiveFour(new int[]{1,1,1,21,2,5,4,8, 8, 8, 8,7,9,7,8}));
	}

}

