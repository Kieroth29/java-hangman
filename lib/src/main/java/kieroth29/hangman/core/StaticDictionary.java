package kieroth29.hangman.core;

import java.util.List;

public class StaticDictionary extends Dictionary {

	private List<String> words = List.of("Minardi", "Force India", "Brawn", "Renault", "Lotus", "Benetton");
	private int currentIndex = 0;

	@Override
	public Word nextWord() {
		currentIndex = (currentIndex + 1) % words.size();
		return new Word(words.get(currentIndex));
	}

	@Override
	public String getName() {
		return "Estático";
	}

}
