package firstpart.graphics.exercises.showjoptionpane;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Frame() {
		super.setTitle("Swing Exercise");
		super.setSize(700, 400);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new Pannel());
	}
}