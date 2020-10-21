package try_2_pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ball {
	int x = 440 ,y = 250, xAccel = -3, yAccel = 2;
	public ball() {

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	
	public void check(paddle p1, paddle p2) {
		
		if(this.x - 10 == p1.x+20) {
			if(this.y >= p1.y && this.y <= (p1.y+80)) {	
				xAccel = -xAccel;
			}
		}
		else if(this.x + 10 == 849) {
			if(this.y >= p2.y && this.y <= (p2.y+80)) {
				xAccel = -xAccel;
			}
		}
	}
	
	public void up_or_low_strike(paddle p1, paddle p2) {
		if((this.y >= p1.y && this.y < (p1.y+80)/2) || (this.y >= p2.y && this.y < (p2.y+80)/2)) {
			yAccel = -Math.abs(yAccel);
		}
		else if((this.y > (p1.y+80)/2 && this.y <= (p1.y+80)) || (this.y > (p2.y+80)/2 && this.y <= (p2.y+80))) {
			yAccel = Math.abs(yAccel);
		}
	}
	
	public void reset() {
		x = 440;
		y = 250;
		xAccel = (Math.random() >= 0.5)? xAccel : -xAccel;
		yAccel = (Math.random() >= 0.5)? yAccel : -yAccel;
		
	}
	
	public void move(paddle p1, paddle p2) {

		x += xAccel;
		y += yAccel;		
		
		if(y<4) {
			yAccel = 2;
		}
		else if(y>440) {
			yAccel = -2;
		}
		
		if(x<25 || x>849) {	
			reset();
			p1.reset();
			p2.reset();
		}
	}
}
