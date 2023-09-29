import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	@Override
	public PApplet draw(PApplet c) {
		c.background(120);
		c.text("Press space bar to start", 130, 150);
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
