package secondpart.threads.example1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReboundFrame extends JFrame {
	private static final long serialVersionUID = 2234224L;
	private BallPannel ballPannel;
	private JPanel btnPannel;
	private JButton btn;
	private Ball ball;
	private Runnable runnable;
	Thread thread;
	
	public ReboundFrame() {
		super.setSize(400,350);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle ("Rebounds");
		
		ballPannel=new BallPannel();
		super.add(ballPannel, BorderLayout.CENTER);
		
		this.btnPannel = new JPanel();
		this.addButton(btnPannel, "PLAY", _ -> this.play());
		this.addButton(btnPannel, "EXIT", _ -> System.exit(0));
		
		super.add(btnPannel, BorderLayout.SOUTH);
	}
	
	public void addButton(Container c, String title, ActionListener listener) {
		this.btn = new JButton(title);
		this.btn.addActionListener(listener);
		c.add(this.btn);
	}
	
	public void play() {
		this.ball = new Ball();
		this.ballPannel.add(this.ball);
		
		this.runnable = new ThreadBalls(ballPannel, ball);
		this.thread = new Thread(runnable);
		thread.start();
	}
}