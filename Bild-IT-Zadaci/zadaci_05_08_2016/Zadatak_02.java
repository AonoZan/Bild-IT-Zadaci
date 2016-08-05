/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_02 {
	public static void shuffleList(int[] list) {
		if (list == null) {
			System.out.println("Can't shuffle list(null argument).");
			return;
		}
		int randomIndex;
		for (int i = 0; i < list.length; i++) {
			randomIndex = (int)(Math.random() * list.length);
			list[i] += list[randomIndex];
			list[randomIndex] = list[i] - list[randomIndex];
			list[i] -= list[randomIndex];
		}
	}
	public static void main(String[] args) throws Exception {
		// cerate deck and shuffle it
		int[] deckOfCards = new int[52];
		for (int i = 0; i < deckOfCards.length ; i++) {
			deckOfCards[i] = i + 1;
		}
		shuffleList(deckOfCards);
		zadaci_02_08_2016.Zadatak_01.printList(deckOfCards, new String[]{" ", ""}, 2, 10);
	}
}
