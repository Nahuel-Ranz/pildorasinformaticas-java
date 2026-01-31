package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Checks {
	public static void main(String []args) {
		new ChFrame().setVisible(true);
	}
}

class ChFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ChPannel pannel;
	
	public ChFrame() {
		this.setBounds(30, 30, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pannel = new ChPannel();
		this.add(this.pannel);
	}
}

class ChPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel text;
	private JCheckBox boldCheck, cursiveCheck;
	private Font letter;
	private JPanel textPannel;
	private JPanel checkPannel;
	
	public ChPannel() {
		super.setLayout(new BorderLayout());
		this.letter = new Font("Serif", Font.PLAIN, 24);
		this.text = new JLabel("Help, I need somebody ... ");
		this.text.setFont(this.letter);
		
		this.textPannel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.textPannel.setBackground(Color.RED);
		this.textPannel.add(this.text);
		super.add(textPannel, BorderLayout.CENTER);
		
		this.boldCheck = new JCheckBox("Bold");
		this.cursiveCheck = new JCheckBox("Cursive");
		
		this.boldCheck.addActionListener(new CheckHandler());
		this.cursiveCheck.addActionListener(new CheckHandler());
		
		this.checkPannel = new JPanel();
		this.checkPannel.add(this.boldCheck);
		this.checkPannel.add(this.cursiveCheck);
		super.add(this.checkPannel, BorderLayout.SOUTH);
	}
	
	private class CheckHandler implements ActionListener {
		private int type = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			this.type = 0;
			if(boldCheck.isSelected()) type += Font.BOLD;
			if(cursiveCheck.isSelected()) type += Font.ITALIC;
			text.setFont(new Font("Serif", this.type, 24));
		}
	}
}