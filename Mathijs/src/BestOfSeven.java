import java.util.Scanner;

/**
 *
 * @author mathijs
 */
public class BestOfSeven {

	/**
	 * @param args
	 *            the command line arguments
	 */
	static String[] teams;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Dit programma is gemaakt door: Mathijs Janz, IT102,500730032");

		teams = new String[2];
		System.out.println("Hoe heet het eerste team: ");
		teams[0] = input.nextLine();
		System.out.println("Hoe heet het tweede team: ");
		teams[1] = input.nextLine();

		int[] punten1 = new int[5];
		int[] punten2 = new int[5];

		int score1 = 0;
		int score2 = 0;

		for (int i = 0; i < 8 ; i++) {

			System.out.println("Uitslag wedstrijd " + (i + 1) + ": ");
			System.out.println("Aantal punten " + teams[0] + ": ");
			punten1[i] = input.nextInt();
			System.out.println("Aantal punten " + teams[1] + ": ");
			punten2[i] = input.nextInt();

			if (punten1[i] > punten2[i]) {
				score1++;
				System.out.println(score1);
			} else {
				score2++;
				System.out.println(score2);
			}
			printWinnaar(teams[0], teams[1], score1, score2);
		}
	}

	static void printWinnaar(String team1, String team2, int score1, int score2) {
		if (score1 == 4 ) {

			System.out.println("Team " + teams[0] + " heeft gewonnen!");

		} else if (score2 == 4) {

			System.out.println("Team " + teams[1] + " heeft gewonnen!");

		}
	}
	
	
	

}