package secondpart.sockets.firstchat.client;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JTextField field;
	private JButton btn;
	
	public ClientPannel() {
		this.label = new JLabel("CLIENT");
		this.field = new JTextField(20);
		this.btn = new JButton("Send");
		
		super.add(this.label);
		super.add(this.field);
		
		this.btn.addActionListener(_ -> {
			try {
				Socket socket = new Socket("ip", 5555);
			} catch(UnknownHostException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		});
		super.add(this.btn);
	}
}