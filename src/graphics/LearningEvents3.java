package graphics;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import static graphics.Utils.println;

public class LearningEvents3 {
	
	public static void main(String []args) {		
		WFrame frame = new WFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Window");
		frame.setVisible(true);
		
		WFrame frame2 = new WFrame();
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setTitle("Secondary Window");
		frame2.setSize(400, 200);
		frame2.setVisible(true);
	}
}

class WFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public WFrame() {
		setSize(500, 300);
		setLocation(100, 100);
		
		addWindowListener(new FWindow());
	}
}

class FWindow implements WindowListener {
	
	@Override
	public void windowActivated(WindowEvent e) { println("1. Activated Window"); }
	
	@Override
	public void windowClosed(WindowEvent e) { println("7. Closed Window"); }
	
	@Override
	public void windowClosing(WindowEvent e) { println("6. Closing Window "); }
	
	@Override
	public void windowDeactivated(WindowEvent e) { println("4. Deactivated Window"); }
	
	@Override
	public void windowDeiconified(WindowEvent e) { println("5. Restored Window"); }
	
	@Override
	public void windowIconified(WindowEvent e) { println("3. Minimized Window"); }
	
	@Override
	public void windowOpened(WindowEvent e) { println("2. Opened Window"); }
}