import java.util.Objects;

import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where the lines representing
 * the word to guess is displayed, it responds to mousePress 
 */
public class WordImage {
	String word; //word to be guessed
	String guess;  //string that user guesses
	int status; //number representing how wrong letters guessed
	
	public WordImage(String word) {
	    this(word, " ".repeat(word.length()), 0);
	}

	public WordImage(String word, String guess, int status) {
	    this.guess = guess;
		this.word = word;
		this.status = status;
	}
	
	/* replace " " with ch in `guess` in the corresponding positions
	   where ch occurs in `word`. If ch doesn't occur in `word`, then
	   add 1 to status.
	 */
	public WordImage makeGuess(char ch) {
		if (this.isInWord(ch)) {
			for (int i = 0 ; i < this.word.length() ; i++) {
				if (this.word.charAt(i) == ch) {
					this.guess = this.guess.substring(0,i) + ch + this.guess.substring(i+1, this.word.length());
		    	}
			}
			return this;
		} else {
			status++;
			return this;
		}
	}
	
	/* if ch occurs in this word */
	public boolean isInWord(char ch) {
	    for (int i = 0 ; i < this.word.length() ; i++) {
	    	if (this.word.charAt(i) == ch) {
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/* if ch occurs in the guess */
	public boolean isInGuess(char ch) {
	    for (int i = 0 ; i < this.word.length() ; i++) {
	    	if (this.guess.charAt(i) == ch) {
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/** is the word completed? */
	public boolean wordDone() {
		return !(this.isInGuess(' '));
	}

	/**
     * Renders a picture of the letter spaces of the word on the window
     */
    public PApplet draw(PApplet c) {
    	
    	//spaces for the letters of the word
    	for (int i = 0 ; i < this.word.length(); i++) {
    		c.line(20+(30 * i), 200, 40+(30 * i), 200);
    	}
    	
    	c.textSize(12);
    	
        //letters to go above the corresponding lines
        for (int j = 0 ; j < this.word.length(); j++) {
        	c.text(this.guess.charAt(j), 27+(30* j), 195);
        }
        return c;
    }

    /**
     * Produces an updated world where the letters pop
     * up on the screen at each second
    */
    public WordImage update() {
       return new WordImage("pearl", this.guess, this.status + 1);  
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public WordImage mousePressed(MouseEvent mev) {
        return new WordImage("pearl", this.guess, this.status);
    }

	@Override
	public int hashCode() {
		return Objects.hash(guess, status, word);
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
		return Objects.equals(guess, other.guess) && status == other.status && Objects.equals(word, other.word);
	}

	@Override
	public String toString() {
		return "WordImage [word=" + word + ", guess=" + guess + ", status=" + status + "]";
	}

    
}