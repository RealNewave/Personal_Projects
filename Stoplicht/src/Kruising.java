import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Kruising implements Runnable {

	private Scherm scherm;
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	private boolean stateX = false ,stateY = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Kruising(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}

	private void init() {
		scherm = new Scherm(title, width, height);
	}

	int x = 0, y = 0;
	private void update() {
		if(x == width){
			stateX = true;
		}
		else if(x <= 0){
			stateX = false;
		}
		
		
		if(y == height){
			stateY = true;
		}
		else if(y <= 0){
			stateY = false;
		}
		x = stateX ? x - 5 : x + 2;
		y = stateY ? y - 3 : y + 1;
		}
		
	

	private void render() {
		bs = scherm.getCanvas().getBufferStrategy();
		if(bs == null){
			scherm.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0,0,width,height);
		
		
		g.fillRect(y,x,20,30);
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now -lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1){
				update();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
	}

	public synchronized void start() {
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
