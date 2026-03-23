package firstpart.graphics;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FreeLayout {
	public static void main(String[] args) {
		new FreeFrame().setVisible(true);
	}
}

class FreeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public FreeFrame() {
		super.setBounds(40, 20, 300, 300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new FreePannel());
	}
}

class FreePannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel name, lastName, age, phone;
	private JTextField nameField, lastNameField, ageField, phoneField;
	
	public FreePannel() {
		//super.setLayout(null); // free layout
		super.setLayout(new ToColumn());
		
		this.name = new JLabel("Name: ");
		this.lastName = new JLabel("Last name: ");
		this.age = new JLabel("Age: ");
		this.phone = new JLabel("Phone: ");
		this.nameField = new JTextField();
		this.lastNameField = new JTextField();
		this.ageField = new JTextField();
		this.phoneField = new JTextField();
		
		/*this.name.setBounds(30, 10, 80, 20);
		this.nameField.setBounds(110, 10, 150, 20);
		this.lastName.setBounds(30, 40, 80, 20);
		this.lastNameField.setBounds(110, 40, 150, 20);*/
		
		super.add(this.name);
		super.add(this.nameField);
		super.add(this.lastName);
		super.add(this.lastNameField);
		super.add(this.age);
		super.add(this.ageField);
		super.add(this.phone);
		super.add(this.phoneField);
	}
}

class ToColumn implements LayoutManager {
	private int x=0, y=50;

	@Override
	public void addLayoutComponent(String name, Component comp) {}

	@Override
	public void removeLayoutComponent(Component comp) {}

	@Override
	public Dimension preferredLayoutSize(Container parent) {return null;}

	@Override
	public Dimension minimumLayoutSize(Container parent) {return null;}

	@Override
	public void layoutContainer(Container container) {
		int column = 1;
		int cw = container.getWidth(); // container width
	//	int ch = container.getHeight(); // container height
		int ew= 100; // element widths
		int eh = 20; // element heights
		
		for(Component c : container.getComponents()) {
			c.setBounds(((cw/2)-ew)+x, y, ew, eh);
			x+=ew;
			
			if(column++ == 2) {
				x=0;
				y+=30;
				column = 1;
			}
		}
	}
}