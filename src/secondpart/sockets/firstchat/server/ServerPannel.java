package secondpart.sockets.firstchat.server;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerPannel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private JTextArea area;
	
	public ServerPannel() {
		super.setLayout(new BorderLayout());
		this.area = new JTextArea();
		
		super.add(this.area, BorderLayout.CENTER);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(5555);
			
			while(true) {
				Socket socket = server.accept();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				
				this.area.append(dis.readUTF()+ "\n");
				
				dis.close();
				//socket.close();
				//server.close();
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
}