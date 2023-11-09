import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/** word library that randomly selects a word, and holds the word data including
 * correct letters guessed
 * number of blank spaces(length of the word) */
public class WordLib {
	private String[] words; // preset list of words to randomly select from
	private Scanner sc; // Scanner to read the file
	private File f; // File variable
	private int num; // number of words in file
	
	
	public WordLib() {
		f = new File("words.txt"); // new file for words.txt
		num = 46; // set at 46 (number of words in f)
		words = new String[num]; // num controls size of words[]
		readWords(f); // calls readWords 
	}
	
	/* Reads in words from File fi separated by new lines*/
	private void readWords(File fi) {
		try { 
			sc = new Scanner(fi);
			
			for (int i = 0; i < num && sc.hasNext(); i++) {
				words[i] = sc.next();
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
	
	
}