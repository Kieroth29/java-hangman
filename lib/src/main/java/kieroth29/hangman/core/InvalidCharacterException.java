package kieroth29.hangman.core;

@SuppressWarnings("serial")
public class InvalidCharacterException extends Exception {

	public InvalidCharacterException(String message) {
		super(message);
	}

}
