package secondpart.sockets.firstchat.client;
import javax.swing.JFrame;

public class ClientFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ClientFrame() {
		super.setSize(250, 400);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(new ClientPannel());
		super.setVisible(true);
	}
}