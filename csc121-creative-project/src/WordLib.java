
/** word library that randomly selects a word, and holds the word data including
 * correct letters guessed
 * number of blank spaces(length of the word) */
public class WordLib {
	int length;
	String corLetters; //this will be a list later
	String word;
	
	public WordLib(int length, String corLetters, String word) {
		this.length = 5;
		this.corLetters = corLetters;
		this.word = "pearl";
	}
}
