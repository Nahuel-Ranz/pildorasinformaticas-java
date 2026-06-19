package secondpart.sockets.firstchat.client;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;

public class ClientFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ClientFrame(String user) {
		super.setSize(250, 400);
		super.setTitle(user);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(new ClientPannel(user));
		super.setVisible(true);
		new Thread(() -> {
			try {
				//Thread.sleep(1000);
				try (
						Socket socket = new Socket("192.168.56.1", 5555);
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())
				) {
					oos.writeObject(null);
					oos.writeObject(user);
				}
			} catch(Exception e) { e.printStackTrace(); }
		}).start();
	}
}