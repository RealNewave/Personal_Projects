import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class MyFrame extends JFrame implements ActionListener {

	private JButton bStart, bStop, bReset, bIncrease, bDecrease;
	private JTextField textField, textField2;
	private JLabel circleA, circleB;
	private Timer timer;
	private int a = 300, b = 300, x = 20, y = 20, level = 1, score = 0;

	public MyFrame() {

		setLayout(new FlowLayout());
		circleA = new JLabel("Level");
		add(circleA);
		textField = new JTextField(12);
		add(textField);
		textField.setText("" + level);
		textField.setEnabled(false);
		circleB = new JLabel("Score");
		add(circleB);
		textField2 = new JTextField(12);
		add(textField2);
		textField2.setText("" + score);
		setEnabled(false);
		bStart = new JButton("Start");
		add(bStart);
		bStart.addActionListener(this);
		bStop = new JButton("Pause");
		add(bStop);
		bStop.addActionListener(this);
		bReset = new JButton("Reset");
		add(bReset);
		bReset.addActionListener(this);
		bIncrease = new JButton("Increase");
		add(bIncrease);
		bIncrease.addActionListener(this);
		bDecrease = new JButton("Decrease");
		add(bDecrease);
		bDecrease.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setSize(100, 100);

		timer = new Timer(1000, this);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getY() >= b - 20 && me.getY() <= b + 20
						&& me.getX() >= a - 20 && me.getX() <= a + 20) {

					textField2.setText("" + score);
					score++;
				}
			}
		});
		
	}

	public void paint(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 100, 410, 300);
		g.setColor(Color.BLACK);
		g.drawRect(5, 100, 400, 295);
		g.setColor(Color.RED);
		g.fillOval(a, b, x, y);

	}

	public void actionPerformed(ActionEvent e) {

		Object x = e.getSource();
		if (score == (score + 10)) {
			level++;
		}
		if (x == bStart) {
			timer.start();
		}
		if (x == bStop) {
			timer.stop();
		}
		if (x == bReset) {
			level = 1;
			score = 0;
		}
		if (x == bIncrease) {

		}
		if (x == bDecrease) {

		}
		if (x == timer) {
			Random random = new Random();
			int randomNumber = random.nextInt(380);
			int randomNumber2 = random.nextInt(290) + 100;
			a = randomNumber;
			b = randomNumber2;
			
			repaint();
		}
	}
}
