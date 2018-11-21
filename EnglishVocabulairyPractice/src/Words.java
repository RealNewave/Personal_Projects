import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Words {

	private static File WordsA = new File("WordsA.txt");
	private static int linesCount = 0;
	private static int randomNumber;
	private static String line;
	
	public static String readFile() throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(WordsA));
			randomNumber = selectLine();
			while ((line = br.readLine()) != null) {
				linesCount++;
				if (linesCount == randomNumber) {
					br.close();
					linesCount = 0;
					return line;

				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static int selectLine() throws IOException {
		Random random = new Random();
		int randomNumber = random.nextInt((470 - 1) + 1);

		return randomNumber;
	}
}
