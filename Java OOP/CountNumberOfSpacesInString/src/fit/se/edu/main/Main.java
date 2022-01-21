package fit.se.edu.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		boolean exits = false;
		
		while (!exits) {
			// showMenu();
			showMenu();			
			choose = sc.nextInt();
			System.out.println("Please input your string to count whitespace: ");
			sc.next();
			String newString = sc.nextLine();
			
			switch (choose) {
			case 1 -> { 
				System.out.println("Using foreach to count white space!");
				int result = usingForeach(newString);
				
				System.out.println("This is result after counting the space in the string: " + result);
			}
			case 2 -> { 
				System.out.println("Using Java Stream API to count whitespace in string!");
				int result = usingStream(newString);
				
				System.out.println("This is result after counting the space in the string: " + result);
			}
			case 3 ->{ 
				System.out.println("Using Regular to count whitespace in string!");
				int result = usingRegexMatcherFind(newString);
				
				System.out.println("This is result after counting the space in the string: " + result);
			}
			case 4 -> { 
				System.out.println("Using replace All non-whitespace charaters to empty to count whitespace in string!");
				int result = usingReplaceAll(newString);
				
				System.out.println("This is result after counting the space in the string: " + result);
			}
			case 5 ->{ 
				System.out.println("Using split to count whitespace in string!");
				int result = usingSplit(newString);
				
				System.out.println("This is result after counting the space in the string: " + result);
			}
			
			case 0 -> {
				exits = true;
			}
			default ->
			throw new IllegalArgumentException("Unexpected value: " + choose);
			}
			
		}
		
//		int result = countSpaceInString("");
//		System.out.println("" + result);
	}

	
	/**
	 * create menu
	 */
	static void showMenu() {
		System.out.println("-----------Menu------------");
        System.out.println("1. Using Foreach to count whitespace in string.");
        System.out.println("2. Using Java Stream API to count whitespace in string.");
        System.out.println("3. Using Regular to count whitespace in string.");
        System.out.println("4. Using replace All non-whitespace charaters to empty to count whitespace in string.");
        System.out.println("5. Using split to count whitespace in string.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}
	
	/**
	 * 1/ using foreach to
	 * count whitespace in string
	 */
	static int usingForeach(String input) {
		int spaceCount = 0;
		
		// Check input is null and empty
		// Print spaceCount = 0
		if (input == null || input.isEmpty()) {
			return spaceCount;
		}
		
		for (char c : input.toCharArray()) {
			if (c == ' ') {
				spaceCount++;
			}
		}		
		return spaceCount;
	}
	
	/**
	 * 2/ using Java Stream API
	 * convert values char from String to IntStream instance
	 */
	static int usingStream(String input) {
		long spaceCount = input.chars().filter(c -> c == (int) ' ').count();
		return (int)spaceCount;
	}

	/**
	 * 3/ using Matcher.find() of Regex
	 */
	static int usingRegexMatcherFind(String input) {
		// Pattern
		Pattern pattern = Pattern.compile(" ");
		// Match pattern
		Matcher matcher = pattern.matcher(input);
		int spaceCount = 0;
		// find the next expression that matches the pattern 
		// from the given starting number.
		while (matcher.find()) {
			spaceCount++;
		}
		
		return spaceCount;
	}
	
	/**
	 * 4/ using String.replaceAll()
	 * change all char is not the whitespace to emtpy.
	 * the String is only whitespace characters
	 */
	static int usingReplaceAll(String input) {
		return input.replace("[^ ]", "").length();
	}
	
	/**
	 * 5/ using split
	 * Note: use split that doesn't count whitespace characters 
	 * after non-whitespace characters
	 */
	static int usingSplit(String input) {
		return input.split(" ").length -1;
	}
	
	/**
	 * using Apache commons lang 3
	 */
//	static int usingApacheCmLg3(String input) {
//		return StringUtils.countMatches(input, " ");
//	}
	
	/**
	 * with Spring Framework
	 */
//	static int countWithSpringFramework() {
//		return StringUtils.countOccurrencesOf(INPUT_STRING, " ");
//	}
}
