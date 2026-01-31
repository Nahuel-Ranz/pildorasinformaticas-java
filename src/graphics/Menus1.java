package graphics;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menus1 {
	public static void main(String[] args) {
		new MenuFrame().setVisible(true);
	}
}

class MenuFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MenuFrame() {
		super.setBounds(100, 30, 400, 100);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new MenuPannel());
	}
}

class MenuPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JMenuBar bar;
	private JMenu file;
	private JMenu edit;
	private JMenu tools;
	private JMenu gender; // JMenuItem(JMenu)
	private JMenuItem save;
	private JMenuItem saveAs;
	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem generals;
	private JMenuItem rock;
	private JMenuItem pop;
	private JMenuItem classical;
	private JMenuItem reggae;
	
	public MenuPannel() {
		this.bar = new JMenuBar();
		
		this.file = new JMenu("File");
		this.edit = new JMenu("Edit");
		this.tools = new JMenu("Tools");
		this.gender = new JMenu("Options");
		
		this.save = new JMenuItem("Save");
		this.saveAs = new JMenuItem("Save As ...");
		this.cut = new JMenuItem("Cut", new ImageIcon(getClass().getResource("/images/cut.png")));
		this.copy = new JMenuItem("Copy", new ImageIcon(getClass().getResource("/images/copy.png")));
		this.paste = new JMenuItem("Paste", new ImageIcon(getClass().getResource("/images/paste.png")));
		this.generals = new JMenuItem("Generals");
		this.rock = new JMenuItem("Rock");
		this.pop = new JMenuItem("Pop");
		this.classical = new JMenuItem("Classical Music");
		this.reggae = new JMenuItem("Reggae");
		
		this.addItemsToMenu(file, save, saveAs);
		this.addItemsToMenu(edit, cut, copy, paste);
		this.addItemsToMenu(gender, rock, pop, classical, reggae);
		this.edit.addSeparator();
		this.edit.add(gender);
		
		this.addItemsToMenu(tools, generals);
		this.addMenuToBar(bar, file, edit, tools);
		
		super.add(this.bar);
	}
	
	private void addItemsToMenu(JMenu menu, JMenuItem... items) {
		Arrays.stream(items).forEach( item -> menu.add(item));
	}
	
	private void addMenuToBar(JMenuBar bar, JMenu... menus) {
		Arrays.stream(menus).forEach( menu -> bar.add(menu));
	}
}