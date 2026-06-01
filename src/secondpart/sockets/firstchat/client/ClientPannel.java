package secondpart.sockets.firstchat.client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JTextField field, nick, ip;
	private JButton btn;
	private JTextArea chatField;
	
	public ClientPannel() {
		this.nick = new JTextField(5);
		this.label = new JLabel("CHAT");
		this.ip = new JTextField(10);
		this.field = new JTextField(20);
		this.btn = new JButton("Send");
		this.chatField = new JTextArea(16, 20);
		
		super.add(this.nick);
		super.add(this.label);
		super.add(this.ip);
		super.add(this.chatField);
		
		this.btn.addActionListener(_ -> {
			try {
				Socket socket = new Socket("192.168.0.104", 5555);
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(this.field.getText());
				
				dos.close();
				//socket.close();
			} catch(UnknownHostException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		});
		super.add(this.field);
		super.add(this.btn);
	}
}