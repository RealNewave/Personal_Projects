import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveScanner {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<>();
		File file = new File("WordsA.txt");
		Scanner sc = new Scanner(file);
		String line = "";
		while (sc.hasNext()) {
			if(!(line = sc.nextLine()).isEmpty()){
				words.add(line);
				System.out.println(line);
			}
				
			
		}sc.close();
	}

}
