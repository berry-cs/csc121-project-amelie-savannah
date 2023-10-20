import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a stick figure
 * is displayed to show game progress in Hangman. It responds to mousePress
 */
public class HangmanImage {
	private int status; //number representing how many wrong guesses
	
	final static int BLEFTMARGIN = 200;
	final static int STOPMARGIN = 150;
	final static int BRIGHTMARGIN = 350;
	
	final static int SLEFTMARGIN = 240;
	final static int S2TOPMARGIN = 5;
	final static int ARIGHTMARGIN = 300;
	
	final static int START = 300;
	final static int HRADIUS = 20;
	final static int SBOTTOMMARGIN = 30;
	final static int S3TOPMARGIN = 80;
	
	final static int LABOTTOMMARGIN = 45;
	final static int LARIGHTMARGIN = 280;
	final static int RARIGHTMARGIN = 320;
	final static int LTOPMARGIN = 105;
	
	final static int LARGETEXT = 20;
	final static int GUESSLIMIT = 6;
	
	public HangmanImage(int status) {
		this.status = status;
	}

	/**
     * Renders a picture of the hangman on the window
     */
    public PApplet draw(PApplet c) {
        c.textSize(LARGETEXT);
       // c.text("Hangman!", 20, 20);
        c.fill(0, 0, 255);
        
        //stand of the hangman
        c.line(BLEFTMARGIN, STOPMARGIN, BRIGHTMARGIN, STOPMARGIN); //base of the stand
        c.line(SLEFTMARGIN, STOPMARGIN, SLEFTMARGIN, S2TOPMARGIN); //height of the stand
        c.line(SLEFTMARGIN, S2TOPMARGIN, ARIGHTMARGIN, S2TOPMARGIN);  //arm of the stand
        
        
        //hangman dude
        if (this.status >= 1) {
        	c.circle(START, HRADIUS, HRADIUS); //head
        } 
        if (this.status >= 2) {
        	c.line(START, SBOTTOMMARGIN, START, S3TOPMARGIN);  //spine
        } 
        if (this.status >= 3) {
        	c.line(START, LABOTTOMMARGIN, LARIGHTMARGIN, SBOTTOMMARGIN); //left arm
        } 
        if (this.status >= 4) {
        	c.line(START, LABOTTOMMARGIN, RARIGHTMARGIN, SBOTTOMMARGIN); //right arm
        } 
        if (this.status >= 5) {
        	c.line(START, S3TOPMARGIN, LARIGHTMARGIN, LTOPMARGIN); //left leg
        } 
        if (this.status >= 6) {
        	c.line(START, S3TOPMARGIN, RARIGHTMARGIN, LTOPMARGIN); //right leg
        }
        
        return c;
    }

    /** returns true if the hangman has been filled i.e. game over */
    public boolean manFilled() {
		return (status >= GUESSLIMIT);
	}
    
    /**
     * Updates the status of *this* if the image isn't already full
     */
    public HangmanImage update() {
    	if (this.manFilled()) { //if its already full, don't update
    		return this;
    	} else {
    		return new HangmanImage(this.status + 1);
    	}
    }
    
    
    /**
     * this does nothing for now
     */
    public HangmanImage mousePressed(MouseEvent mev) {
        return new HangmanImage(0);
    }
    
    /**
     * Produces a string rendering of the position of the
     * drop
    
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
	*/



    
    
}
