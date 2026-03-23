package firstpart.graphics;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FreeLayoutCircle {
	public static void main(String[] args) {
		Scanner into = new Scanner(System.in);
		
		IO.println("How many points do you want to add? ");
		int points = into.nextInt(); into.close();
		
		new FLCircle(points<3 ? 3 : points).setVisible(true);
	}
}

class FLCircle extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public FLCircle(int points) {
		super.setBounds(50, 50, 600, 600);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new FLPannel(points));
	}
}

class FLPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JLabel> points;
	
	public FLPannel(int points) {
		super.setLayout(new CircleFormer());
		this.points = new ArrayList<JLabel>();
		
		for(int i=0; i<points; i++) this.points.add(new JLabel("*"));
		this.points.forEach( p -> super.add(p));
	}
}

class CircleFormer implements LayoutManager {
	@Override
	public void addLayoutComponent(String name, Component comp) {}

	@Override
	public void removeLayoutComponent(Component comp) {}

	@Override
	public Dimension preferredLayoutSize(Container parent) {return null;}

	@Override
	public Dimension minimumLayoutSize(Container parent) {return null;}

	@Override
	public void layoutContainer(Container parent) {
		int count = parent.getComponentCount();
		
		int centerX = parent.getWidth()/2;
		int centerY = parent.getHeight()/2;
		
		double angleStep = (2*Math.PI) / count;
		Component[] comps = parent.getComponents();
		
		Dimension d = comps[0].getPreferredSize();
		int size = Math.max(d.width, d.height);
		
		double radius = size / (2 * Math.sin(angleStep/2));
		
		for(int i=0; i<count; i++) {
			Component c = comps[i];
			Dimension dim = c.getPreferredSize();
			
			double angle = i * angleStep - Math.PI /2;
			
			int compCenterX = (int)(centerX + radius * Math.cos(angle));
			int compCenterY = (int)(centerY + radius * Math.sin(angle));
			
			int x = compCenterX - dim.width / 2;
			int y = compCenterY - dim.height / 2;
			
			c.setBounds(x, y, dim.width, dim.height);
		}
	}
}