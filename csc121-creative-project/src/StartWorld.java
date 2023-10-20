import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {
	private PImage start; // title screen background image
	
	final static int IMAGEX = 0;
	final static int IMAGEY = 0;
	
	public StartWorld() {
		this.start = null;
	}

	@Override
	public PApplet draw(PApplet c) {
		if (start == null) {
			start = c.loadImage("hangman.png");
		}
		c.background(start);
		c.image(start, IMAGEX, IMAGEY);
		// c.background(120);
		//c.text("Press space bar to start", 130, 150);
		return c;
	}

	@Override
	public IWorld update() {
		return this;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return new HangmanWorld();
		} else {
			return this;
		}
	}

}
