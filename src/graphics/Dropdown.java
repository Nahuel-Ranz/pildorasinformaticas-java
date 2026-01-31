package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dropdown {
	public static void main(String []args) {
		new ComboFrame().setVisible(true);
	}
}

class ComboFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ComboFrame() {
		this.setBounds(50, 50, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(new ComboPannel());
	}
}

class ComboPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	private JComboBox dropdown;
	private Combo listener;
	private JLabel text;
	private JPanel pannel;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ComboPannel() {
		this.setLayout(new BorderLayout());
		this.text = new JLabel("Somewhere, in my garage ... ");
		this.text.setHorizontalAlignment(SwingConstants.CENTER); // ------
		this.text.setOpaque(true); // ------------------------------------
		this.text.setBackground(Color.GREEN); // -------------------------
		this.text.setFont(new Font("Serif", Font.PLAIN, 18));
		this.add(text, BorderLayout.CENTER);
		
		this.pannel = new JPanel();
		this.dropdown = new JComboBox();
		this.dropdown.setEditable(true);
		this.dropdown.addItem("Serif");
		this.dropdown.addItem("Sans-serif");
		this.dropdown.addItem("Arial");
		this.dropdown.addItem("Dialog");
		this.dropdown.addItem("Monospaced");
		this.dropdown.addItem("Monserrat");
		this.dropdown.addItem("Times New Roman");
		
		this.listener = new Combo();
		this.dropdown.addActionListener(this.listener);
		this.pannel.add(this.dropdown);
		
		this.add(this.pannel, BorderLayout.NORTH);
	}
	
	private class Combo implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			text.setFont(new Font((String)dropdown.getSelectedItem(), Font.PLAIN, 18));
		}
	}
}