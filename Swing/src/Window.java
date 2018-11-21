import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton start;
	private JButton stop;
	private JTextField textField;
	private int teller = 0,x,y;
	private Timer t;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		start = new JButton("Start");
		panel.add(start);
		start.addActionListener(this);

		stop = new JButton("Stop");
		panel.add(stop);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		stop.addActionListener(this);
		t = new Timer(1,this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			t.start();
			teller = 0;
					
		}
		if (e.getSource() == stop) {
			t.stop();
			
		}
	}

}
