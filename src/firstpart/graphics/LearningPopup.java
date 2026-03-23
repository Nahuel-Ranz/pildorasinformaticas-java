package firstpart.graphics;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class LearningPopup {
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
	
	private JPanel menuPannel;
	private JMenuBar bar;
	private JMenu fonts, styles, sizes;
	private JMenuItem option, option2, option3;
	private JTextPane text;
	private JPopupMenu popup;
	
	public PopupPannel() {
		super.setLayout(new BorderLayout());
		
		this.menuPannel = new JPanel();
		this.bar = new JMenuBar();
		this.fonts = new JMenu("Fonts");
		this.styles = new JMenu("Styles");
		this.sizes = new JMenu("Sizes");
		
		Utils.addMenusToBar(bar, fonts, styles, sizes);
		this.menuPannel.add(this.bar);
		super.add(this.menuPannel, BorderLayout.NORTH);
		
		this.popup = new JPopupMenu();
		this.option = new JMenuItem("Option 1");
		this.option2 = new JMenuItem("Option 2");
		this.option3 = new JMenuItem("Option 3");
		Utils.addItemsToPopup(popup, option, option2, option3);		
		
		this.text = new JTextPane();
		this.text.setComponentPopupMenu(this.popup);
		super.add(this.text, BorderLayout.CENTER);
	}
}