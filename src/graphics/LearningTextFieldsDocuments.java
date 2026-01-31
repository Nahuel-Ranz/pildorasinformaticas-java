package graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class LearningTextFieldsDocuments {
	public static void main(String []args) {
		new FrameWithDocument().setVisible(true);
	}
}

class FrameWithDocument extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public FrameWithDocument() {
		setBounds(50, 30, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		super.add(new PannelWithDocument());
	}
}

class PannelWithDocument extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField field;
	private Document doc;
	
	public PannelWithDocument() {
		this.field = new JTextField(20);
		this.doc = this.field.getDocument();
		this.doc.addDocumentListener(new ListenText());
		
		super.add(this.field);
	}
	
	private class ListenText implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {IO.println("Inserted text");}

		@Override
		public void removeUpdate(DocumentEvent e) {IO.println("Deleted text");}

		@Override
		public void changedUpdate(DocumentEvent e) {}
	}
}