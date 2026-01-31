package graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MultipleSources1 {
	public static void main(String []args) {
		new MSFrame().setVisible(true);
	}
}

class MSFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MSFrame() {
		setBounds(30, 30, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Action Test");
		
		add(new MSPannel());
	}
}

class MSPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton btnYellow;
	private JButton btnBlue;
	private JButton btnRed;
	private BackColor yellowAction;
	private BackColor blueAction;
	private BackColor redAction;
	private InputMap into;
	private ActionMap am;
	
	MSPannel() {
		this.yellowAction = new BackColor(
			"Yellow",
			new ImageIcon(getClass().getResource("/images/yellowDinoRanger.gif")),
			Color.YELLOW,
			this
		);
		
		this.blueAction = new BackColor(
			"Blue",
			new ImageIcon(getClass().getResource("/images/blueDinoRanger.gif")),
			Color.BLUE,
			this
		);
		
		this.redAction = new BackColor(
			"Red",
			new ImageIcon(getClass().getResource("/images/redDinoRanger.gif")),
			Color.RED,
			this
		);		
		
		this.btnYellow = new JButton(this.yellowAction);
		this.btnBlue = new JButton(this.blueAction);
		this.btnRed = new JButton(this.redAction);
		
		this.yellowAction.addJButton(this.btnYellow);
		this.blueAction.addJButton(this.btnBlue);
		this.redAction.addJButton(this.btnRed);
		
		super.add(this.btnYellow);
		super.add(this.btnBlue);
		super.add(this.btnRed);
		
		this.into = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		this.into.put(KeyStroke.getKeyStroke("ctrl Y"), "yellowBack");
		this.into.put(KeyStroke.getKeyStroke("ctrl B"), "blueBack");
		this.into.put(KeyStroke.getKeyStroke("ctrl R"), "redBack");
		
		this.am = getActionMap();
		this.am.put("yellowBack", this.yellowAction);
		this.am.put("blueBack", this.blueAction);
		this.am.put("redBack", this.redAction);
	}
	
}

class BackColor extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MSPannel pannel;
	private JButton btn;
	
	public BackColor(String name, Icon icon, Color btnColor, MSPannel pannel) {
		super.putValue(Action.NAME, name);
		super.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "Set the following color as background: %s".formatted(name));
		super.putValue("backgroundColor", btnColor);
		this.pannel = pannel;
	}
	
	public void addJButton(JButton btn) {
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.pannel.setBackground((Color)getValue("backgroundColor"));
		this.btn.setBackground((Color)getValue("backgroundColor"));
	}
}
