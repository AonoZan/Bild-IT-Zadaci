/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;

public class Reminders {
	private String[][] monthReminders;
	Reminders(){
		this.monthReminders = new String[31][];
	}
	Reminders(String filePath) {
		this.monthReminders = readReminders();
	}
	private String[][] readReminders() {
		monthReminders = new String[31][];
		return monthReminders;
	}
}
