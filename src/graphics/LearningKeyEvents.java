package graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static graphics.Utils.println;

public class LearningKeyEvents {
	public static void main(String []args) {
		new KEFrame().setVisible(true);
	}
}

class KEFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public KEFrame() {
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new MyKeyEvent());
	}
}

class MyKeyEvent implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) { /*println(e.getKeyCode());*/ }
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) { println(e.getKeyChar());}
}