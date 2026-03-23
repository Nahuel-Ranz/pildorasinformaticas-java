package firstpart.graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class LearningJToolBar {
	public static void main(String[] args) {
		new TBFrame().setVisible(true);
	}
}

class TBFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel pannel;
	private JMenu menu;
	private JMenuBar bar;
	private JToolBar tb;
	private Action red, yellow, blue;
	
	public TBFrame() {
		super.setBounds(50, 20, 700, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pannel = new JPanel();
		super.add(this.pannel);
		
		this.menu = new JMenu("Color");
		this.red = new BackgroundColor("Red", Color.RED);
		this.yellow = new BackgroundColor("Yellow", Color.YELLOW);
		this.blue = new BackgroundColor("Blue", Color.BLUE);
		this.menu.add(red);
		this.menu.add(blue);
		this.menu.add(yellow);
		this.bar = new JMenuBar();
		
		this.bar.add(this.menu);
		super.setJMenuBar(this.bar);
		
		this.tb = new JToolBar();
		this.tb.add(blue);
		this.tb.add(red);
		this.tb.add(yellow);
		this.tb.addSeparator();
		this.tb.add(new AbstractAction("Exit") {
			@Override
			public void actionPerformed(ActionEvent e) {System.exit(0);}
		});
		super.add(this.tb, BorderLayout.NORTH);
	}
	
	private class BackgroundColor extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public BackgroundColor(String name, Color color) {
			super.putValue(Action.NAME, name);
			super.putValue(Action.SHORT_DESCRIPTION, "Color: %s".formatted(name));
			super.putValue("Color", color);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pannel.setBackground((Color)getValue("Color"));
		}
	}
}