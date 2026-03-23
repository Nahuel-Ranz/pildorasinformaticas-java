package firstpart.graphics.exercises.showjoptionpane;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyBox extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group;
	private String title;
	
	public MyBox(String title, String... options) {
		super.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.title = title;
		this.group = new ButtonGroup();
		Arrays.stream(options).forEach( option -> {
			JRadioButton btn = new JRadioButton(option);
			btn.setActionCommand(option);
			
			this.group.add(btn);
			super.add(btn);
		});
	}
	
	public ButtonGroup getGroup() {return this.group;}
	public ButtonModel getSelectedItem() {return this.group.getSelection();}
	
	public String getSelectedItemString() {
		try {return getSelectedItem().getActionCommand();}
		catch(NullPointerException e) {return null;}
	}
	
	public String getTitle() {return this.title;}
}