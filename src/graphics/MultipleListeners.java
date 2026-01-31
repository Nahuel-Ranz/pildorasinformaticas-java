package graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultipleListeners {
	public static void main(String []args) {		
		var frame = new MLFrame();
		frame.setVisible(true);
	}
}

class MLFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MLFrame() {
		setBounds(50, 50, 350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new MLPannel());
	}
}

class MLPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton newJB;
	private JButton closeAll;
	
	public MLPannel() {
		this.newJB = new JButton("New");
		this.closeAll = new JButton("Close All");
		
		super.add(this.newJB);
		super.add(this.closeAll);
		
		this.newJB.addActionListener(new newListener());
	}
	
	private class newListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new PopUp(closeAll);
		}
	}
}

class PopUp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static int id = 1;
	
	public PopUp(JButton closeWindow) {
		super.setTitle("Window %d".formatted(PopUp.id++));
		super.setBounds(30*PopUp.id, 20*PopUp.id, 500, 200);
		super.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		closeWindow.addActionListener(new CloseAll());
		
		super.setVisible(true);
	}
	
	private class CloseAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {dispose();}
	}
}