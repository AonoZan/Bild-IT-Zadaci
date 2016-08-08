/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;

public class _test {
	public static void main(String[] args) {
		App aplication = new App();
		while(aplication.isActive()) {
			aplication.run();
		}
		aplication.exit();
		
	}
}
