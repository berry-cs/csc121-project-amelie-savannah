import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {
	private PImage photo;
	
	public StartWorld() {
		photo = null;
	}

	@Override
	public PApplet draw(PApplet c) {
		if (photo == null) {
			 photo = c.loadImage("hangman.png");
		}
		c.background(photo);
		c.image(photo, 0, 0);
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
