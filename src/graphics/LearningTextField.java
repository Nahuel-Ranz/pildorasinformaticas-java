package graphics;
import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LearningTextField {
	public static void main(String []args) {
		new TFrame().setVisible(true);
	}
}

class TFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public TFrame() {
		setBounds(100, 40, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new TPannel());
	}
}

class TPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel pannel;
	private JTextField field1;
	private JButton btn;
	private JLabel label;
	private JLabel result;
	
	public TPannel() {
		this.setLayout(new BorderLayout());
		
		this.pannel = new JPanel();
		this.pannel.setLayout(new FlowLayout());
		// this.field1 = new JTextField("Hello World"); // the width is equals to the text width.
		this.label = new JLabel("Email");
		this.field1 = new JTextField(20); // width = 20;
		this.btn = new JButton("Verificate");
		this.btn.addActionListener(new GetText());
		this.result = new JLabel("", JLabel.CENTER);
		
		this.pannel.add(this.label);
		this.pannel.add(this.field1);
		this.pannel.add(this.btn);
		this.add(this.pannel, BorderLayout.NORTH);
		this.add(this.result, BorderLayout.CENTER);
	}
	
	class GetText implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(field1.getText()
					.trim()
					.matches("^\\w{4,150}@\\w{3,}.[a-zA-Z]{2,64}$")) result.setText("Correct");
			else result.setText("Incorrect");
		}
	}
}
