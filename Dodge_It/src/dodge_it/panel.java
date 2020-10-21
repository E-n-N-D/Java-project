package dodge_it;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
import javax.swing.JPanel;

public class panel extends JPanel implements Runnable, KeyListener{
	final int HEIGHT = 500, WIDTH = 400;
	Thread thread;
	border b;
	lane[] lan;
	object obj;
	obstacle[] o;
	//ArrayList<obstacle>o;			=> this makes an arraylist of obstacles
	Random r = new Random();
	//Timer timer;
	//TimerTask timer_task;
	
	public panel() {
		addKeyListener(this);
		setFocusable(true);
		setSize(WIDTH, HEIGHT);
		
		b = new border();
		lan = new lane[10];
		int j = 0, lane_diff = 50;
		for(int i = 0 ; i < 10; i++) {
			lan[i] = new lane(j);
			j+= lane_diff;
		}
		obj = new object();
		o = new obstacle[2];
		o[0] = new obstacle(0);
		o[1] = new obstacle(1);
		//o = new ArrayList<obstacle>();
		//timer = new Timer();
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		b.draw(g);
		for (int i = 0; i<10; i++) {
			lan[i].draw(g);
		}
		for(int i = 0; i<2; i++) {
			o[i].draw(g);
		}
		
		/*This can also be done but it makes stacks of obstacles but is easier to handle
		 => timer.schedule(new TimerTask() {
		 
			@Override
			public void run() {
            	o.add(new obstacle());
            	try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
		},1000);
		/*timer.schedule(new TimerTask() {
			@Override
			public void run() {
            	o.add(new obstacle());
        	}
		},5000);*/
		
		obj.draw(g);
		for(int i = 0; i<2; i++) {
			o[i].draw(g);
		}
		g.setFont(new Font("arial",Font.PLAIN, 20));
		g.drawString("Score: " + (o[1].score+o[0].score), 160, 50);
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			obj.moveRight();
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			obj.moveLeft();
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			obj.game_started = true;
		}
	}

	public void run() {
		for(;;) {
			if(obj.game_started) {
				for(int i = 0; i<10; i++) {
					lan[i].move();
				}
				o[0].move(obj);
				o[1].move(obj);
				for(int i = 0; i<2; i++) {
					if(o[i].y >= 360 && o[i].y <= 440) {
						if(o[i].lane[0] == obj.lane || o[i].lane[1] == obj.lane) {
							o[0].reset();
							o[1].reset();
							for(int j = 0; j<10; j++) {
								lan[j].yVel = 2;
							}
							obj.game_started = false;
						}
					}
					if(o[i].score > 2 && o[i].score <= 5) {
						o[0].yVel = 2;
						o[1].yVel = 2;
						for(int j = 0; j<10; j++) {
							lan[j].yVel = 3;
						}
						
					}
					else if(o[i].score > 5 && o[i].score <= 10) {
						o[1].yVel = 3;
						o[0].yVel = 3;
						for(int j = 0; j<10; j++) {
							lan[j].yVel = 4;
						}
					}
					else if(o[i].score > 10 && o[i].score <= 50) {
						o[0].yVel = 4;
						o[1].yVel = 4;
						for(int j = 0; j<10; j++) {
							lan[j].yVel = 5;
						}
					}
					else if(o[i].score >= 50 && o[i].score < 80) {
						o[0].yVel = 5;
						o[1].yVel = 5;
						for(int j = 0; j<10; j++) {
							lan[j].yVel = 6;
						}
					}
				}
			}
			
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}
