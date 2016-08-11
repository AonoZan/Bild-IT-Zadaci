/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Class for storing reminders for certain month.
 * Reminders for any day can be accessed with getter.
 *
 */
public class Reminders {
	private int[] yearMonth = new int[2];
	private String[][] monthReminders;
	private String filePath = System.getProperty("user.dir") + "\\notes\\", filename;
	
	Reminders() {
		this(new int[]{2016, 1});
	}
	Reminders(int[] yearMonth) {
		this.yearMonth = yearMonth;
		this.filename = updateFilename(1);
		this.monthReminders = readReminders();
		
	}
	/**
	 * Method for constructing filename based on the day, month and year.
	 * @param day
	 * @return
	 */
	private String updateFilename(int day) {
		return String.format("%02d_%02d_%4d.txt", day, yearMonth[1], yearMonth[0]);
	}
	/**
	 * Method for retriving count of reminders for each day in month.
	 * @return
	 */
	public int[] getRemindersCount() {
		// create new list and fill it if there is reminders
		int[] count = new int[31];
		for (int i = 0; i < monthReminders.length; i++) {
			if (monthReminders[i] == null) count[i] = 0;
			else count[i] = monthReminders[i].length;
		}
		return count;
	}
	/**
	 * Method for retriving list of reminders to fill body of the aplication
	 * @param day
	 * @return
	 */
	public String getReminders(int day) {
		// if there is no reminders for current day eturn only message
		if (monthReminders[day - 1] == null) return "\n\nNo reminders for this day.\n\n\n\n\n";
		// create string and append at least 7 lines 
		String reminders = "";
		for (int i = 0; i < 7; i++) {
			try {
				// if there is reminder append it with number
				reminders += "(" + i + ") " + monthReminders[day - 1][i] + "\n";
			} catch (Exception e) {
				reminders += "\n";
			}
		}
		return reminders;
	}
	/**
	 * Method for reading reminders from the file.
	 * @return
	 */
	public String[][] readReminders() {
		// create new list of reminders for each possible day
		monthReminders = new String[31][];
		// loop for each possible day and try to read file
		for (int i = 0; i < monthReminders.length; i++) {
			// update path to each file and check if it exists
			this.filename = updateFilename(i + 1);
			File file = new File(filePath + filename);
			// if file doesnt exist assign null instead of list
			if (!file.exists()) {
				monthReminders[i] = null;
				continue;
			}
			try {
				// scann whole file and create list of reminders
				// by spliting file on each line
				Scanner fileInput = new Scanner(file);
				String content = fileInput.useDelimiter("\\Z").next();
				monthReminders[i] = content.split("\n");
				fileInput.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return monthReminders;
	}
	/**
	 * Method for adding new reminders both in list and in file
	 * @param day
	 * @param reminder
	 */
	public void addReminder(int day, String reminder){
		// check if folder exist and create if it doesn't
		File file = new File(filePath);
		if (!file.exists()) {
//			System.out.println("Folder doesn't exist.");
			file.mkdir();
        }
		// create file from folder path and filename
		this.filename = updateFilename(day);
		file = new File(filePath + filename);
		// try to write to the file
		try {
			// append reminder to the file 
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
			output.write(reminder + "\n");
			output.close();
		} catch (Exception e){
			System.out.println("File can't be written.");
		}
		// if there is no reminders for current day create one and exit
		if (this.monthReminders[day - 1] == null) {
			monthReminders[day - 1] = new String[]{reminder};
			return;
		}
		// for adding new reminders create list bigger for one
		String[] newList = new String[this.monthReminders[day - 1].length + 1];
		// copy list and add reminder to the end
		for (int i = 0; i < this.monthReminders[day - 1].length; i++) {
			newList[i] = monthReminders[day - 1][i];
		}
		newList[newList.length - 1] = reminder;
		monthReminders[day - 1] = newList;
	}
	/**
	 * Method for removing list of reminders for certain day and
	 * for deleting file that holds all those reminders.
	 * @param day
	 */
	public void removeReminders(int day){
		// remove list from memory
		this.monthReminders[day - 1] = null ;
		// create file based on day and selete it
		String fileToRemove = updateFilename(day);
		File file = new File(filePath + fileToRemove);
		file.delete();
	}
}
