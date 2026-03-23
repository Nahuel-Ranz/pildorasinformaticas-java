package secondpart.threads.example2;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BallPannel extends JPanel {
	private static final long serialVersionUID = 123L;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public void add(Ball b) { balls.add(b); }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		balls.forEach( b -> g2.fill(b.getShape()));
	}
}