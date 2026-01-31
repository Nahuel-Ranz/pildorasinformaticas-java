package graphics;
import javax.swing.*;

public class CreateFrame {

	public static void main(String []args) {
		new MyFrame();
	}
}

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MyFrame() {
		// setSize(500, 300);
		// setLocation(500, 300);
		setBounds(500, 300, 200, 200); // (x, y, width, height)
		
		// setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Window");
	}
}