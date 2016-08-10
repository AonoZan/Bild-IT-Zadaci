/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_02 {
	public static void main(String[] args) {
		final double EARTHS_RADIUS = 6371.01;
		double great_circle_distance;
		System.out.println("Enter latitude and longitude for two points.");
		double[] points = new double[4];
		while (true) {
			try {
				for (int i = 0; i < points.length; i++) {
					if (points[i] == 0) {
						System.out.printf("Enter value for point %s %s: ",
								i < 2 ? "one" : "two",
								(i + 3) % 2 == 0 ? "long" : "lat");
						points[i] = zadaci_03_08_2016.Zadatak_02.readFromConsole(points[i]);
						points[i] = Math.toRadians(points[i]);
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		great_circle_distance = EARTHS_RADIUS * Math.acos((Math.sin(points[0]) * Math.sin(points[2]) +
				Math.cos(points[0]) * Math.cos(points[2]) *
				Math.cos(points[1] - points[3])));// degrees into Math.toRadians()
		System.out.printf("\nThe distance between two points is %f km.\n", great_circle_distance);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
