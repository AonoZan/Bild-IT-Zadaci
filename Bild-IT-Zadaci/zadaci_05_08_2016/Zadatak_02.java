/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_05_08_2016;

public class Zadatak_02 {
	/**
	 * Method for shuffling values of list.
	 * 
	 * @param list of integers of any length. If null is passed as argument then
	 * method returns without shuffling.
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
	 * Method creates deck of cards, shuffles them and asks user to pick one.
	 * If user enters wrong value program asks to try again, if user enters 0 program exits.
	 * When user picks one card from desk progran prints which card user picked.
	 * @param args
	 * @see <a href="http://www.ebooksbucket.com/introduction-to-java-programming-comprehensive-version-b22p277">Introducing to Java(7.4 Case Study: Deck of Cards)</a>
	 * @throws Exception if user enters wrong value for integer
	 */
	public static void main(String[] args) throws Exception {
		// cerate deck and shuffle it
		int[] deckOfCards = new int[52];
		for (int i = 0; i < deckOfCards.length ; i++) {
			deckOfCards[i] = i;
		}
		shuffleList(deckOfCards);
		// debug purpose only (print deck)
//		zadaci_02_08_2016.Zadatak_01.printList(deckOfCards, new String[]{" ", ""}, 2, 10);
//		System.out.println();
		// create list of posible cards(other than numbers) and ranks
		int userPicksCard;
		String[] cards = new String[]{"A", "J", "Q", "K"};
		String[] ranks = new String[]{"Spades", "Hearts", "Diamonds", "Clubs"};
		// prompt user to pick card untill 0 is entered
		System.out.println("Enter which card you wanna pick from deck. (1 - 52)\nEnter 0 to exit program.");
		while (true) {
			try {
				// ask user for card and try to read it from console
				System.out.print("Pick a card: ");
				userPicksCard = zadaci_01_08_2016.Zadatak_02.userInput.nextInt();
				// if user enters 0 exit
				if (userPicksCard == 0) {
					System.out.println("\nExit.");
					break;
				// if user enters wrong value print message that its not existing card
				}else if (userPicksCard < 1 || userPicksCard > 52) {
					throw new Exception("There is no card on " + userPicksCard + " place in deck.\n");
				// determine which card user picked and print it to the console
				}else {
					int card = deckOfCards[userPicksCard - 1] % 13;
					int rank = deckOfCards[userPicksCard - 1] / 13;
					System.out.printf("You pulled card %s with rank %s.\n",
							(card > 0 && card < 10) ? (card + 1 + "") : cards[card/10 + card%10],
							ranks[rank]);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "Try again.");
			}
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
