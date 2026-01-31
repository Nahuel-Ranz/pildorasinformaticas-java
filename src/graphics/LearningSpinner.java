package graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import static graphics.Utils.getFonts;

public class LearningSpinner {
	public static void main(String []args) {
		new SpinnerFrame().setVisible(true);
	}
}

class SpinnerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public SpinnerFrame() {
		super.setBounds(300, 50, 400, 200);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new SpinnerPannel());
	}
}

class SpinnerPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel north;
	private JPanel center;
	private JPanel south;
	private JLabel dateLabel;
	private JLabel numberLabel;
	private JLabel listLabel;
	private JSpinner dateSpinner;
	private JSpinner numberSpinner;
	private JSpinner listSpinner;

	public SpinnerPannel() {
		super.setLayout(new BorderLayout(5, 10));
		
		this.north = new JPanel();
		this.center = new JPanel();
		this.south = new JPanel();
		
		this.dateLabel = new JLabel("DATE");
		this.listLabel = new JLabel("LIST");
		this.numberLabel = new JLabel("NUMBERS");
		
		this.dateSpinner = new JSpinner(new SpinnerDateModel());
		//this.numberSpinner = new JSpinner(new SpinnerReverseCounter());
		this.numberSpinner = new JSpinner(new SpinnerNumberModel(35, 0, 100, 5) {
			@Override
			public Object getNextValue() {return super.getPreviousValue();}
			
			@Override
			public Object getPreviousValue() {return super.getNextValue();}
		});
		
		this.listSpinner = new JSpinner(new SpinnerListModel(getFonts()));
		this.listSpinner.setPreferredSize(new Dimension(200, 20));
		
		this.north.add(this.dateLabel);
		this.north.add(this.dateSpinner);
		this.center.add(this.numberLabel);
		this.center.add(this.numberSpinner);
		this.south.add(this.listLabel);
		this.south.add(this.listSpinner);
		
		super.add(this.north, BorderLayout.NORTH);
		super.add(this.center, BorderLayout.CENTER);
		super.add(this.south, BorderLayout.SOUTH);
	}
	
	/*private class SpinnerReverseCounter extends SpinnerNumberModel {
		private static final long serialVersionUID = 1L;
		
		public SpinnerReverseCounter() {super(35, 0, 100, 5);}
		
		@Override
		public Object getNextValue() {return super.getPreviousValue();}
		
		@Override
		public Object getPreviousValue() {return super.getNextValue();}
	}*/
}