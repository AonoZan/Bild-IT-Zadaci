/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;
import java.util.Scanner;

public class App {
	Scanner input = new Scanner(System.in);
	Month month;
	Reminders reminders;
	private boolean active = true;
	private String remindersPath = System.getProperty("user.dir") + "\\notes\\", message = "";
	private StringBuffer display = new StringBuffer();
	private final String TOP_SPACER = "_________________________________________\n";
	private final String BOTTOM_SPACER= "-----------------------------------------\n";
	int screen = -1;
	
	App(){
		this.month = new Month();
		this.reminders = new Reminders();
	}
	
	public boolean isActive() {
		return active;
	}
	public void run() {
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
		case 0:
			showMenu();
		case 1:
			showCalendar();
		case 5:
			updateMonth();
			this.screen = 1;
		}
	}
	private void showCalendar() {
		int[] yearMonth = month.getYearMonth();
		String title  = "	      ";
		title += Month.getMonthName(yearMonth[1]) + " " + yearMonth[0] + "\n";
		this.message = month.getDisplayString();
		printScreen(title, this.message);
		input.nextLine();input.nextLine();
	}
	private void updateMonth() {
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
		this.message = ""
				+ "\n"
				+ "\nEnter value for month(0 - 11)."
				+ "\nPress enter to proceed."
				+ "\n"
				+ "\n"
				+ "\n"
				+ "\n";
		printScreen("Calendar\n", message);
		int month = input.nextInt();
		this.month.updateDate(year, month);
		this.screen = 0;
		
	}
	private void showMenu() {
		this.message = ""
				+ "Menu:\n"
				+ "1 : Show calendar\n"
				+ "2 : Show reminders\n"
				+ "3 : Add reminder\n"
				+ "4 : Remove reminder\n"
				+ "5 : Change month\n"
				+ "0 : Exit\n"
				+ "\n";
		printScreen("Calendar\n", message);
		this.screen = input.nextInt();
	}
	
 	private void printScreen(String title, String message) {
		this.display.setLength(0);
		this.display.append(title
				+ TOP_SPACER);
		this.display.append(message);
		this.display.append(BOTTOM_SPACER);
		System.out.print(this.display);
	}
	public void exit() {
		input.close();
	}
}
