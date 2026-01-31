package graphics;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class LearningEvents4 {
	
	public static void main(String []args) {		
		var frame = new WindowFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Window");
		frame.setVisible(true);
		
		var frame2 = new WindowFrame();
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setTitle("Secondary Window");
		frame2.setSize(400, 200);
		frame2.setVisible(true);
	}
}

class WindowFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public WindowFrame() {
		setSize(500, 300);
		setLocation(100, 100);
		
		addWindowListener(new FrameWindow());
	}
}

/*
 * WindowAdapter: this class is very useful because it implements
 * all the methods of the interfaces that we need to implement, but
 * we only need to implement one or two methods of this interface,
 * no more.
 */
class FrameWindow extends WindowAdapter {
	@Override
	public void windowIconified(WindowEvent e) { IO.println("3. Minimized Window"); }
}