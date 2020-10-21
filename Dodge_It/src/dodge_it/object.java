package dodge_it;

import java.awt.Color;
import java.awt.Graphics;

public class object {
	//87.5,190, 302
	public int x = 195, y = 400, lane = 1;
	int height = 40, width = 40;
	public boolean game_started = false;
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x - width/2, y, width, height);
	}
	public void moveRight() {
		if(lane == 0) {
			x = 195;
			lane = 1;
		}
		else if(lane == 1) {
			x = 298;
			lane = 2;
		}
		else if(lane == 2) {
			x = 298;
			lane = 2;
		}	
	}
	public void moveLeft() {
		if(lane == 0) {
			x = 87;
			lane = 0;
		}
		else if(lane == 1) {
			x = 87;
			lane = 0;
		}
		else if(lane == 2) {
			x = 195;
			lane = 1;
		}
	}
}
