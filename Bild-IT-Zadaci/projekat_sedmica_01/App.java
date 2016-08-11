/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package projekat_sedmica_01;
import java.util.Scanner;
/**
 * Calendar aplication. Uses Month and Reminders classes to read 
 * write and show calendar and reminders.
 */
public class App {
	Scanner input = new Scanner(System.in);
	Month month;
	Reminders reminders;
	private String message = "";
	private StringBuffer display = new StringBuffer();
	private final String TOP_SPACER = "_________________________________________\n";	// used for display
	private final String BOTTOM_SPACER= "-----------------------------------------\n";	//
	// as loong as this is active application should be run
	private boolean active = true;
	// variable that tells which screen to show
	// welcome screen is default(-1)
	int screen = -1;
	
	App(){
		this.month = new Month();
		this.reminders = new Reminders();
		this.month.setReminders(this.reminders.getRemindersCount());
		month.updateMonthDisplay();
	}
	
	public boolean isActive() {
		return active;
	}
	/**
	 * Main loop of the app.
	 * At first run it shows welcome screen and every other run
	 * shows user picked screen.
	 */
	public void run() {
		// clear screen before each menu print
		cls();
		// if default value for the screen (-1) show welcome screen
		// if 1, 2, 3, 4 or 5 run methods for that screen
		// else any other variable sets active to false(exit)
		switch (screen) {
		case -1:
			this.message = ""
					+ "\n"
					+ "\nWelcome to calendar app."
					+ "\nPress enter to proceed."
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n";
			printScreen("Calendar\n", message);
			input.nextLine();
			this.screen = 0;
			break;
		case 0:
			showMenu();
			break;
		case 1:
			showCalendar();
			break;
		case 2:
			showReminder();
			break;
		case 3:
			addReminder();
			break;
		case 4:
			deleteReminders();
			break;
		case 5:
			updateMonth();
			break;
		default:
			active = !active;
			break;
		}
	}
	/**
	 * Method is called each time user is inside menu.
	 */
	private void showMenu() {
		// build menu message for the body and print it on the screen
		this.message = ""
				+ "Menu:\n"
				+ "1 : Show calendar\n"
				+ "2 : Show reminder\n"
				+ "3 : Add reminder\n"
				+ "4 : Delete reminders\n"
				+ "5 : Change month\n"
				+ "6 : Exit\n";
		printScreen("Calendar\n", message);
		this.screen = input.nextInt();		// wait for the user to enter choice
		input.nextLine();					// and clear console
	}
	/**
	 * Method is called when user wants to see calendar for current month.
	 */
	private void showCalendar() {
		int[] yearMonth = month.getYearMonth();									// save list that contains date
		String title  = "	      ";											// move title to the center
		title += Month.getMonthName(yearMonth[1]) + " " + yearMonth[0] + "\n";	// title contains month name and year as number
		this.message = month.getDisplayString();								// get body
		printScreen(title, this.message);										// show title and body
		input.nextLine();														// wait for the user to press enter ant go back to the menu
		this.screen = 0;
	}
	/**
	 * Method is called each time user wants to show all reminders for certain day.
	 */
	private void showReminder() {
		// šprompt user for day, save it and clear screen
		this.message = ""
				+ "\n"
				+ "\nShow reminder for which day (1 " + month.getCurrentMaxDay() + ")."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int day = input.nextInt();
		input.nextLine();
		cls();
		
		this.message = reminders.getReminders(day); // get string that shoows all reminders for that day
		printScreen("Calendar\n", message);			// print all reminders inside body of the app
		input.nextLine();							// wait for the user to press enter and go back to the menu
		this.screen = 0;
	}
	/**
	 * Method is called each time user wants to add reminder for some day.
	 */
	private void addReminder() {
		// prompt user for day, save it and clear screen
		this.message = ""
				+ "\n"
				+ "\nAdd reminder for which day (1 " + month.getCurrentMaxDay() + ")."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int day = input.nextInt();
		input.nextLine();
		cls();
		// prompt user for note and save it
		this.message = ""
				+ "\n"
				+ "\nEnter reminder note."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		String reminder = input.nextLine();
		
		reminders.addReminder(day, reminder);						// create file and append reminder
		this.month.setReminders(this.reminders.getRemindersCount());// update reminders count list
		month.updateMonthDisplay();									// update string that shows whole month
		this.screen = 0;											// go back to the menu
	}
	/**
	 * Method is called each time user wants to delete reminders for certein day.
	 */
	private void deleteReminders() {
		// prompt user for day
		this.message = ""
				+ "\n"
				+ "\nWhich month reminders you want to remove(1 - " + month.getCurrentMaxDay() + ")."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int day = input.nextInt();
		
		this.reminders.removeReminders(day);						// delete file that contains reminders and list of reminders
		this.month.setReminders(this.reminders.getRemindersCount());// reset count of reminders
		month.updateMonthDisplay();									// update string that shows whole month
		this.screen = 0;											// go back to the menu
	}
	/**
	 * Method is called every time current month is changed.
	 */
	private void updateMonth() {
		// prompt user to enter variable for year, save it and clear screen
		this.message = ""
				+ "\n"
				+ "\nEnter value for year."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int year = input.nextInt();
		cls();
		// prompt user to enter variable for month and save it
		this.message = ""
				+ "\n"
				+ "\nEnter value for month(1 - 12)."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int month = input.nextInt();
		
		this.month.updateDate(year, month);							// update list of days for the new month
		this.reminders = new Reminders(new int[]{year, month});		// read reminders from files for the current month
		this.month.setReminders(this.reminders.getRemindersCount());// set count of reminders for each day
		this.month.updateMonthDisplay();							// update string thet shows current month
		this.screen = 0;											// go back to the menu
	}
	/**
	 * Method that wraps title of aplication and body and displays it on the screen.
	 * @param title
	 * @param body
	 */
 	private void printScreen(String title, String body) {
		this.display.setLength(0);
		this.display.append(title
				+ TOP_SPACER);
		this.display.append(body);
		this.display.append(BOTTOM_SPACER);
		System.out.print(this.display);
	}
 	/**
 	 * Method for clearing the screen.
 	 * Call it just before screen updates.
 	 */
 	private void cls() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
 	/**
 	 * Method for closing aplication.
 	 * Call this when done with aplication.
 	 */
	public void exit() {
		input.close();
//		System.out.close();
	}
}
