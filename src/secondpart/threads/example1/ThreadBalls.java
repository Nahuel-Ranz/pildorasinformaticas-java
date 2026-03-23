package secondpart.threads.example1;
import java.awt.Component;

public class ThreadBalls implements Runnable {
	private Component component;
	private Ball ball;
	
	public ThreadBalls(Component component, Ball ball) {
		this.component = component;
		this.ball = ball;
	}
	
	@Override
	public void run() {
		for(int i=0; i<3000; i++) {
			this.ball.moveBall(this.component.getBounds());
			this.component.paint(component.getGraphics());
			
			try { Thread.sleep(3); }
			catch(InterruptedException e) { IO.println(e); }
		}
	}
}