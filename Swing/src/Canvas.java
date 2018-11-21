import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;


public class Canvas extends JFrame {

	
	private JButton jb1;
	private JTextField tf1;
	private JLabel lb1;
	
	public Canvas(){
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
