/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_02 {
	/**
	 * Program gathers information from user for two points on earth and then prints great circle distance.
	 * <p>Formula that is used is:
	 * <br><b>d = earth_radius * arccos(sin(x 1 ) * sin(x 2 ) + cos(x 1 ) * cos(x 2 ) * cos(y 1 - y 2 ))</b>
	 * @param args
	 */
	public static void main(String[] args) {
		// set default value for earths radius
		final double EARTHS_RADIUS = 6371.01;
		double great_circle_distance;
		// prompt user to enter values for points
		System.out.println("Enter latitude and longitude for two points.");
		int correctValues = 0;
		double[] points = new double[4];
		while (true) {
			try {
				// loop trough list and try to get values
				for (int i = 0; i < points.length; i++) {
					// change only those values that needs to be changed
					if (i == correctValues) {
						// prompt user with correct message for each point
						System.out.printf("Enter value for point %s %s: ",
								i < 2 ? "one" : "two",
								(i + 3) % 2 == 0 ? "long" : "lat");
						points[i] = zadaci_03_08_2016.Zadatak_02.readFromConsole(points[i]);
						// convert user value into radians so that can be ised with Math methods
						points[i] = Math.toRadians(points[i]);
						correctValues++;
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// calculate great circle distance with formula and print result
		great_circle_distance = EARTHS_RADIUS * Math.acos((Math.sin(points[0]) * Math.sin(points[2]) +
				Math.cos(points[0]) * Math.cos(points[2]) *
				Math.cos(points[1] - points[3])));// degrees into Math.toRadians()
		System.out.printf("\nThe distance between two points is %f km.\n", great_circle_distance);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
