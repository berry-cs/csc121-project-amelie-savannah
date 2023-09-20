import java.util.Objects;

import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where the lines representing
 * the word to guess is displayed, it responds to mousePress 
 */
public class WordImage {
	String word; //word to be guessed
	String guess;
	int status; //number representing how many letters guessed
	int length;  //length of the word to be guessed (to display lines)
	
	public WordImage(String word) {
	    this(word, " ".repeat(word.length()), 0, word.length());
	}

	public WordImage(String word, String guess, int status, int length) {
	    this.guess = guess;
		this.word = word;
		this.status = status;
		this.length = length;
	}
	
	/* replace " " with ch in `guess` in the corresponding positions
	   where ch occurs in `word`. If ch doesn't occur in `word`, then
	   add 1 to status.
	 */
	public WordImage makeGuess(char ch) {
	    return this;
	}
	
	/* if ch occurs in this word */
	public boolean isInWord(char ch) {
	    return true;
	}
	
	

	/**
     * Renders a picture of the letter spaces of the word on the window
     */
    public PApplet draw(PApplet c) {
    	//spaces for the letters of the word
        c.line(20, 200, 40, 200); //first line for letter
        c.line(50, 200, 70, 200); //second line for letter
        c.line(80, 200, 100, 200); //third line for letter
        c.line(110, 200, 130, 200); //fourth line for letter
        c.line(140, 200, 160, 200); //fifth line for letter
        c.textSize(12);
        
        //letters to go above the corresponding lines
        if (this.status == 1) {
        	c.text('p', 27, 195); //P of "pearl"
        } else if (this.status == 2) {
        	c.text('p', 27, 195); //P of "pearl"
        	c.text('e', 57, 195); //E of "pearl"
        } else if (this.status == 3) {
        	c.text('p', 27, 195); //P of "pearl"
        	c.text('e', 57, 195); //E of "pearl"
        	c.text('a', 87, 195); //A of "pearl"
        } else if (this.status == 4) {
        	c.text('p', 27, 195); //P of "pearl"
        	c.text('e', 57, 195); //E of "pearl"
        	c.text('a', 87, 195); //A of "pearl"
        	c.text('r', 117, 195); //R of "pearl"
        } else {
        	c.text('p', 27, 195); //P of "pearl"
        	c.text('e', 57, 195); //E of "pearl"
        	c.text('a', 87, 195); //A of "pearl"
        	c.text('r', 117, 195); //R of "pearl"
        	c.text('l', 147, 195); //L of "pearl"
        }
        return c;
    }

    /**
     * Produces an updated world where the letters pop
     * up on the screen at each second
    */
    public WordImage update() {
       return new WordImage("pearl", this.guess, this.status + 1, 5);  
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public WordImage mousePressed(MouseEvent mev) {
        return new WordImage("pearl", this.guess, this.status, 5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guess, length, status, word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordImage other = (WordImage) obj;
        return Objects.equals(guess, other.guess) && length == other.length && status == other.status
                && Objects.equals(word, other.word);
    }

    @Override
    public String toString() {
        return "WordImage [word=" + word + ", guess=" + guess + ", status=" + status + ", length=" + length + "]";
    }
}