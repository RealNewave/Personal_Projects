import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MyFrame extends JFrame implements ActionListener {

	private JButton bStart, bStop, bReset, bLap;
	private JTextField textField;
	private Timer timer;
	private int i = 0, j = 0, k = 0, l = 1;
	private JLabel laps, m;
	JPanel top, bottom;

	public MyFrame() {
		top = new JPanel();
		top.setLayout(new FlowLayout());
		top.setSize(400,100);
		
		top.setBackground(Color.RED);
		add(top);
		
		bottom = new JPanel();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		bottom.setSize(400,300);
		bottom.setBackground(Color.ORANGE);
		add(bottom);
		
		textField = new JTextField(30);
		top.add(textField);
		bStart = new JButton("Start");
		top.add(bStart);
		bStart.addActionListener(this);
		bStop = new JButton("Pause");
		top.add(bStop);
		bStop.addActionListener(this);
		bReset = new JButton("Reset");
		top.add(bReset);
		bReset.addActionListener(this);
		bLap = new JButton("Lap");
		top.add(bLap);
		
		
		bLap.addActionListener(this);
		laps = new JLabel("");
		bottom.add(laps);
		timer = new Timer(10, this);
	}

	public void actionPerformed(ActionEvent e) {

		Object x = e.getSource();

		if (x == bStart) {
			timer.start();

		}
		if (x == bStop) {
			timer.stop();
		}
		if (x == bReset) {
			i = 0;
			j = 0;
			k = 0;
						
		}
		if (x == bLap) {
			
			bottom.add(new JLabel("lap " + l + " " + textField.getText()));
			laps.setText("lap " + l + " " + textField.getText());laps.setVisible(false);
			l++;
			
		}

		if (x == timer) {

			if (i < 60) {
				i++;
			}
			if (i >= 60) {
				j++;
				i = 0;
			}
			if (j >= 60) {
				k++;
				j = 0;
			}
			if (k >= 24) {
				k = 0;
			}

			
		}
		textField.setText("" + k + ":" + j + ":" + i);
	}

}
