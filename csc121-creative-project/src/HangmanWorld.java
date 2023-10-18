import processing.core.*;
import java.util.Random;
import processing.event.KeyEvent;

public class HangmanWorld implements IWorld {
	private WordLib l;
    private HangmanImage h;
    private WordImage w;

    public HangmanWorld() {
    	l = new WordLib();
    	
    	Random r = new Random();  //getting a random index to pull a word from the list of words in WordLib
    	int randomNumber = r.nextInt(l.getWords().length);
    	
        h = new HangmanImage(0);
        w = new WordImage(l.getWords()[randomNumber]);
 
    }
    
    public HangmanWorld(WordLib l, HangmanImage h, WordImage w) {
    	this.l = l;
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
    	char ch = Character.toLowerCase( kev.getKey() ); // Convert to lowercase
    	if (kev.getKey() == '.') {  //if the '.' is pressed, a new world is returned
    		return new StartWorld();
    	}
    	if (Character.isLetter(ch)) {
    		if (this.w.wordDone()) {  //if the word is already finished the world will not update
	    		return this;
	    	} else if (this.h.manFilled()) {  //if the hangman is already full the world will not update
	    		return this;
	    	} else {
		        if (this.w.isInWord(ch)) {    //if the key pressed is a letter in the word:
		        	this.w.makeGuess(ch);  //"make the guess" --> updates the wordImage
		        	return new HangmanWorld( this.l, this.h, w.update() ); //returns HangmanWorld without updating the HangmanImage, but updates the WordImage
		        } else {
		        	if (this.w.isInWrong(ch)) {
						return new HangmanWorld( this.l, this.h, w.update() );  //returns a HangmanWorld, doesn't update the HangmanImage
					} else {
						this.w.setWrongLetters(this.w.getWrongLetters() + ch); //adds the wrong guess into the "list" of wrong guesses
						return new HangmanWorld( this.l, h.update(), w.update() );  //returns a HangmanWorld, updating the HangmanImage to account for the wrong guess
					}
		        }
	    	}
    	  } else {
    		  return this;
    	  }
    }
}

