package fit.se.edu.main;

import java.util.Scanner;

/**
 * Main class
 * 
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter character to check: ");
		
		try {
			char c = sc.next().charAt(0);
			System.out.println(checkVowels(c));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.exit(0);
		}
	}

	/**
	 * Check volwel method.  
	 * 	In the alphabet, A, E, I, O, U (both lowercase and uppercase) are called vowels, 
	 * 	the rest of the letters are called consonants.
	 * @param character
	 * @return  
	 */
	static String checkVowels(char character) {
		return switch (character) {
		case 'a', 'e', 'i', 'o', 'u', 
			'A', 'E', 'I', 'O', 'U'-> {
			yield "The character " + character +  " is a vowel!";
		}
		default -> {
			yield "The character " + character +  " is not a vowel!";
		}
		};
	}
}
