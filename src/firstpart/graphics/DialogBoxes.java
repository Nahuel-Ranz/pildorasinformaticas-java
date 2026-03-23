package firstpart.graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogBoxes {
	public static void main(String[] args) {
		new DialogFrame().setVisible(true);
	}
}

class DialogFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public DialogFrame() {
		super.setBounds(30, 20, 500, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new DialogPannel());
	}
}

class DialogPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton btn1, btn2, btn3, btn4;
	
	public DialogPannel() {
		this.btn1 = new JButton("Button 1");
		this.btn2 = new JButton("Button 2");
		this.btn3 = new JButton("Button 3");
		this.btn4 = new JButton("Button 4");
		
		this.btn1.addActionListener(new ButtonAction());
		this.btn2.addActionListener(new ButtonAction());
		this.btn3.addActionListener(new ButtonAction());
		this.btn4.addActionListener(new ButtonAction());
		Utils.addButtonsToPanel(this, btn1, btn2, btn3, btn4);
	}
	
	private class ButtonAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1) {
				JOptionPane.showMessageDialog(DialogPannel.this, "Kira Ford", "Yellow Power", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/images/yellowDinoRanger.gif")));
			} else if(e.getSource() == btn2) {
				JOptionPane.showInputDialog(DialogPannel.this, "This is a showInputDialog element");
			} else if(e.getSource() == btn3) {
				JOptionPane.showConfirmDialog(DialogPannel.this, "Choose your option:", "Option", JOptionPane.YES_NO_CANCEL_OPTION);
			} else if(e.getSource() == btn4){
				JOptionPane.showOptionDialog(
					DialogPannel.this,
					"Test Message 4",
					"Title",
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.ERROR_MESSAGE,
					new ImageIcon(getClass().getResource("/images/redDinoRanger.gif")),
					new String[] {"ONE", "TWO", "THREE"},
					null
				);
			}
		}
		
	}
}