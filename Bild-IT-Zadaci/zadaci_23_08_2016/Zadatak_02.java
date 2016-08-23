
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {

	public static void main(String[] args) {

	}

}
class MyInteger {
	private int value;
	
	public boolean isEven() {
		return this.value % 2 == 0 ? true : false;
	}
	public boolean isOdd() {
		return !isEven();
	}
}
