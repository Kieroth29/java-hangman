package kieroth29.hangman.game;

import java.util.HashSet;
import java.util.Set;

import kieroth29.hangman.core.Config;
import kieroth29.hangman.core.Dictionary;
import kieroth29.hangman.core.InvalidCharacterException;
import kieroth29.hangman.core.Word;
import kieroth29.hangman.ui.UI;

public class Game {

	public void start(String[] args) {
		Dictionary d = Dictionary.getInstance();
		System.out.println("Dicionário utilizado: " + d.getName());
		
		Word w = d.nextWord();
		UI.print("A palavra tem " + w.size() + " letras.");
		
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		if(args.length > 0) {
			Config.setMaxErrors(args[0]);
		}
		
		int MAX_ERRORS = Integer.parseInt(Config.get("maxErrors"));
		
		UI.print("Você poderá errar até " + MAX_ERRORS + " vezes.");
		
		while(!w.foundWord() && errorCount < MAX_ERRORS) {	
			UI.print(w);
			
			try {
				char play = UI.readChar("Insira uma letra: ");
				w.hasChar(play);
				
				if(usedChars.contains(play)) {
					throw new InvalidCharacterException("Letra já foi utilizada");
				}
				
				usedChars.add(play);
				
				if(w.hasChar(play)) {
					UI.print("Você acertou uma letra!");
				}else {
					errorCount++;
					UI.print("Você errou! Erros restantes: " + (MAX_ERRORS - errorCount));
				}
				
			} catch(InvalidCharacterException e){
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}
		
		if(errorCount < MAX_ERRORS) {
			UI.print(w.getOriginalWord());
			UI.print("Parabéns, você venceu!");			
		}else{
			UI.print("Você perdeu. A palavra era " + w.getOriginalWord());
		}
		UI.print("Fim do jogo");
	}

}
