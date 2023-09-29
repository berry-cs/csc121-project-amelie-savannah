import processing.core.*;
import processing.event.KeyEvent;

public class HangmanWorld implements IWorld {
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
    
    public IWorld update() {
        return this;
    }
    
    /** updates the world according to the key press */
    public IWorld keyPressed(KeyEvent kev) {
    	if (kev.getKey() == '.') {  //if the '.' is pressed, a new world is returned
    		return new StartWorld();
    	} else if (this.w.wordDone()) {  //if the word is already finished the world will not update
    		return this;
    	} else if (this.h.manFilled()) {  //if the hangman is already full the world will not update
    		return this;
    	} else {
	        char ch = Character.toLowerCase( kev.getKey() );
	       /* (ch >= 'a' &&   ch <= 'z')  */
	        if (this.w.isInWord(ch)) {    //if the key pressed is a letter in the word:
	        	this.w.makeGuess(ch);  //"make the guess" --> updates the wordImage
	        	return new HangmanWorld( this.h, w.update() ); //returns HangmanWorld without updating the HangmanImage, but updates the WordImage
	        } else {
	        	this.w.status++;   //increases the WordImage status if the key press is not in the word(kinda bogus rn, not sure if we need it)
	        	return new HangmanWorld( h.update(), w.update() );  //returns a HangmanWorld, updating the HangmanImage to account for the wrong guess
	        }
    	}
    }


}
