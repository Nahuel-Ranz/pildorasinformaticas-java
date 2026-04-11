package secondpart.sockets.firstchat.server;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextArea area;
	
	public ServerPannel() {
		super.setLayout(new BorderLayout());
		this.area = new JTextArea();
		
		super.add(this.area, BorderLayout.CENTER);
	}
}