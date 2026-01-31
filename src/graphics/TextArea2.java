package graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea2 {
	public static void main(String []args) {
		new TAFrame2().setVisible(true);
	}
}

class TAFrame2 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel btnPannel;
	private JButton enterBtn, breakRowBtn;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public TAFrame2() {
		super.setBounds(100, 30, 600, 300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		
		this.btnPannel = new JPanel();
		this.enterBtn = new JButton("Enter");
		this.breakRowBtn = new JButton("Wrap");
		this.textArea = new JTextArea();
		this.scrollPane = new JScrollPane(this.textArea);
		
		this.enterBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Add this text to the end of the line.");
			}
		});
		
		this.breakRowBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setLineWrap(!textArea.getLineWrap());
				breakRowBtn.setText(textArea.getLineWrap() ? "No Wrap" : "Wrap");
			}
		});
		
		this.btnPannel.add(this.enterBtn);
		this.btnPannel.add(this.breakRowBtn);
		super.add(this.btnPannel, BorderLayout.SOUTH);
		super.add(this.scrollPane, BorderLayout.CENTER);
	}
}