package dodge_it;
import java.awt.Color;
import java.awt.Graphics;

public class lane {
	public int height = 25, width = 10, yVel = 2;
	public double y;
	boolean not_started = true;
	public lane(int y_point) {
		y = y_point;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((140 - width/2), (int)y, width, height);
		g.fillRect(250 - width/2, (int)y, width, height);
	}
	
	public void move() {
		y += yVel;
		if(y>= 500) {
			y = 0;
		}
	}
}