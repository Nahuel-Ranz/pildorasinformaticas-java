package graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LearningEvents {
	public static void main(String []args) {
		new EFrame().setVisible(true);
	}
}

class EFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private EPannel pannel;
	
	public EFrame() {
		this.pannel = new EPannel();
		add(this.pannel);
		
		setTitle("Learning about java events");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class EPannel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton blue;
	private JButton yellow;
	private JButton red;
	private JButton dark_gray;
	
	public EPannel() {
		this.blue = new JButton("Blue");
		this.yellow = new JButton("Yellow");
		this.red = new JButton("Red");
		this.dark_gray = new JButton("Dark Gray");
		add(this.blue);
		add(this.yellow);
		add(this.red);
		add(this.dark_gray);
		
		this.blue.addActionListener(this);
		this.yellow.addActionListener(this);
		this.red.addActionListener(this);
		this.dark_gray.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object pressedBtn = e.getSource();
		
		if(pressedBtn == this.blue) setBackground(Color.BLUE);
		else if(pressedBtn == this.yellow) setBackground(Color.YELLOW);
		else if(pressedBtn == this.red) setBackground(Color.RED);
		else setBackground(Color.DARK_GRAY); 
	}
}