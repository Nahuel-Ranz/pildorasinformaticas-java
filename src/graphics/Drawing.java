package graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static java.awt.Toolkit.getDefaultToolkit;

import static graphics.Utils.centrate;

public class Drawing {
	public static void main(String []args) {
		new DFrame();
	}
}

class DFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private int width;
	private int height;
	private DPannel pannel;
	
	public DFrame() {
		var tk = getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		
		this.width = screen.width/2;
		this.height = screen.height/2;
		this.pannel = new DPannel();
		add(this.pannel);
		
		setVisible(true);
		setTitle("Frame to draw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(this.width, this.height);
		setLocation(
				centrate(screen.width, this.width),
				centrate(screen.height, this.height)
		);
	}
}

class DPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(Color.DARK_GRAY);
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangle = new Rectangle2D.Double(100, 100, 300, 100);
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rectangle);
		
		// font handling -----------------------------------
		Font font = new Font("Courier New", Font.BOLD, 30);
		g2.setFont(font);
		g2.setPaint(Color.LIGHT_GRAY);
		g2.drawString("Nahue", 100, 50);
		// -------------------------------------------------
		
		g2.setPaint(Color.GRAY);
		g2.fill(rectangle);
		
		g2.setPaint(Color.CYAN);
		g2.draw(ellipse);
		
		g2.setPaint(new Color(255, 0, 0, 150).brighter().brighter());
		g2.draw(new Line2D.Double(100, 100, 400, 200));
		
		double centerX = rectangle.getCenterX();
		double centerY = rectangle.getCenterY();
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+200, centerY+75);
		
		g2.draw(circle);
	}
}