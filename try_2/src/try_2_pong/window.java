package try_2_pong;

import javax.swing.JFrame;

public class window {
	public static void main(String args[]) {
		final int HEIGHT = 500, WIDTH = HEIGHT * 16/9;
		panel p = new panel();
		JFrame f = new JFrame();
		f.add(p);
		f.setVisible(true);
		f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("PING PONG");
	}
}
