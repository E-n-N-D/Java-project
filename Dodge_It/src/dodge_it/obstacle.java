package dodge_it;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class obstacle {
	//87, 195 ,298
	int height = 40, width = 40;
	Random rand;
	public int y, y_difference = 50, yVel = 1;
	public int lane[] = new int[2];
	public int obstacle_number, score = 0;
	
	public obstacle(int i) {		
		if(i == 0) {
			y = 0;
			obstacle_number = 1;
		}
		else if(i == 1) {
			y = -250;
			obstacle_number = 2;
		}
		lane_setter();
	}
	
	public void lane_setter() {
		rand = new Random();
		lane[0] = rand.nextInt(3);
		if(lane[0] == 0) {
			lane[1] = rand.nextInt(2) + 1;
		}
		else if(lane[0] == 1) {
			lane[1] = Math.random() > 0.5? 0 : 2  ;
		}
		else {
			lane[1] = rand.nextInt(2);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		if(lane[0] == 0 || lane[1] == 0) {
			g.fillRect(87 - width/2, y, width, height);
		}
		if(lane[0] == 1 || lane[1] == 1) {
			g.fillRect(195 - width/2, y, width, height);
		}
		if(lane[0] == 2 || lane[1] == 2) {
			g.fillRect(298 - width/2, y, width, height);
		}
				
	}
	
	public void reset() {
		if(obstacle_number == 1) {
			y = -250;
		}
		else{
			y = 0;
		}
		score = 0;
		yVel = 1;
	}
	
	
	public void move(object o) {
			y += yVel;
			if(y>=500) {
				y = 0;
				score += 1;
				lane_setter();
			}
		
	}
}
