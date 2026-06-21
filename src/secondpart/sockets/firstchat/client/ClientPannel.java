package secondpart.sockets.firstchat.client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import secondpart.sockets.firstchat.MessageWrapped;

public class ClientPannel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private JTextField field;
	private JComboBox ips;
	private JButton btn;
	private JTextArea chatField;
	private MessageWrapped data;
	private HashMap<String, String> clients;
	
	public ClientPannel(String user) {
		this.label = new JLabel("ONLINE");
		this.ips = new JComboBox();
		
		this.field = new JTextField(20);
		this.chatField = new JTextArea(16, 20);
		
		this.btn = new JButton("Send");
		this.btn.addActionListener(_ -> {
			new Thread(() -> {
				try (
					Socket socket = new Socket("192.168.56.1", 5555);
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())
				) {
					
					data = new MessageWrapped(user, field.getText(), (String)ips.getSelectedItem());
					oos.writeObject(data);
					
					this.chatField.append("Me: %s -> %s\n".formatted(field.getText(), (String)ips.getSelectedItem()));
					field.setText("");					
				} catch(UnknownHostException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}).start();
		});
		
		super.add(this.label);
		super.add(this.ips);
		super.add(this.chatField);
		super.add(this.field);
		super.add(this.btn);
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		try (ServerSocket server = new ServerSocket(9294)){
			while(true) {
				try (
					Socket socket = server.accept();
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
				) {
					Object input = ois.readObject();
					if(input instanceof MessageWrapped) {
						this.data = (MessageWrapped) input;
						this.chatField.append("%s: %s -> Me\n".formatted(data.getNick(), data.getMessage()));
					} else if(input instanceof String) {
						this.ips.removeItem((String)input);
						this.clients.remove((String)input);
					} else {
						Thread.sleep(1000);
						this.clients = (HashMap<String, String>) input;
						
						this.ips.removeAllItems();
						this.clients.forEach((k,v) -> {
							this.ips.addItem(k);
						});
					}
				} catch(Exception e) { e.printStackTrace();}
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
}