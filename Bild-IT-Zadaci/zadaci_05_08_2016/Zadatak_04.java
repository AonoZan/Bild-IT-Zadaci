/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_04 {
	public static int[] reverse(int[] list) throws Exception {
		if (list == null) {
			System.out.println("Cant reverse list(null as argument)");
			return null;
		}
		for (int i = 0; i < list.length/2; i++) {
			list[i] += list[list.length - i - 1];
			list[list.length - i - 1] = list[i] - list[list.length - i - 1];
			list[i] -= list[list.length - i - 1];
		}
//		System.out.println(list.length);
//		zadaci_01_08_2016.Zadatak_04.printList(list);
		return list;
	}
	public static void main(String[] args) {
		try {
			System.out.println("Enter 10 numbers(0 to stop)");
			int[] userNumbers = zadaci_01_08_2016.Zadatak_05.fillListFromConsoleInput(new int[10]);
			userNumbers = zadaci_01_08_2016.Zadatak_05.cleanList(userNumbers, 0);
			zadaci_01_08_2016.Zadatak_04.printList(userNumbers);
			userNumbers = reverse(userNumbers);
//			System.out.println(userNumbers[0] + " " + userNumbers[1]);
			zadaci_01_08_2016.Zadatak_04.printList(userNumbers);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
