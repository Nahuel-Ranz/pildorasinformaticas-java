package firstpart.graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class NewLayoutDock {
	public static void main(String[] args) {
		new DockFrame().setVisible(true);
	}
}

class DockFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public DockFrame() {
		super.setBounds(50, 20, 500, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new DockPannel());
	}
}

class DockPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Spring spring, rigidSpring;
	private SpringLayout layout;
	private JButton btn1, btn2, btn3;
	
	public DockPannel() {
		this.layout = new SpringLayout();
		super.setLayout(this.layout);
		
		this.btn1 = new JButton("Button 1");
		this.btn2 = new JButton("Button 2");
		this.btn3 = new JButton("Button 3");
		Utils.addButtonsToPanel(this, btn1, btn2, btn3);
		
		this.spring = Spring.constant(0, 10, 100);
		this.rigidSpring = Spring.constant(100);
		
		this.layout.putConstraint(SpringLayout.WEST, btn1, spring, SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.WEST, btn2, rigidSpring, SpringLayout.EAST, btn1);
		this.layout.putConstraint(SpringLayout.WEST, btn3, rigidSpring, SpringLayout.EAST, btn2);
		this.layout.putConstraint(SpringLayout.EAST, this, spring, SpringLayout.EAST, btn3);
	}
}