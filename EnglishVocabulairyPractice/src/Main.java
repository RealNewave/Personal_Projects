import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Screen screen = new Screen();
		screen.setSize(400, 400);
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setResizable(true);
		
	}

}
