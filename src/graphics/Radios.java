package graphics;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Radios {
	public static void main(String []args) {
		new RadiosFrame().setVisible(true);
	}
}

class RadiosFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public RadiosFrame() {
		super.setBounds(30, 30, 400, 200);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new RadiosPannel());
	}
}

class RadiosPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel btnPannel;
	private JLabel text;
	private ButtonGroup group;
	private JRadioButton small, medium, large, extraLarge;
	
	public RadiosPannel() {
		super.setLayout(new BorderLayout());
		
		this.text = new JLabel("Somewhere, in the Earth Planet ...", JLabel.CENTER);
		super.add(this.text, BorderLayout.CENTER);
		
		this.group = new ButtonGroup();
		this.btnPannel = new JPanel();
		btnHandler(this.small, "Small", false, 10);
		btnHandler(this.medium, "Medium", true, 14);
		btnHandler(this.large, "Large", false, 18);
		btnHandler(this.extraLarge, "Extra Large", false, 24);
		
		super.add(this.btnPannel, BorderLayout.SOUTH);
	}
	
	private void btnHandler(JRadioButton btn, String text, boolean selected, int size) {
		btn = new JRadioButton(text, selected);
		btn.addActionListener( _ -> setFont(size));
		this.group.add(btn);
		this.btnPannel.add(btn);
	}
	private void setFont(int size) {
		text.setFont(new Font("Serif", Font.PLAIN, size));
	}
}