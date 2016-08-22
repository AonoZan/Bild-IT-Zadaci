
package zadaci_22_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Program creates two Fan objects and assigns few variables to them.
	 * @param args
	 */
	public static void main(String[] args) {
		// create two fan objects
		Fan fan1 = new Fan();
		Fan fan2 = new Fan();
		// set values for first fan
		fan1.setSpeed(fan1.getFAST());
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		// set values for second fan
		fan2.setSpeed(fan1.getFAST());
		fan2.setRadius(5);
		// print stats
		System.out.println("Fan1:\n"
				+ fan1.toString());
		System.out.println("Fan2:\n"
				+ fan2.toString());
		
	}

}
/**
 * Simple fan class.
 * @author AonoZan
 *
 */
class Fan {
	// constants for the speed
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	// fan default variables
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	private String color = "blue";
	
	Fan() {
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSLOW() {
		return SLOW;
	}
	public int getMEDIUM() {
		return MEDIUM;
	}
	public int getFAST() {
		return FAST;
	}
	// method that returns status of the fan
	@Override
	public String toString() {
		if (this.on) {
			return String.format
					( "Speed : %d\n"
					+ "Color : %s\n"
					+ "Radius: %.2f\n"
					, this.speed
					, this.color
					, this.radius
					);
		} else {
			return String.format
					( "Color : %s\n"
					+ "Radius: %.2f\n"
					+ "[fan is off]\n"
					, this.color
					, this.radius
					);
		}
	}
}
