package graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import static graphics.Utils.println;

public class MouseEvent1 {
	public static void main(String []args) {		
		new MFrame().setVisible(true);
	}
}

class MFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MFrame() {
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addMouseListener(new MouseEventos());
		addMouseMotionListener(new DragMoveMouse()); 
	}
}

class MouseEventos extends MouseAdapter /*implements MouseListener*/ {

	@Override
	public void mouseClicked(MouseEvent e) {
		// println("X: %d | Y: %d".formatted(e.getX(), e.getY()));
		// println(e.getClickCount()); // Click counter
	}

	@Override
	public void mouseEntered(MouseEvent e) { /*println("Entered");*/ }

	@Override
	public void mouseExited(MouseEvent e) { /*println("Exited");*/ }

	@Override
	public void mousePressed(MouseEvent e) {
		// println("Pressed");
		// println(e.getModifiersEx()); // shows the constant value of the mouse button.
		switch(e.getModifiersEx()) {
			case MouseEvent.BUTTON1_DOWN_MASK: println("Main Click has been pressed"); break;
			case MouseEvent.BUTTON3_DOWN_MASK: println("Secondary Click has been pressed"); break;
			case MouseEvent.BUTTON2_DOWN_MASK: println("Round has been pressed"); break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) { /*println("Released");*/ }
}

class DragMoveMouse implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) { println("Dragging Mouse"); }

	@Override
	public void mouseMoved(MouseEvent e) { println("Moving Mouse"); }
}