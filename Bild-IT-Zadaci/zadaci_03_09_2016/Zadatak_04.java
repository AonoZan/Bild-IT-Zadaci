
package zadaci_03_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Sum areas of all objects from list. */
	public static double sumArea(GeometricObject[] list) {
		double sum = 0;
		for (GeometricObject geoO : list) {
			sum += geoO.getArea();
		}
		return sum;
	}
	/** Program tests sumArea method. */
	public static void main(String[] args) {
		// create list of five items (octagons)
		GeometricObject[] list = new GeometricObject[5];
		for (int i = 0; i < list.length; i++) {
			// add element with random side length and print it
			list[i] = new Octagon(Math.random());
			System.out.println("Octagon:\n" + list[i]);
		}
		// calculate sum of all objects areas and print it
		double sum = sumArea(list);
		System.out.println("Sum of all areas is: " + sum);
		
	}
}

