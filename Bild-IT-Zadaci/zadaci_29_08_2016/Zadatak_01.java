
package zadaci_29_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak_01 {

	public static double getConvexPolyArea(ArrayList<Point> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			int nextToIt = (list.size() + (i + 1)) % list.size();
			System.out.printf("%d %d \n", i, nextToIt);
			Point p1 = list.get(i);
            Point p2 = list.get(nextToIt);
			sum += (p1.x * p2.y) - (p1.y * p2.x);
		}
		return -(sum / 2);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Point> points = new ArrayList<>();
		int size = 0;
		while (true) {
			try {
				if (size == 0) {
					System.out.println("Enter number of points: ");
					size = input.nextInt();
					if (size <= 0) {
						System.out.println("Enter positive number bigger than 3.");
						size = 0;
						continue;
					}
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter only numbers.");
				input.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Enter " + size + " number of points.");
		while (true) {
			for (int i = 0; i < size; i++) {
				System.out.printf("Enter x and y for %d point: ", i);
				try {
					Point point = new Point(input.nextDouble(), input.nextDouble());
					points.add(point);
				} catch (InputMismatchException e) {
					System.out.println("Please enter only decimal numbers.");
					input.nextLine();
					i--;
				}
			}
			break;
		}
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