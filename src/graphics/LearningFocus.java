package graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LearningFocus {
	public static void main(String []args) {
		new FFrame().setVisible(true);
	}
}

class FFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public FFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLocation(30, 30);
		add(new FPannel());
	}
}

class FPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField textField1;
	private JTextField textField2;
	
	public FPannel() {		
		setLayout(null);
		setBackground(Color.RED);
		
		this.textField1 = new JTextField();
		this.textField2 = new JTextField();
		
		this.textField1.setBounds(20, 30, 200, 25);
		this.textField2.setBounds(20, 70, 200, 25);
		
		add(this.textField1);
		add(this.textField2);
		
		this.textField1.addFocusListener(new ThrowFocus());
		// this.textField2.addFocusListener(new ThrowFocus());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	private class ThrowFocus implements FocusListener {
		
		@Override
		public void focusGained(FocusEvent e) {}
		
		@Override
		public void focusLost(FocusEvent e) {
			String email = textField1.getText();
			boolean verified = false;
			
			if(email.contains("@")) verified = true;			
			IO.println(verified ? "Correct" : "Incorrect");
		}
	}
}