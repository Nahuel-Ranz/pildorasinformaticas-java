package firstpart.graphics;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewLayoutBox {
	public static void main(String[] args) {
		new BoxFrame().setVisible(true);
	}
}

class BoxFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Box nameHBox, passwordHBox, buttons, vertical;
	
	public BoxFrame() {
		super.setBounds(50, 30, 300, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.nameHBox = this.createHorizontalBox("Name");
		this.passwordHBox = this.createHorizontalBox("Password");
		this.buttons = this.createHorizontalBox("Cancel", "Accept");
		
		this.vertical = Box.createVerticalBox();
		Utils.addHorizontalBoxesInVerticalBox(vertical, nameHBox, passwordHBox, buttons);
		super.add(vertical, BorderLayout.CENTER);
	}
	
	private Box createHorizontalBox(String labelText) {
		Box box = Box.createHorizontalBox();
		var label = new JLabel(labelText);
		var field = new JTextField(10);
		field.setMaximumSize(field.getPreferredSize());
		
		box.add(label);
		box.add(Box.createHorizontalStrut(10));
		box.add(field);
		
		return box;
	}
	
	private Box createHorizontalBox(String str1, String str2) {
		Box box = Box.createHorizontalBox();
		var btn1 = new JButton(str1);
		var btn2 = new JButton(str2);
		
		box.add(btn1);
		box.add(Box.createHorizontalGlue());
		box.add(btn2);
		
		return box;
	}
}