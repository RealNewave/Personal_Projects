import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordSplit {
	public static void main(String[] args) throws IOException {
		File WordsA = new File("WordsA.txt");
		File Words = new File("Words.txt");
		File Answers = new File("Answers.txt");
		String line = null;

		BufferedReader br = new BufferedReader(new FileReader(WordsA));
		BufferedWriter bw = new BufferedWriter(new FileWriter(Words));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(Answers));
		try {
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				
				
				
				
				bw.write(parts[0]);
				bw.newLine();
				for(int i = 2; i < parts.length;i++){
				bw2.write(parts[i] + " ");
				
				}
				bw2.newLine();
			}
			br.close();
			bw.close();
			bw2.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
