package secondpart.threads.example3;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import firstpart.graphics.Utils;

public class ReboundFrame extends JFrame {
	private static final long serialVersionUID = 2234224L;
	private static int count = 1;
	private BallPannel ballPannel;
	private JPanel btnPannel;
	private JMenu menu;
	private JMenuBar bar;
	private JButton btn;
	private Ball ball;
	private Runnable runnable;
	
	public ReboundFrame() {
		super.setSize(400,350);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle ("Rebounds");
		
		this.bar = new JMenuBar();
		this.menu = new JMenu("Threads");
		
		this.bar.add(this.menu);
		this.setJMenuBar(this.bar);
		
		this.ballPannel=new BallPannel();
		super.add(this.ballPannel, BorderLayout.CENTER);
		
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
		Thread thread = new Thread(runnable);
		JMenuItem item = new JMenuItem("Thread_%d".formatted(count++));
		
		item.addActionListener(_ -> {
			thread.interrupt();
			this.menu.remove(item);
			this.menu.revalidate();
			this.menu.repaint();
		});
		
		Utils.addItemsToMenu(this.menu, item);
		this.menu.revalidate();
		this.menu.repaint();
		
		thread.start();
	}
}