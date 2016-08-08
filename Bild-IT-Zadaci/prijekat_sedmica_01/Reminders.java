/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Reminders {
	private int[] yearMonth = new int[2];
	private String[][] monthReminders;
	private String filePath, filename;
	
	Reminders(){
		this(System.getProperty("user.dir") + "\\notes\\");
	}
	Reminders(String filePath) {
		this(filePath, new int[]{2016, 1});
	}
	Reminders(String filePath, int[] yearMonth) {
		this.filePath = filePath;
		this.yearMonth = yearMonth;
		this.filename = updateFilename(1);
		this.monthReminders = readReminders();
		
	}
	private String updateFilename(int day) {
		return String.format("%02d_%02d_%4d.txt", day, yearMonth[1], yearMonth[0]);
	}
	public String getReminders(int day) {
		if (monthReminders[day - 1] == null) return "\n\nNo reminders for this day.\n\n\n\n\n";
		String reminders = "";
		for (int i = 0; i < 7; i++) {
			try {
				reminders += "(" + i + ") " + monthReminders[day - 1][i] + "\n";
			} catch (Exception e) {
				reminders += "\n";
			}
		}
//		if (monthReminders[day - 1].length < 7) {
//			for (int i = 0; i < 7 - monthReminders.length; i++) {
//				reminders += "\n";
//			}
//		}
		return reminders;
	}
	public String[][] readReminders() {
		monthReminders = new String[31][];
		
		for (int i = 0; i < monthReminders.length; i++) {
			this.filename = updateFilename(i + 1);
			File file = new File(filePath + filename);
			if (!file.exists()) {
				System.out.printf("File for %d day doesnt exist.\n", i + 1);
				monthReminders[i] = null;
				continue;
			}
			try {
				Scanner fileInput = new Scanner(file);
				String content = fileInput.useDelimiter("\\Z").next();
				monthReminders[i] = content.split("\n");
				fileInput.close();
				
			} catch (Exception e) {
				//        	System.out.println("cant read lines." + filePath + filename);
				System.out.println(e.getMessage());
			} 
		}
		return monthReminders;
	}
	public void addReminder(int day, String reminder){
		this.filename = updateFilename(day);
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("Folder doesn't exist.");
			file.mkdir();
        }
		file = new File(filePath + filename);
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
			output.write(reminder);
			output.close();
		} catch (Exception e){
			System.out.println("File can't be written.");
		}
		String[] newList;
		if (this.monthReminders[day - 1] == null) {
			monthReminders[day - 1] = new String[]{reminder};
			System.out.println(monthReminders[day - 1][0] + "added");
			return;
		}
		newList  = new String[this.monthReminders[day - 1].length + 1];
		
		for (int i = 0; i < this.monthReminders[day - 1].length; i++) {
			newList[i] = monthReminders[day - 1][i];
		}
		newList[newList.length - 1] = reminder;
		monthReminders[day - 1] = newList;
//		this.monthReminders[day];
	}
	public void removeReminder(int day, String reminder){
		
	}
}
