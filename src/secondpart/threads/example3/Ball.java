package secondpart.threads.example3;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private static final int SIZE_X=15, SIZE_Y=15;
	private double x=0, y=0, dx=1, dy=1;
	
	public void moveBall(Rectangle2D container) {
		x+=dx;
		y+=dy;
		
		if(x<container.getMinX()) {
			x=container.getMinX();
			dx=-dx;
		}
		
		if(x+SIZE_X >= container.getMaxX()) {
			x= container.getMaxX()-SIZE_X;
			dx=-dx;
		}
		
		if(y<container.getMinY()) {
			y = container.getMinY();
			dy=-dy;
		}
		
		if(y+SIZE_Y >= container.getMaxY()) {
			y = container.getMaxY()-SIZE_Y;
			dy=-dy;
		}
	}
	
	public Ellipse2D getShape() { return new Ellipse2D.Double(x, y, SIZE_X, SIZE_Y); }
}