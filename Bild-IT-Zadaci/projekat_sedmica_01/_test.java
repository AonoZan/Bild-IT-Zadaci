/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_01;

public class _test {
	/**
	 * Louncher for application.
	 * @param args
	 */
	public static void main(String[] args) {
		// create app and run it while is acsive
		App aplication = new App();
		while(aplication.isActive()) {
			aplication.run();
		}
		aplication.exit();
	}
}
