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
	String wrongLetters; //string of the wrong letters guessed
	
	public WordImage(String word) {
	    this(word, " ".repeat(word.length()), "");
	}

	public WordImage(String word, String guess, String wrongLetters) {
	    this.guess = guess;
		this.word = word;
		this.wrongLetters = wrongLetters;
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
			if (this.isInWrong(ch)) {  //if the guess has already been guessed, dont add to the wrongLetters
				return this;
			} else {
				this.wrongLetters += ch;
				return this;

			}
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
	
	/* if ch occurs in the guess, helper function for wordDone() */
	public boolean isInGuess(char ch) {
	    for (int i = 0 ; i < this.word.length() ; i++) {
	    	if (this.guess.charAt(i) == ch) {
	    		return true;
	    	}
	    }
	    return false;
	}
	
	/* if ch occurs in the wrongLetters, helper function for makeGuess() */
	public boolean isInWrong(char ch) {
	    for (int i = 0 ; i < this.wrongLetters.length() ; i++) {
	    	if (this.wrongLetters.charAt(i) == ch) {
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
        
        //letters that are not in the word get rendered
        for (int k = 0 ; k < this.wrongLetters.length() ; k++) {
        	c.text(this.wrongLetters.charAt(k), (40 + (20 * k)), 100);
        }
        
        //displays a "You Win!" if the word has been correctly guessed
        if (this.wordDone()) {
        	c.textSize(50);
        	c.text("You Win!", 100 , 300);
        }
        
        //displays a "Game Over!" and what the correct answer was if the limit of wrong guesses has been reached
        if (this.wrongLetters.length() >= 6) {
        	c.textSize(50);
        	c.text("Game Over!", 80 , 300);
        	c.textSize(20);
        	c.text(("The correct answer was: " + this.word), 75, 350);
        }
        
        c.textSize(12); //resetting the text size to 12 so the start or final images aren't messed up
        return c;
    }

    /**
     * This doesn't do anything
    */
    public WordImage update() {
       return new WordImage(this.word, this.guess, this.wrongLetters);  
    }
    
    
    /**
     * This does nothing right now
     */
    public WordImage mousePressed(MouseEvent mev) {
        return new WordImage(this.word, this.guess, this.wrongLetters);
    }

	@Override
	public int hashCode() {
		return Objects.hash(guess, word, wrongLetters);
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
		return Objects.equals(guess, other.guess) && Objects.equals(word, other.word)
				&& Objects.equals(wrongLetters, other.wrongLetters);
	}

	@Override
	public String toString() {
		return "WordImage [word=" + word + ", guess=" + guess + ", wrongLetters=" + wrongLetters + "]";
	}  
}