package graphics;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import static java.awt.Toolkit.getDefaultToolkit;
import static graphics.Utils.centrate;

public class CreateCenteredFrame {
	public static void main(String []args) {
		new CenteredFrame();
	}
}

class CenteredFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public CenteredFrame() {
		var tk = getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		
		int width = screen.width/3;
		int height = screen.height/3;

		setVisible(true);
		setTitle("Marco centrado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(width, height);
		setLocation(centrate(screen.width,width), centrate(screen.height, height));
		
		Image icon = tk.getImage("src/graphics/javaIcon.png");
		setIconImage(icon);
	}
}