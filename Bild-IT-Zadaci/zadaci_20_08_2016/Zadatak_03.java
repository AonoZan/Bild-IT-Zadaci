
package zadaci_20_08_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	// method for sorting numbers
	public static void sort(int[] list) {
		// loop till last one
		for (int i = 0; i < list.length - 1; i++) {
			// set finished to true 
			boolean finished = true;
			// loop to last one minus current loop
			for (int j = 0; j < list.length - 1 - i; j++) {
				// switch values if current greater than next one
				if (list[j] > list[j + 1]) {
					list[j] += list[j + 1];
					list[j + 1] = list[j] - list[j+1];
					list[j] -= list[j + 1];
					finished = false;
				}
			}
			// end if nothing sorted in this iteration
			if (finished) {
				return;
			}
		}
	}
	// method for filling list with random values
	public static void fillRandom(int[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * 10);
		}
	}
	/**
	 * Program benchmarks sorting of 100000 integers with class Stopwatch.
	 * @param args
	 */
	public static void main(String[] args) {
		// create stopwatch
		Stopwatch stopwatch = new Stopwatch();
		// create list and fill with random values
		int[] numbers = new int[100000];
		fillRandom(numbers);
		
		
		// start stopwatch
		stopwatch.start();
		// sort numners and at the end stop stopwatch
		sort(numbers);
		stopwatch.stop();
		
		// print elapsed time
		System.out.println(stopwatch.getElapsedTime());
		 
	}

}
/**
 * Simple stopwatch class. Call start() and stop() to start and stop time.
 * Call getElapsedTime() to return time elapsed in seconds.
 * @author AonoZan
 *
 */
class Stopwatch {
	private long startTime;
	private long endTime;
	// basic constructor initiate start time
	public Stopwatch() {
		this.startTime = System.currentTimeMillis();
	}
	// to start time
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	// to stop time
	public void stop() {
		this.endTime = System.currentTimeMillis();
	}
	// return time elapsed in seconds
	public long getElapsedTime() {
		return (this.endTime - this.startTime) / 1000;
	}
	
}
