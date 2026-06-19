package secondpart.sockets.firstchat;
import static javax.swing.JOptionPane.showInputDialog;
import secondpart.sockets.firstchat.client.ClientFrame;

public class InitClient {
	public static void main(String[] args) {
		ClientFrame client = new ClientFrame(showInputDialog("Who are you?"));
	}
}