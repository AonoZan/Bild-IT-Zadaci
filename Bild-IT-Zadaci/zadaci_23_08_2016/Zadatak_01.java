
package zadaci_23_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Program prints two times current and predefined.
	 * @param args
	 */
	public static void main(String[] args) {
		// create default current time and predefined
		Time time1 = new Time();
		Time time2 = new Time(555550000);
		// print time
		System.out.printf("Current time: %02d:%02d:%02d\n",
				time1.hour,
				time1.getMinute(),
				time1.getSecond());
		System.out.printf("Desired time: %02d:%02d:%02d\n",
				time2.hour,
				time2.getMinute(),
				time2.getSecond());
	}

}
/**
 * Siple time class.
 * @author AonoZan
 *
 */
class Time {
	// create variables to store time
	int hour = 0, minute = 0, second = 0;
	// no argument constructor that creates current time
	Time() {
		this(System.currentTimeMillis());
	}
	// constructor that creates time from elapsed milliseconds
	Time(long time) {
		setTime(time);
	}
	// constructor that creates time from arguments
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	// method for setting new time from milliseconds
	public void setTime(long elapseTime) {
		// convert to seconds and set current second from reminder
		elapseTime /= 1000;
		this.second = (int)(elapseTime % 60);
		// convert to minutes and set current minute from reminder
		elapseTime /= 60;
		this.minute = (int)(elapseTime % 60);
		// convert to hours and set current hour from reminder
		elapseTime /= 60;
		this.hour = (int)(elapseTime % 24);
	}
}
