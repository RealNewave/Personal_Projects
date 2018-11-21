import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Screen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton submit, skip, showAnswer, hint, next;
	private JTextField answer;
	private JLabel word, explain;
	

	public Screen() {

		setLayout(new FlowLayout());
		explain = new JLabel("");
		add(explain);
		word = new JLabel("Click next for a word.");
		add(word);
		answer = new JTextField("Answer will show here");
		add(answer);
		submit = new JButton("Submit");
		add(submit);
		submit.addActionListener(this);
		skip = new JButton("Skip");
		add(skip);
		skip.addActionListener(this);
		showAnswer = new JButton("Show Answer");
		add(showAnswer);
		showAnswer.addActionListener(this);
		hint = new JButton("Hint");
		add(hint);
		hint.addActionListener(this);
		next = new JButton("Next");
		add(next);
		next.addActionListener(this);

		JPanel jp = new JPanel();
		jp.setSize(100, 100);
	}

	public void actionPerformed(ActionEvent e) {

		Object x = e.getSource();

		if (submit == x) {
			if(word.getText().equals
		}
		if (skip == x) {

		}
		if (showAnswer == x) {

		}
		if (hint == x) {

		}
		if (next == x) {

			try {
				word.setText(Words.readFile());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}
	}
}
