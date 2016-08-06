/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

public class Zadatak_05 {
	/**
	 * Program asks from user values for speed and acceleration of the plane.
	 * Based on those values program calculates minimum runway length for that plane.
	 * @param args
	 */
	public static void main(String[] args) {
		double airplaneSpeed = 0, airplaneAcceleration = 0;
		while(true) {
			try {
				
				// if still defauls value for speed try to get correct one
				if (airplaneSpeed == 0) {
					System.out.print("Enter airplane maximum speed: ");
					airplaneSpeed = zadaci_03_08_2016.Zadatak_02.readFromConsole(airplaneSpeed);
					// if user enters wrong value for speed politely exit
					if (airplaneSpeed == 0) {
						System.out.println("That airplane ain't going nowhere. :)");
						System.exit(0);
					} else if (airplaneSpeed < 0) {
						System.out.println("That airplane is going in reverse man!");
						System.exit(0);
					}
				}
				// if still defauls value for acceleration try to get correct one
				if (airplaneAcceleration == 0) {
					System.out.print("Enter airplane acceleration: ");
					airplaneAcceleration = zadaci_03_08_2016.Zadatak_02.readFromConsole(airplaneAcceleration);
					// if user enters wrong value for money politely exit
					if (airplaneAcceleration == 0) {
						System.out.println("That airplane must heve been broken, it woont start. :)");
						System.exit(0);
					} else if (airplaneAcceleration < 0) {
						System.out.println("Airplane can't accelerate in reverse!");
						System.exit(0);
					}
				}
				// if both variable have correct values break out of loop
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// 60 za brzinu i 3.5 za ubrzanje dužina piste je 514.286)
		double minimumRunwayLength = (airplaneSpeed * airplaneSpeed) / (airplaneAcceleration * 2);
		System.out.printf("Minimum runway length for this plane must be %.2fm.", minimumRunwayLength);
		
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
