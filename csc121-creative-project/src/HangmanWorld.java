import processing.core.*;
import processing.event.KeyEvent;

public class HangmanWorld {
    HangmanImage h;
    WordImage w;

    public HangmanWorld() {
        h = new HangmanImage(0);
        w = new WordImage("pearl");
    }
    
    public HangmanWorld(HangmanImage h, WordImage w) {
        this.h = h;
        this.w = w;
    }

    public PApplet draw(PApplet c) {
        c.background(255);
        h.draw(c);
        w.draw(c);
        return c;
    }
    
    public HangmanWorld update() {
        return this;
    }
    
    public HangmanWorld keyPressed(KeyEvent kev) {
        char ch = Character.toLowerCase( kev.getKey() );
       /* (ch >= 'a' &&   ch <= 'z')  */
        return new HangmanWorld( h.update(), w.update() );
    }


}
