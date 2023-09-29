import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanAppTest {

    WordImage wi1 = new WordImage("pearl", "     ", /*"y" ,*/  0);
    WordImage wi2 = new WordImage("pearl", " e   ", /*"y" ,*/ 0);
    WordImage wi3 = new WordImage("pearl", " e   ", /*"yz" ,*/ 1);
    WordImage wi4 = new WordImage("pearl", " e  l", /*"yz" ,*/ 1);
    
    WordImage wi5 = new WordImage("to", "  ", 0);
    WordImage wi6 = new WordImage("to", "t ", 0);
    WordImage wi7 = new WordImage("to", "to", 0);
    
    
    @Test
    void test() {
    	
    	assertEquals(true, wi1.isInWord('p'));
    	assertEquals(true, wi1.isInWord('e'));
    	assertEquals(true, wi1.isInWord('a'));
    	assertEquals(true, wi1.isInWord('r'));
    	assertEquals(true, wi1.isInWord('l'));
    	
    	
    	assertEquals(false, wi1.wordDone());
        assertEquals(wi2, wi1.makeGuess('e'));
        assertEquals(wi3, wi1.makeGuess('z'));
        assertEquals(wi4, wi1.makeGuess('l'));
        assertEquals(false, wi1.wordDone());
        
        assertEquals(false, wi5.wordDone());
        assertEquals(wi6, wi5.makeGuess('t'));
        assertEquals(wi7, wi5.makeGuess('o'));
        assertEquals(true, wi5.wordDone());
    }

}
