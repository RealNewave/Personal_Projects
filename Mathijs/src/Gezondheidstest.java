import java.util.Scanner;

/**
 *
 * @author mathijs
 */
public class Gezondheidstest {

	/**
	 * @param args
	 *            the command line arguments
	 */
	static double max;
	static double min;
	static boolean zin1 = false;
	static boolean zin2 = false;
	static boolean zin3 = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Wat is uw hartslag (slagen per minuut): ");
		if (tussen(input.nextDouble(), 55, 90)) {
			zin1 = true;
		}
		System.out.println("Wat is uw lichaamstemperatuur(graden Celsius): ");
		if (tussen(input.nextDouble(), 36.3, 37.5)) {
			zin2 = true;
		}
		System.out.println("Wat is uw bovendruk (mm Hg): ");
		if (tussen(input.nextDouble(), 100, 140)) {
			zin3 = true;
		}

		if (zin1) {
			System.out.println("ok1");
		} else {
			System.out.println("niet ok1");
		}
		if (zin2) {
			System.out.println("ok2");
		} else {
			System.out.println("niet ok2");
		}
		if (zin3) {
			System.out.println("ok3");
		} else {
			System.out.println("niet ok3");
		}

	}

	static boolean tussen(double waarde, double min, double max) {
		return waarde >= min && waarde <= max;
				
	}

}