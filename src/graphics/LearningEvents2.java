package graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LearningEvents2 {
	public static void main(String []args) {
		new EFrame2().setVisible(true);
	}
}

class EFrame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private EPannel2 pannel;
	
	public EFrame2() {
		this.pannel = new EPannel2();
		add(this.pannel);
		
		setTitle("Learning about java events");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class EPannel2 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton blue;
	private JButton yellow;
	private JButton red;
	private JButton darkGray;
	private BackgroundColor bcBlue;
	private BackgroundColor bcYellow;
	private BackgroundColor bcRed;
	private BackgroundColor bcDarkGray;
	
	public EPannel2() {
		this.blue = new JButton("Blue");
		this.yellow = new JButton("Yellow");
		this.red = new JButton("Red");
		this.darkGray = new JButton("Dark Gray");
		
		add(this.blue);
		add(this.yellow);
		add(this.red);
		add(this.darkGray);
		
		this.bcBlue = new BackgroundColor(Color.BLUE);
		this.bcYellow = new BackgroundColor(Color.YELLOW);
		this.bcRed = new BackgroundColor(Color.RED);
		this.bcDarkGray = new BackgroundColor(Color.DARK_GRAY);
		
		this.blue.addActionListener(this.bcBlue);
		this.yellow.addActionListener(this.bcYellow);
		this.red.addActionListener(this.bcRed);
		this.darkGray.addActionListener(this.bcDarkGray);
	}
	
	private class BackgroundColor implements ActionListener {
		private Color color;
		
		public BackgroundColor(Color color) {
			this.color = color;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setBackground(this.color);
		}
	}
}