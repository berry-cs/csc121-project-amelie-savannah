import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a stick figure
 * is displayed to show game progress in Hangman. It responds to mousePress
 */
public class HangmanImage {
	int status; //number representing how many wrong guesses
	
	public HangmanImage(int status) {
		this.status = status;
	}

	/**
     * Renders a picture of the hangman on the window
     */
    public PApplet draw(PApplet c) {
        c.background(255);
        c.textSize(20);
        c.text("Hangman!", 20, 20);
        c.fill(0, 0, 255);
        
        //stand of the hangman
        c.line(200, 150, 350, 150); //base of the stand
        c.line(240, 150, 240, 5); //height of the stand
        c.line(240, 5, 300, 5);  //arm of the stand
        
        
        //hangman dude
        if (this.status == 1) {
        	c.circle(300, 20, 20); //head
        } else if (this.status == 2) {
        	c.circle(300, 20, 20); //head
        	c.line(300, 30, 300, 80);  //spine
        } else if (this.status == 3) {
        	c.circle(300, 20, 20); //head
        	c.line(300, 30, 300, 80);  //spine
        	c.line(300, 45, 280, 30); //left arm
        } else if (this.status == 4) {
        	c.circle(300, 20, 20); //head
        	c.line(300, 30, 300, 80);  //spine
        	c.line(300, 45, 280, 30); //left arm
        	c.line(300, 45, 320, 30); //right arm
        } else if (this.status == 5) {
        	c.circle(300, 20, 20); //head
        	c.line(300, 30, 300, 80);  //spine
        	c.line(300, 45, 280, 30); //left arm
        	c.line(300, 45, 320, 30); //right arm
        	c.line(300, 80, 280, 105); //left leg
        } else {
        	c.circle(300, 20, 20); //head
        	c.line(300, 30, 300, 80);  //spine
        	c.line(300, 45, 280, 30); //left arm
        	c.line(300, 45, 320, 30); //right arm
        	c.line(300, 80, 280, 105); //left leg
        	c.line(300, 80, 320, 105); //right leg
        }
        c.delay(500);
        
        return c;
    }

    /**
     * Produces an updated world where the hangman dude
     * appears at each update
     */
    public HangmanImage update() {
        return new HangmanImage(this.status + 1);
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
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
