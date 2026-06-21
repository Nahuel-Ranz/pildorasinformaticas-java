package secondpart.sockets.firstchat.server;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import secondpart.sockets.firstchat.MessageWrapped;

public class ServerPannel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private JTextArea area;
	private MessageWrapped data;
	private HashMap<String, String> clients;
	
	public ServerPannel() {
		super.setLayout(new BorderLayout());
		this.area = new JTextArea();
		this.clients = new HashMap<String, String>();
		
		super.add(this.area, BorderLayout.CENTER);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		try (ServerSocket server = new ServerSocket(5555)){
			
			while(true) {
				try (
					Socket socket = server.accept();
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())
				) {					
					Object input = ois.readObject();
					
					if(input instanceof String) {
						String into = (String) input;
						String user = (String)ois.readObject();
						String ip = socket.getInetAddress().getHostAddress();

						switch(into) {
							case "CONNECT":
								this.clients.put(ip, user);
								this.area.append("Connected: %s\n".formatted(user));
								this.clients.forEach((k, v) -> {
									try (
										Socket cli = new Socket(k, 9294);
										ObjectOutputStream oos = new ObjectOutputStream(cli.getOutputStream());
									) { oos.writeObject(this.clients); }
									catch(Exception e) { e.printStackTrace(); }
								});
							break;
							case "DISCONNECT":
								this.clients.remove(ip);
								this.area.append("Disconnected: %s\n".formatted(user));
								this.clients.forEach((k, v) -> {
									try (
										Socket cli = new Socket(k, 9294);
										ObjectOutputStream oos = new ObjectOutputStream(cli.getOutputStream());
									) {
										oos.writeObject(ip);
									} catch (Exception e) { e.printStackTrace(); }
								});
							break;
						}
					} else {					
						this.data = (MessageWrapped) input;
						this.area.append(this.data+ "\n");
						
						try (				
							Socket target = new Socket(this.data.getIp(), 9294);
							ObjectOutputStream oos = new ObjectOutputStream(target.getOutputStream());
						) { oos.writeObject(this.data); }
						catch(IOException e) { this.area.append("Shipping error"); }
					}
				} catch(Exception e) {
					System.out.println("The attempt failed. %s | %s"
						.formatted(e.getClass().getSimpleName(), e.getMessage()));
					e.printStackTrace();
				}
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
}