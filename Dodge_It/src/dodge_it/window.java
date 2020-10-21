package dodge_it;

import javax.swing.JFrame;

public class window {
	public window() {
		final int HEIGHT = 500, WIDTH = 400;
		panel p = new panel();
		JFrame f = new JFrame();
		p.setSize(WIDTH, HEIGHT);
		f.add(p);
		f.setVisible(true);
		f.setSize(WIDTH, HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Dodge It");
		f.setLocation(0, 0);
		System.out.println(p.getSize().width + ", " + p.getSize().height);
		System.out.println(f.getSize().width + ", " + f.getSize().height);
	}
	public static void main(String args[]) {
		new window();
	}
}
