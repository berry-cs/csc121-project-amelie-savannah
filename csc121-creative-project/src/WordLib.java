
/** word library that randomly selects a word, and holds the word data including
 * correct letters guessed
 * number of blank spaces(length of the word) */
public class WordLib {
	private String[] words; //preset list of words to randomly select from
	
	public WordLib() {
		this.words = new String[]{"pearl", "government", "mess", "winner", "person", "superior", "deck", "engineer", "abundant", "irony", "utter", "archaic",
				"dead", "premium", "permission", "attitude", "see", "baseball", "depart", "increase", "grimace", "manual", "teach", "match", "long", "delicate",
				"vessel", "payment", "sink", "plead", "convince", "census", "conductor", "registration", "proper", "table", "pitch", "exchange", "landowner", "coup", "grace",
				"growth", "earsplitting", "cabbageworm"};
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
	
	
}