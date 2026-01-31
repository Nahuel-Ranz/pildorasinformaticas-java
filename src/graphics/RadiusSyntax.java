package graphics;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadiusSyntax {
	public static void main(String []args) {
		new Radius1Frame().setVisible(true);
	}
}

class Radius1Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Radius1Frame() {
		super.setBounds(30, 30, 400, 100);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(new Radius1Pannel());
	}
}

class Radius1Pannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup colours, genders;
	private JRadioButton red, blue, yellow, male, female;
	
	public Radius1Pannel() {
		this.colours = new ButtonGroup();
		this.genders = new ButtonGroup();
		
		this.colours.add(this.red = new JRadioButton("RED", false));
		this.colours.add(this.blue = new JRadioButton("BLUE", false));
		this.colours.add(this.yellow = new JRadioButton("YELLOW", true));
		this.genders.add(this.male = new JRadioButton("MALE", false));
		this.genders.add(this.female = new JRadioButton("FEMALE", true));
		
		super.add(this.red);
		super.add(this.blue);
		super.add(this.yellow);
		super.add(this.male);
		super.add(this.female);
	}
}