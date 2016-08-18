
package zadaci_18_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * 
	 * @param m
	 * @param columnIndex
	 * @return
	 */
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for (int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];
		}
		return sum;
	}
	public static void main(String[] args) {

	}

}

