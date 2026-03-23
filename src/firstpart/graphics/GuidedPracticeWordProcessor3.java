package firstpart.graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyleConstants;

public class GuidedPracticeWordProcessor3 {
	public static void main(String []args) {
		new WPFrame3().setVisible(true);
	}
}

class WPFrame3 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public WPFrame3() {
		super.setBounds(100, 30, 400, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new WPPannel3());
	}
}

class WPPannel3 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel menuPannel;
	private JMenuBar bar;
	private JMenu fonts, styles, sizes;
	private JTextPane pane;
	private JToolBar toolBar;
	private JMenuItem aux;
	private Action aux1;
	private JButton aux2;
	private ButtonGroup radioGroup;
	private JPopupMenu popup;
	
	public WPPannel3() {
		super.setLayout(new BorderLayout());
		this.menuPannel = new JPanel();
		this.menuPannel.setLayout(new FlowLayout());
		this.popup = new JPopupMenu();
		this.toolBar = new JToolBar(1);
		
		this.pane = new JTextPane();
		this.bar = new JMenuBar();
		this.fonts = new JMenu("Fonts");
		this.styles = new JMenu("Styles");
		this.sizes = new JMenu("Sizes");
		
		addFonts();
		addSizes();
		addStyles();
		Utils.addMenusToBar(bar, fonts, styles, sizes);
		
		this.pane.setComponentPopupMenu(this.popup);
		this.menuPannel.add(this.bar);
		super.add(this.menuPannel, BorderLayout.NORTH);
		super.add(this.pane, BorderLayout.CENTER);
		super.add(this.toolBar, BorderLayout.WEST);
	}
	
	private void addFonts() {
		Arrays.stream(Utils.getFonts()).forEach( font -> {
			aux = new JMenuItem(font);
			aux.addActionListener(new StyledEditorKit.FontFamilyAction("changeTipography", font));
			this.fonts.add(aux);
		});
		aux = null;
	}
	
	private void addSizes() {
		radioGroup = new ButtonGroup();
		
		for(int i = 6; i<72; i+=2) {
			int size = i;
			aux = new JRadioButtonMenuItem(size+ "");
			aux.addActionListener(new StyledEditorKit.FontSizeAction("changeFont", size));
			
			radioGroup.add(aux);
			this.sizes.add(aux);
		}
		aux = null;
	}
	
	private void addStyles() {
		Arrays.stream(new String[] {"Bold","Italic","Underline","Red","Yellow","Blue","Center","Right","Left","Justify"})
			.forEach( style -> {
			switch(style) {
				case "Bold": aux1 = new StyledEditorKit.BoldAction(); break;
				case "Italic": aux1 = new StyledEditorKit.ItalicAction(); break;
				case "Underline": aux1 = new StyledEditorKit.UnderlineAction(); break;
				case "Red": aux1 = new StyledEditorKit.ForegroundAction("setRed", Color.RED); break;
				case "Blue": aux1 = new StyledEditorKit.ForegroundAction("setBlue", Color.BLUE); break;
				case "Yellow": aux1 = new StyledEditorKit.ForegroundAction("setYellow", Color.YELLOW); break;
				case "Center": aux1 = new StyledEditorKit.AlignmentAction(style, StyleConstants.ALIGN_CENTER); break;
				case "Left": aux1 = new StyledEditorKit.AlignmentAction(style, StyleConstants.ALIGN_LEFT); break;
				case "Right": aux1 = new StyledEditorKit.AlignmentAction(style, StyleConstants.ALIGN_RIGHT); break;
				case "Justify": aux1 = new StyledEditorKit.AlignmentAction(style, StyleConstants.ALIGN_JUSTIFIED); break;
			}
			
			aux1.putValue(Action.NAME, style);
			aux = new JMenuItem(aux1);
			switch(style) {
				case "Bold": aux.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK)); break;
				case "Italic": aux.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK)); break;
				case "Underline": aux.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK)); break;
			}
			
			aux2 = new JButton(new ImageIcon(getClass().getResource("/images/%s.png".formatted(style.toLowerCase()))));
			aux2.addActionListener(aux1);
			
			this.styles.add(aux);
			this.popup.add(new JMenuItem(aux1));
			this.toolBar.add(aux2);
			//new JCheckBoxMenuItem(aux1)
		});
		aux1 = null;
		aux = null;
		aux2 = null;
	}
}