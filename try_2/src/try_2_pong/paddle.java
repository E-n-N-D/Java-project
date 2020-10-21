package try_2_pong;

import java.awt.Color;
import java.awt.Graphics;

public class paddle {
	int x, p;
	int y = 190, yVel = 0;
	boolean Upgoing = false, Downgoing = false;
	
	public paddle(int player) {
		p = player;
		if(player == 1) {
			x = 5;
		}
		else {
			x = 849;
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		if(this.p == 1) {
			g.fillRect(x, (int)y, 20, 80);
		}
		else {
			g.fillRect(x, (int)y, 20, 80);
		}
	}
	
	public void move() {
		if(Upgoing) {
			if(y>4) {
				yVel = -2;
			}
			else yVel = 0;
		}
		else if(Downgoing) {
			if(y<380) {
				yVel = 2;
			}
			else yVel = 0;
		}
		else if(!Upgoing && !Downgoing) {
			yVel *= 0.5;
		}
		y += yVel;
	}
	public void setUpgoing(boolean input) {
		Upgoing = input;
	}
	public void setDowngoing(boolean input) {
		Downgoing = input;
	}
	
	public void reset() {
		if(p == 1) {
			x = 5;
		}
		else {
			x = 849;
		}
		y = 190;
	}
	
}
