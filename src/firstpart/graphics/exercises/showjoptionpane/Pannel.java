package firstpart.graphics.exercises.showjoptionpane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private String delimiter = "\\|";
	private HashMap<String, String[]> options;
	private JButton show;
	private JPanel grid, buttonContainer;
	
	public Pannel() {
		super.setLayout(new BorderLayout());
		
		this.grid = new JPanel(new GridLayout(2, 3, 5, 5));
		this.buttonContainer = new JPanel(new FlowLayout());
		this.show = new JButton("Show");
		
		fillOptions();
		this.options.forEach((k, v) -> this.grid.add(new MyBox(k, v)));
		
		this.show.addActionListener( _ -> {
			HashMap<String, String> pairs = new HashMap<String, String>();
			
			Arrays.stream(this.grid.getComponents()).forEach( c -> {
				MyBox box = (MyBox)c;
				pairs.put(box.getTitle(), box.getSelectedItemString());
			});
			
			if(pairs.get("Type") == null) return;
			
			switch(pairs.get("Type")) {
				case "Message":
					JOptionPane.showMessageDialog(
						this,
						message(pairs.get("Message")),
						"TITLE",
						messageType(pairs.get("Message Type"))
					);
				break;
				case "Confirm":
					JOptionPane.showConfirmDialog(
						this,
						message(pairs.get("Message")),
						"TITLE",
						confirm(pairs.get("Confirm")),
						messageType(pairs.get("Message Type"))
					);
				break;
				case "Option":
					JOptionPane.showOptionDialog(
						this,
						message(pairs.get("Message")),
						"TITLE",
						confirm(pairs.get("Confirm")),
						messageType(pairs.get("Message Type")),
						null,
						option(pairs.get("Option")),
						null
					);
				break;
				case "Entry":
					if(pairs.get("Entry") == null) return;
					JOptionPane.showInputDialog(
						this,
						message(pairs.get("Message")),
						"TITLE",
						messageType(pairs.get("Message Type")),
						null,
						selectionValues(pairs.get("Entry")),
						null
					);
				break;
			}
		});
		this.buttonContainer.add(this.show);
		
		super.add(this.grid, BorderLayout.CENTER);
		super.add(this.buttonContainer, BorderLayout.SOUTH);
	}
	
	private void fillOptions() {
		this.options = new HashMap<String, String[]>();
		
		this.options.put("Type", "Message|Confirm|Option|Entry".split(delimiter));
		this.options.put("Message Type", "ERROR_MESSAGE|INFORMATION_MESSAGE|WARNING_MESSAGE|QUESTION_MESSAGE|PLAIN_MESSAGE".split(delimiter));
		this.options.put("Message", "String|Icon|Component|Others|Object[]".split(delimiter));
		this.options.put("Confirm", "DEFAULT_OPTION|YES_NO_OPTION|YES_NO_CANCEL_OPTION|OK_CANCEL_OPTION".split(delimiter));
		this.options.put("Option", "String[]|Icon[]|Object[]".split(delimiter));
		this.options.put("Entry", "Text Field|Comb".split(delimiter));
	}
	
	private int messageType(String messageType) {
		try {
			
			return switch(messageType) {
				case "ERROR_MESSAGE" -> JOptionPane.ERROR_MESSAGE;
				case "INFORMATION_MESSAGE" -> JOptionPane.INFORMATION_MESSAGE;
				case "WARNING_MESSAGE" -> JOptionPane.WARNING_MESSAGE;
				case "QUESTION_MESSAGE" -> JOptionPane.QUESTION_MESSAGE;
				default -> JOptionPane.PLAIN_MESSAGE;
			};
		} catch(NullPointerException e) {
			return JOptionPane.PLAIN_MESSAGE;
		}
	}
	
	private int confirm(String confirm) {
		try {
			
			return switch(confirm) {
				case "YES_NO_OPTION" -> JOptionPane.YES_NO_OPTION;
				case "YES_NO_CANCEL_OPTION" -> JOptionPane.YES_NO_CANCEL_OPTION;
				case "OK_CANCEL_OPTION" -> JOptionPane.OK_CANCEL_OPTION;
				default -> JOptionPane.DEFAULT_OPTION;
			};
		} catch(NullPointerException e) {
			return JOptionPane.DEFAULT_OPTION;
		}
	}
	
	private Object message(String message) {
		JPanel pannel = new JPanel();
		pannel.setBackground(Color.GREEN);
		
		Object[] object = {
			"This is the message",
			new ImageIcon(getClass().getResource("/images/javaIcon.png")),
			pannel,
			new GregorianCalendar().getTime()
		};
		
		try {
			
			return switch(message) {
				case "String" ->	object[0];
				case "Icon" ->		object[1];
				case "Component" ->	object[2];
				case "Others" ->	object[3];
				case "Object[]" ->	object;
				default -> null;
			};
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	private Object[] option(String option) {
		try {
			return switch(option) {
				case "String[]" -> new String[] {"Dog", "Cat", "Parrot", "Bull", "Horse"};
				case "Icon[]" -> new ImageIcon[] {
					new ImageIcon(getClass().getResource("/images/blue.png")),
					new ImageIcon(getClass().getResource("/images/yellow.png")),
					new ImageIcon(getClass().getResource("/images/red.png")),
					new ImageIcon(getClass().getResource("/images/copy.png")),
					new ImageIcon(getClass().getResource("/images/cut.png")),
					new ImageIcon(getClass().getResource("/images/paste.png"))
				};
				case "Object[]" -> new Object[] {
						new ImageIcon(getClass().getResource("/images/yellowDinoRanger.gif")),
						new GregorianCalendar().getTime(),
						new JLabel("This is a Label")
				};
				default -> new String[] {""};
			};
		} catch(NullPointerException e) {
			return new String[] {""};
		}
	}
	
	private Object[] selectionValues(String selectionValues) {
		if(selectionValues.equals("Text Field")) return null;
		
		return new Object[] {
				new ImageIcon(getClass().getResource("/images/yellow.png")),
				new ImageIcon(getClass().getResource("/images/blue.png")),
				new ImageIcon(getClass().getResource("/images/red.png")),
				new ImageIcon(getClass().getResource("/images/bold.png")),
				new ImageIcon(getClass().getResource("/images/italic.png")),
				new ImageIcon(getClass().getResource("/images/plain.png")),
				new ImageIcon(getClass().getResource("/images/javaIcon.png")),
				new ImageIcon(getClass().getResource("/images/cut.png"))
		};
	}
}