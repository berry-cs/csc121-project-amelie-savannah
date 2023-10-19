import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a stick figure
 * is displayed to show game progress in Hangman. It responds to mousePress
 */
public class HangmanImage {
	private int status; //number representing how many wrong guesses
	
	public HangmanImage(int status) {
		this.status = status;
	}

	/**
     * Renders a picture of the hangman on the window
     */
    public PApplet draw(PApplet c) {
        c.textSize(20);
       // c.text("Hangman!", 20, 20);
       c.fill(0, 0, 255);
        
        //stand of the hangman
        c.line(200, 150, 350, 150); //base of the stand
        c.line(240, 150, 240, 5); //height of the stand
        c.line(240, 5, 300, 5);  //arm of the stand
        
        
        //hangman dude
        if (this.status >= 1) {
        	c.circle(300, 20, 20); //head
        } 
        if (this.status >= 2) {
        	c.line(300, 30, 300, 80);  //spine
        } 
        if (this.status >= 3) {
        	c.line(300, 45, 280, 30); //left arm
        } 
        if (this.status >= 4) {
        	c.line(300, 45, 320, 30); //right arm
        } 
        if (this.status >= 5) {
        	c.line(300, 80, 280, 105); //left leg
        } 
        if (this.status >= 6) {
        	c.line(300, 80, 320, 105); //right leg
        }
        
        return c;
    }

    /** returns true if the hangman has been filled i.e. game over */
    public boolean manFilled() {
		return (status >= 6);
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
