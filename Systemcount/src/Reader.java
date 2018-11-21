import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {

	public static ArrayList<Double> getal = new ArrayList<Double>();

	public static int aantal = 0;
	public static int vorm;
	public static double uitkomst = 1;

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			while (aantal == 0) {
				try {
					System.out.println("Hoeveel getallen gaat u invoeren?");
					aantal = Integer.parseInt(in.readLine());
				} catch (NumberFormatException nfe) {
					System.out.print("Voer een geldig getal in");
				}
			}
			if (aantal != 0) {
				for (int i = 1; i < aantal + 1; i++) {
					try {
						System.out.println("voer getal " + i + " in:");
						getal.add(Double.parseDouble(in.readLine()));
					} catch (NumberFormatException nfe) {
						System.out.println("Voer een geldig getal in");
					}
				}
				try {
					System.out.println("Wilt u optellen(1), aftrekken(2), vermenigvuldigen(3) of delen(4)?");
					vorm = Integer.parseInt(in.readLine());
				} catch (NumberFormatException nfe) {
					System.out.println("Voer een geldig getal in");
				}
				for (double x : getal) {
					if (vorm == 1) {
						uitkomst += x;
					}
					if (vorm == 2) {
						uitkomst -= x;
					}
					if (vorm == 3) {
						uitkomst *= x;
					}
					if (vorm == 4) {
						uitkomst /= x;
					}

				}
				if (vorm == 1 || vorm == 2) {
					System.out.println(uitkomst - 1);
				}
				if (vorm == 3 || vorm == 4) {
					System.out.println(uitkomst);
				}
				aantal = 0;
				uitkomst = 1;
				getal.clear();
			}
		}
	}
}