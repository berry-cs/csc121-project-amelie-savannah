import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanAppTest {

    WordImage wi1 = new WordImage("pearl", "     ", "");
    WordImage wi2 = new WordImage("pearl", " e   ", "");
    WordImage wi3 = new WordImage("pearl", " e   ", "z");
    WordImage wi4 = new WordImage("pearl", " e  l", "z");
    
    WordImage wi5 = new WordImage("to", "  ", "");
    WordImage wi6 = new WordImage("to", "t ", "");
    WordImage wi7 = new WordImage("to", "to", "");
    
    @Test
    void testWordImage() {
    	
    	assertEquals(true, wi1.isInWord('p'));
    	assertEquals(true, wi1.isInWord('e'));
    	assertEquals(true, wi1.isInWord('a'));
    	assertEquals(true, wi1.isInWord('r'));
    	assertEquals(true, wi1.isInWord('l'));
    	
    	
    	assertEquals(false, wi1.wordDone());
        assertEquals(wi2, wi1.makeGuess('e')); //" e   "
        assertEquals(wi3, wi1.makeGuess('z')); //" e   "
        assertEquals(wi4, wi1.makeGuess('l')); //" e  l"
        assertEquals(false, wi1.wordDone()); //not done ^
        assertEquals(true, wi1.isInGuess(' '));   //there are spaces still in the word --> word is not fully guessed
        
        assertEquals(false, wi5.wordDone());
        assertEquals(wi6, wi5.makeGuess('t')); //"t "
        assertEquals(wi7, wi5.makeGuess('o')); //"to"
        assertEquals(true, wi5.wordDone());  //done ^
        assertEquals(false, wi5.isInGuess(' '));  //there are no spaces --> word is fully guessed
    }
    
    
    HangmanImage hm1 = new HangmanImage(5);  //sets the status of the HangmanImage to 5 (has every limb except for a leg)
    HangmanImage hm2 = new HangmanImage(6); //sets the status of the HangmanImage to 6 (has every limb)
    
    
    @Test
    void testHangmanImage() {
    	assertEquals(false, hm1.manFilled()); //hangman dude is not filled (one limb remaining to add)
    	assertEquals(true, hm2.manFilled()); //hangman dude is filled (no limbs left to add)
    }

}
