import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;

	public abstract void update();

	public abstract void render(Graphics g);
}
