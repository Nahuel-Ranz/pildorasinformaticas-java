package graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class FocusedWindow extends JFrame implements WindowFocusListener {
	private static final long serialVersionUID = 1L;
	
	private FocusedWindow window1;
	private FocusedWindow window2;
	
	public static void main(String []args) {
		var frame = new FocusedWindow();
		frame.init();
	}

	public void init() {
		this.window1 = new FocusedWindow();
		this.window2 = new FocusedWindow();
		
		this.window1.setBounds(50, 50, 300, 300);
		this.window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window1.setVisible(true);
		this.window1.addWindowFocusListener(this);
		
		this.window2.setBounds(400, 50, 300 ,300);
		this.window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window2.setVisible(true);
		this.window2.addWindowFocusListener(this);;
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource() == this.window1) this.window1.setTitle("Focused");
		else this.window2.setTitle("Focused");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		if(e.getSource() == this.window1) this.window1.setTitle("");
		else this.window2.setTitle("");
	}
}