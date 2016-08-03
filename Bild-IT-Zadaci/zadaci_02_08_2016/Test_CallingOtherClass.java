/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;
/**
 * Simpl class that tests call from other class
 * @author AonoZan
 *
 */
class ClassToBeCalled {
	public static void main(String[] args) {
		// if there is no argument exit program
		if (args == null || args.length == 0) {
			System.exit(0);
		}
		// for each argument as a new string print it
		for (String string : args) {
			System.out.println(string);
		}
	}
}
/**
 * Main class that is called automaticaly because its public.
 * This class then makes simple string list and calls other class in this same file.
 * @author AonoZan
 *
 */
public class Test_CallingOtherClass {
	public static void main(String[] args) {
		// create simple string list with few items
		String[] stringList = new String[]{"apple", "orange", "bannana"};
		// call other class and pass string list as a argument
		ClassToBeCalled.main(stringList);
	}
}