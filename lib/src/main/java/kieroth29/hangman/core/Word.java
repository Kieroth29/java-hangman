package kieroth29.hangman.core;

import java.util.HashSet;
import java.util.Set;

public class Word {

	private static final char SECRET_CHAR = '_';
	
	private String originalWord;
	private Set<Character> foundChars = new HashSet<>();
	private Set<Character> existingChars = new HashSet<>();

	public Word(String originalWord) {
		this.originalWord = originalWord.toUpperCase();
		
		char[] chars = this.originalWord.toCharArray();
		for(char c: chars) {
			existingChars.add(c);
		}
	}
	
	public int size() {
		return originalWord.length();
	}
	
	public Boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		
		if(originalWord.indexOf(c) == -1) {	
			return false;
		}
		
		foundChars.add(c);
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		char[] charArray = originalWord.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			char currentChar = charArray[i];
			
			if(foundChars.contains(currentChar)) {
				sb.append(currentChar);
			}else {
				sb.append(SECRET_CHAR);
			}
			
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public Boolean foundWord() {
		return foundChars.equals(existingChars);
	}

	public String getOriginalWord() {
		return originalWord;
	}

}
