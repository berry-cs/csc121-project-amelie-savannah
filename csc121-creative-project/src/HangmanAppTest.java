import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanAppTest {

    WordImage wi1 = new WordImage("pearl", "-----", /*"y" ,*/  0, 5);
    WordImage wi2 = new WordImage("pearl", "-e---", /*"y" ,*/ 0, 5);
    WordImage wi3 = new WordImage("pearl", "-----", /*"yz" ,*/ 1, 5);
    
    @Test
    void test() {
        assertEquals(wi2, wi1.makeGuess('e'));
        assertEquals(wi3, wi1.makeGuess('z'));
    }

}
