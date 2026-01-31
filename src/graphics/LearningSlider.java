package graphics;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LearningSlider {
	public static void main(String []args) {
		new SliderFrame().setVisible(true);
	}
}

class SliderFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public SliderFrame() {
		super.setBounds(30, 30, 400, 200);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new SliderPannel());
	}
}

class SliderPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JSlider control;
	
	public SliderPannel() {
		super.setLayout(new BorderLayout());
		this.label = new JLabel("This is mine!!!");
		this.label.setFont(new Font("Calibri", Font.BOLD, 12));
		this.label.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.control = new JSlider(10, 20, 12);
		this.control.setMajorTickSpacing(2);
		this.control.setMinorTickSpacing(1);
		this.control.setPaintTicks(true);
		this.control.setSnapToTicks(true);
		
		this.control.setFont(new Font("Times New Roman", Font.ITALIC, 10));
		this.control.setPaintLabels(true);
		this.control.addChangeListener(new SliderHandler());
		super.add(this.label, BorderLayout.CENTER);
		super.add(this.control, BorderLayout.SOUTH);
	}
	
	private class SliderHandler implements ChangeListener {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			label.setFont(new Font("Calibri", Font.BOLD, control.getValue()));
		}
	}
}