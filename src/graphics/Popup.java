package graphics;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Popup {
	public static void main(String[] args) {
		new PopupFrame().setVisible(true);
	}
}

class PopupFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public PopupFrame() {
		super.setBounds(30, 30, 300, 200);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new PopupPannel());
	}
}

class PopupPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPopupMenu popup;
	private JMenuItem option;
	
	public PopupPannel() {
		this.popup = new JPopupMenu();
		this.option = new JMenuItem("Option 1");
		this.popup.add(this.option);
		
		super.setComponentPopupMenu(this.popup);
	}
}