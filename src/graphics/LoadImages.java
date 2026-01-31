package graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadImages {

	public static void main(String []args) {
		new IFrame(600).setVisible(true);
		new IFrame(400).setVisible(true);
	}
}

class IFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private int side;
	private IPannel pannel;
	
	public IFrame(int side) {
		this.side = side;
		
		setTitle("Square Frame with Image");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(this.side, this.side);
		
		this.pannel = new IPannel();
		add(pannel);
	}
}

class IPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Image img;
	private int x; // image width
	private int y; // image height
	
	public IPannel() {		
		try { this.img = ImageIO.read(getClass().getResource("/images/javaIcon.png")); }
		catch (NullPointerException e) { Utils.println("Se debe de establecer una ruta al archivo!!!"); }
		catch (IOException e) { Utils.println("Image not found!!!"); }
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.DARK_GRAY);
		
		if(img == null) return;
		g.drawImage(this.img, 0, 0, this);
		this.x = this.img.getWidth(this);
		this.y = this.img.getHeight(this);
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) g.copyArea(0, 0, this.x, this.y, this.x*j, this.y*i);
		}
	}
}