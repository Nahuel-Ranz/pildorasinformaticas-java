package secondpart.sockets.firstchat.client;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(new SetOffline(this, user));
		super.add(new ClientPannel(user));
		super.setVisible(true);
		new Thread(() -> {
			try {
				//Thread.sleep(1000);
				try (
						Socket socket = new Socket("192.168.56.1", 5555);
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())
				) {
					oos.writeObject("CONNECT");
					oos.writeObject(user);
				}
			} catch(Exception e) { e.printStackTrace(); }
		}).start();
	}
}

class SetOffline extends WindowAdapter {
	private JFrame frame;
	private String user;
	
	public SetOffline(JFrame frame, String user) {
		this.frame = frame;
		this.user = user;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		new Thread(() -> {
			try (
				Socket socket = new Socket("192.168.56.1", 5555);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			) {
				oos.writeObject("DISCONNECT");
				oos.writeObject(this.user);
				oos.flush();
			} catch(Exception ex) { ex.printStackTrace(); }
			finally { System.exit(0); }
		}).start();
	}
}