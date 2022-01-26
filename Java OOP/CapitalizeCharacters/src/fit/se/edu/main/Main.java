package fit.se.edu.main;

import java.util.Scanner;

/**
 * Main class
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your string: ");
		s = sc.nextLine();
		System.out.println("Sring after change: " + capFirstLetter(s));
		System.out.println("String after change the first characters each letter in the string: " + capFirstCharOfEachInTheString(s));
		sc.close();
		System.exit(0);
	}
	
	/**
	 * capitalize first letter
	 * @param s
	 * @return string is Upper case first letter
	 */
	static String capFirstLetter(String s) {
		String firstLetter = s.substring(0, 1);
		String remainingLetters = s.substring(1);
		
		return firstLetter.toUpperCase() + remainingLetters;
	}

	/**
	 * 
	 * @param s
	 * @return The string capitalizes the first characters of each letter in the string
	 */
	static String capFirstCharOfEachInTheString (String s) {
		// declare array character, use to method toCharArray()
		// change s to array character
		char[] charArray = s.toCharArray();
		boolean foundSpace = true;
			
		// use for to traverse the elements in char Array
		for (int i = 0; i < charArray.length; i++) {
			// if the element in the array is a letter
			if (Character.isLetter(charArray[i])) {
				// check for a space before a letter
				if (foundSpace) {
					// change letter to uppercase using toUpperCase() method
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			}else {
				foundSpace = true;
			}
		}
		
		return String.valueOf(charArray);
	}
}
