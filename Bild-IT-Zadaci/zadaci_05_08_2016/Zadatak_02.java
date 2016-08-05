/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_02 {
	/**
	 * Method for shuffling values of list.
	 * 
	 * @param list
	 *            of integers of any length. If null is passed as argument then
	 *            method returns without shuffling.
	 */
	public static void shuffleList(int[] list) {
		// if argument is wrong exit
		if (list == null) {
			System.out.println("Can't shuffle list(null argument).");
			return;
		}
		// create random index go trough whole list and swap values
		int randomIndex;
		for (int i = 0; i < list.length; i++) {
			randomIndex = (int) (Math.random() * list.length);
			list[i] += list[randomIndex];
			list[randomIndex] = list[i] - list[randomIndex];
			list[i] -= list[randomIndex];
		}
	}

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// cerate deck and shuffle it
		int[] deckOfCards = new int[52];
		for (int i = 0; i < deckOfCards.length ; i++) {
			deckOfCards[i] = i + 1;
		}
		shuffleList(deckOfCards);
		zadaci_02_08_2016.Zadatak_01.printList(deckOfCards, new String[]{" ", ""}, 2, 10);
		System.out.println();
		int userPicksCard;
		System.out.println("Enter which card you wanna pick from deck. (1 - 52)\nEnter 0 to exit program.");
		while (true) {
			try {
				System.out.print("Pick a card: ");
				userPicksCard = zadaci_01_08_2016.Zadatak_02.userInput.nextInt();
				if (userPicksCard == 0) {
					System.out.println("\nExit.");
					System.exit(0);
				}else if (userPicksCard < 1 || userPicksCard > 52) {
					System.out.printf("There is no card on %d place in deck.", userPicksCard);
					throw new Exception();
				}else {
					System.out.printf("You picked card: %d\n", deckOfCards[userPicksCard - 1]);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
