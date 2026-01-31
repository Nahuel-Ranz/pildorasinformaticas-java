package graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea1 {
	public static void main(String []args) {
		new TAFrame().setVisible(true);
	}
}

class TAFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public TAFrame() {
		super.setBounds(300, 300, 500, 300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new TAPannel());
	}
}

class TAPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextArea ta;
	private JScrollPane scrollPannel;
	private JButton btn;
	
	public TAPannel() {
		super.setBackground(Color.DARK_GRAY);
		this.ta = new JTextArea(8, 20);
		this.ta.setLineWrap(true);
		
		this.scrollPannel = new JScrollPane(this.ta);
		super.add(this.scrollPannel);
		
		this.btn = new JButton("Come on");
		this.btn.addActionListener(new CheckArea());
		super.add(this.btn);
	}
	
	private class CheckArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			IO.println(ta.getText());
		}
	}
}