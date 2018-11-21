import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.setSize(400,400);
		mf.setResizable(false);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
