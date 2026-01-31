package graphics;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import static graphics.Utils.println;

public class FrameEvents {
	public static void main(String []args) {
		var evFrame = new EvFrame();
		evFrame.setVisible(true);
	}
}

class EvFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public EvFrame() {		
		setSize(500, 500);
		setLocation(50, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowStateListener(new ChangeState());
	}
}

class ChangeState implements WindowStateListener {
	
	@Override
	public void windowStateChanged(WindowEvent e) {
		//  Utils.println("Changed State");
		// Utils.println(String.valueOf(e.getNewState()));
		switch(e.getNewState()) {
			case JFrame.MAXIMIZED_BOTH: println("FULL SCREEN"); break;
			case JFrame.NORMAL: println("NORMAL SIZE"); break;
			case JFrame.ICONIFIED: println("MINIMEZED WINDOW"); break;
		}
	}
}