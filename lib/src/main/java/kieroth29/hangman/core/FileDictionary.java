package kieroth29.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kieroth29.hangman.game.GameException;
import kieroth29.hangman.utils.RandomUtils;

public class FileDictionary extends Dictionary{

	private static final String TEAMS_FILE_NAME = "teams.txt";
	
	private List<String> words = new ArrayList<>();
	
	public FileDictionary() {
		load();
	}
	
	private void load() {
		//Scanner sc = new Scanner(TEAMS_FILE_NAME);
		try(Scanner sc = new Scanner(getClass().getResourceAsStream("/" + TEAMS_FILE_NAME))){
			while(sc.hasNextLine()) {
				String word = sc.nextLine().trim();
				
				words.add(word);
			}
			
			if(words.size() == 0) {
				throw new GameException("Lista de palavras não pode ser vazia");
			}
		};
	}
	
	@Override
	public Word nextWord() {
		int index = RandomUtils.randomInt(0, words.size());
		return new Word(words.get(index));
	}

	@Override
	public String getName() {
		return "Arquivo " + TEAMS_FILE_NAME;
	}

}
