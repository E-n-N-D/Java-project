package dodge_it;

import java.awt.Color;
import java.awt.Graphics;

public class border {
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 40, 500);
		g.fillRect(350, 0, 40, 500);
	}
}
