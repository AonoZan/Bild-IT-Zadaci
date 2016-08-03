/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_01_08_2016;
import java.util.ArrayList;

public class Zadatak_01 {
	/**
	 * This method use linear algorithm to search and returns max value in the specified list.
	 * If the list is empty or null, return value is null.<p>
	 * @param ArrayList of integers
	 * @return max value in list or null
	 */
	public static Integer max(ArrayList<Integer>list){
		// if list contains only one element return it immediately
		if (list.size() == 1) return list.get(0);
		// If list doesn't contain elements or its null skip
		if (list.size() != 0 && list != null){
			int max = list.get(0);
			// for every element if its bigger than max set max to that value
			for (int current : list){
				if(current > max) max = current;
			}
			//return max
			return max;
		}
		// return null
		return null;
	}

	/**
	 * Main method that tests max method.<p>
	 * Method creates array list of integers and then prints largest in list using max method return value. 
	 * @param args
	 */
	public static void main(String[] args) {
		// create some array list and add few elements
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-5);
		list.add(-4);
		list.add(-1);
		list.add(-8);
		// print max value inside list
		System.out.println(max(list));
	}

}
