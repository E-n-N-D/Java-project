package try_2_pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class panel extends JPanel implements Runnable, KeyListener {
	final int HEIGHT = 500, WIDTH = HEIGHT * 16/9;
	double x = 0, y = 0, velY = 2;
	Thread thread;
	paddle p1,p2;
	ball b;
	
	//Timer t = new Timer(5, this);
	
	public panel() {
		addKeyListener(this);
		setFocusable(true);
		p1 = new paddle(1);
		p2 = new paddle(2);
		b = new ball();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		p1.draw(g);
		p2.draw(g);
		b.draw(g);
		//t.start();
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p2.setUpgoing(true);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpgoing(true);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p2.setDowngoing(true);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			p1.setDowngoing(true);
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p2.setUpgoing(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p2.setDowngoing(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpgoing(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			p1.setDowngoing(false);
		}
	}


	public void run() {
		for(;;) {
			p1.move();
			p2.move();
			b.move(p1, p2);
			b.check(p1, p2);
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*public void actionPerformed(ActionEvent e) {
		if (y<0) {
			y+=velY;
			repaint();
		}
		else if (y>420) {
			y-=velY;
			repaint();
		}
		
	}*/

}
