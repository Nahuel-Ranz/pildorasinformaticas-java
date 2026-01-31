package graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

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
	private JMenuItem aux;
	private ButtonGroup radioGroup;
	
	public WPPannel3() {
		super.setLayout(new BorderLayout());
		this.menuPannel = new JPanel();
		this.menuPannel.setLayout(new FlowLayout());
		
		this.pane = new JTextPane();
		this.bar = new JMenuBar();
		this.fonts = new JMenu("Fonts");
		this.styles = new JMenu("Styles");
		this.sizes = new JMenu("Sizes");
		
		addFonts(this.fonts);
		addSizes(this.sizes);
		addStyles(this.styles, this.pane);
		Utils.addMenusToBar(bar, fonts, styles, sizes);
		
		this.menuPannel.add(this.bar);
		super.add(this.menuPannel, BorderLayout.NORTH);
		super.add(this.pane, BorderLayout.CENTER);
	}
	
	private void addFonts(JMenu menu) {
		Arrays.stream(Utils.getFonts()).forEach( font -> {
			aux = new JMenuItem(font);
			aux.addActionListener(new StyledEditorKit.FontFamilyAction("changeTipography", font));
			menu.add(aux);
		});
		aux = null;
	}
	
	private void addSizes(JMenu menu) {
		radioGroup = new ButtonGroup();
		
		for(int i = 0; i<100; i++) {
			int size = i;
			aux = new JRadioButtonMenuItem(size+ "");
			aux.addActionListener(new StyledEditorKit.FontSizeAction("changeFont", size));
			
			menu.add(aux);
			radioGroup.add(aux);
		}
		aux = null;
	}
	
	private void addStyles(JMenu menu, JTextPane pane) {
		String[] styles = {"Bold", "Italic"};
		
		Arrays.stream(styles).forEach( style -> {
			aux = new JCheckBoxMenuItem(
				style,
				new ImageIcon(getClass().getResource("/images/%s.png".formatted(style.toLowerCase())))
			);
			if(style.equals("Bold")) aux.addActionListener(new StyledEditorKit.BoldAction());
			if(style.equals("Italic")) aux.addActionListener(new StyledEditorKit.ItalicAction());
			menu.add(aux);
		});
		aux = null;
	}
}