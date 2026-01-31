package graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout1 {
	public static void main(String []args) {
		new Layout1Frame().setVisible(true);
	}
}

class Layout1Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Layout1Frame() {
		setBounds(30, 30, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new Layout1Pannel(), BorderLayout.NORTH);
		super.add(new Layout2Pannel(), BorderLayout.SOUTH);
	}
}

class Layout1Pannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Layout1Pannel() {
		// super.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
		super.setLayout(new FlowLayout(FlowLayout.LEFT));
		super.add(new JButton("Yellow"));
		super.add(new JButton("Blue"));
	}
}

class Layout2Pannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Layout2Pannel() {
		super.setLayout(new BorderLayout(30, 5));
		super.add(new JButton("Red"), BorderLayout.WEST);
		super.add(new JButton("Green"), BorderLayout.CENTER);
		super.add(new JButton("Orange"), BorderLayout.EAST);
	}
}