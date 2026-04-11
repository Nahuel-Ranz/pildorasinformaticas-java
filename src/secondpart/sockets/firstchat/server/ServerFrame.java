package secondpart.sockets.firstchat.server;
import javax.swing.JFrame;

public class ServerFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public ServerFrame() {
		super.setSize(300, 400);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(new ServerPannel());
		super.setVisible(true);
	}
}