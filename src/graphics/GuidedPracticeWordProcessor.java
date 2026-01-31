package graphics;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class GuidedPracticeWordProcessor {
	public static void main(String []args) {
		new WPFrame().setVisible(true);
	}
}

class WPFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public WPFrame() {
		super.setBounds(100, 30, 400, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new WPPannel());
	}
}

class WPPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel menuPannel;
	private JMenuBar bar;
	private JMenu fonts, styles, sizes;
	private JTextPane pane;
	
	private JMenuItem aux;
	private Object[] currentFont = {"Arial", Font.PLAIN, 12};
	
	public WPPannel() {
		super.setLayout(new BorderLayout());
		this.menuPannel = new JPanel();
		this.menuPannel.setLayout(new FlowLayout());
		
		this.pane = new JTextPane();
		this.bar = new JMenuBar();
		this.fonts = new JMenu("Fonts");
		this.styles = new JMenu("Styles");
		this.sizes = new JMenu("Sizes");
		
		addFonts(this.fonts, this.pane);
		addSizes(this.sizes, this.pane);
		addStyles(this.styles, this.pane);
		Utils.addMenusToBar(bar, fonts, styles, sizes);
		
		this.menuPannel.add(this.bar);
		super.add(this.menuPannel, BorderLayout.NORTH);
		super.add(this.pane, BorderLayout.CENTER);
	}
	
	private void addFonts(JMenu menu, JTextPane pane) {
		Arrays.stream(Utils.getFonts()).forEach( font -> {
			aux = new JMenuItem(font);
			aux.addActionListener( _ -> {
				currentFont[0] = font;
				pane.setFont(new Font(font, (int)currentFont[1], (int)currentFont[2]));
			});
			menu.add(aux);
		});
		aux = null;
	}
	
	private void addSizes(JMenu menu, JTextPane pane) {
		for(int i = 0; i<100; i++) {
			int size = i;
			aux = new JMenuItem(size+ "");
			aux.addActionListener( _ -> {
				currentFont[2] = size;
				pane.setFont(new Font((String)currentFont[0], (int)currentFont[1], size));
			});
			menu.add(aux);
		}
		aux = null;
	}
	
	private void addStyles(JMenu menu, JTextPane pane) {
		String[] styles = {"Plain", "Bold", "Italic"};
		boolean[] b = {false, false}; // bold[0]; italic[1]
		
		for(int i=0; i<styles.length; i++) {
			int style = i;
			aux = new JMenuItem(styles[style]);
			aux.addActionListener( _ -> {
				currentFont[1] = style;
				switch(style) {
					case 0: b[0] = b[1] = false; break;
					case 1: b[0] = !b[0]; break;
					case 2: b[1] = !b[1]; break;
				}
				pane.setFont(new Font(
					(String)currentFont[0],
					b[0]&&b[1] ? 3 : b[1] ? 2 : b[0] ? 1 : 0,
					(int)currentFont[2]
				));
			});
			menu.add(aux);
		}
		aux = null;
	}
}