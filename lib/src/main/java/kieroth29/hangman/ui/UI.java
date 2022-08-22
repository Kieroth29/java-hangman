package kieroth29.hangman.ui;

import java.util.Scanner;

import kieroth29.hangman.core.InvalidCharacterException;

public class UI {

	public static void print(Object o){
		System.out.println(o);
	}

	public static void printNewLine(){
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidCharacterException{
		System.out.println(text + " ");
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		if(line.trim().isEmpty()){
			throw new InvalidCharacterException("Nenhuma letra foi digitada");
		}
		
		if(line.length() > 1) {
			throw new InvalidCharacterException("Somente uma letra deve ser digitada");
		}
		
		char c = line.charAt(0);
		
		if (!Character.isLetter(c)) {
			throw new InvalidCharacterException("Somente letras devem ser utilizadas");
		}
		
		return c;		
	}
}
