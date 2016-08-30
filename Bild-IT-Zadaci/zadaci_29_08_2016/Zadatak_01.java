
package zadaci_29_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak_01 {
	/**Method calculates and retrieves area of convex polygon.*/
	public static double getConvexPolyArea(ArrayList<Point> list) {
		// create sum
		double sum = 0;
		// loop trough all points
		for (int i = 0; i < list.size(); i++) {
			// get index next to i, for i as last index retrieve first index
			int nextToIt = (list.size() + (i + 1)) % list.size();
			// get point and point next to it
			Point p1 = list.get(i);
            Point p2 = list.get(nextToIt);
            // add to sum
			sum += (p1.x * p2.y) - (p1.y * p2.x);
		}
		// return sum 
		return -(sum / 2);
	}
	/**Program asks user to enter points of polygon and then prints area.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list of points
		ArrayList<Point> points = new ArrayList<>();
		int size = 0;
		// ask for how many points polygon will have
		while (true) {
			try {
				if (size == 0) {
					System.out.println("Enter number of points: ");
					size = input.nextInt();
					// polygon have at least 3 points
					if (size <= 3) {
						System.out.println("Enter positive number bigger than 3.");
						size = 0;
						continue;
					}
				}
				break;
			} catch (InputMismatchException e) {
				// if user makes mistake clear console
				System.out.println("Please enter only numbers.");
				input.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// prompt user to enter points of polygon
		System.out.println("Enter " + size + " number of points.");
		while (true) {
			for (int i = 0; i < size; i++) {
				System.out.printf("Enter x and y for %d point: ", i);
				try {
					Point point = new Point(input.nextDouble(), input.nextDouble());
					points.add(point);
				} catch (InputMismatchException e) {
					// if user makes mistake clear console and loop back
					System.out.println("Please enter only decimal numbers.");
					input.nextLine();
					i--;
				}
			}
			break;
		}
		// calculate areaand print it
		double area = getConvexPolyArea(points);
		System.out.printf("area is : %.2f\n", area);
		input.close();
	}
}
/**Simple point class to store x and y coordinate.*/
class Point {
	public double x;
	public double y;
	Point(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
}