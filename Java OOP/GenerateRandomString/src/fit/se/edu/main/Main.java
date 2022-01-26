package fit.se.edu.main;

import java.nio.charset.Charset;
import java.util.Random;

/**
 * Main class
 * 
 * @author ISV-04
 *
 */
public class Main {

	public static void main(String[] args) {

		generateRandomString();
		generateRandomAlphabetString();
		usingRandomIntToGenerateRdAlphabetStr();
		generateRandomAlphanumericString();

		System.exit(0);
	}

	
	/**
	 * Generate a string with a specified number of characters
	 * However the characters in the String can be anything such as 
	 * alphabet letters, numbers, special characters, etc.
	 */
	static void generateRandomString() {
		int len = 10; // Độ dài của String random
		byte[] array = new byte[len];
		new Random().nextBytes(array);
		String generateString = new String(array, Charset.forName("UTF-8"));
		System.out.println("Random string: " + generateString);
	}
	
	/**
	 * Generate a string containing only alphabetic letters.
	 */
	static void generateRandomAlphabetString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int len = 10;
		Random random = new Random();
		StringBuffer buffer = new StringBuffer(len);
		
		for (int i = 0; i < len; i++) {
			int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit +1));
			buffer.append((char)randomLimitedInt);
		}
		String generatedString = buffer.toString();
		
		System.out.println("Random Alphabet String: " + generatedString);
	}
	
	/**
	 * Generate a string containing only alphabetic letters by Random.ints
	 */
	static void usingRandomIntToGenerateRdAlphabetStr() {
		int len = 10;
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();		
		String generatedString = random.ints(leftLimit, rightLimit +1)
									   .limit(len)
									   .collect(StringBuilder::new, 
												StringBuilder::appendCodePoint, 
												StringBuilder::append)
									   .toString();
		System.out.println("using Random Int to random Alphabet String: " + generatedString);
	}
	
	/**
	 * Generate a string consisting of letters and numbers
	 */
	static void generateRandomAlphanumericString() {
        int len = 10;
		int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
					                   .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
					                   .limit(len)
					                   .collect(StringBuilder::new, 
					                		    StringBuilder::appendCodePoint, 
					                		    StringBuilder::append)
					                   .toString();
        System.out.println("Random Alphanumeric String: " + generatedString);
	}
	
	/**
	 * using apache.commons.lang3 to generate a string consisting of letters and numbers
	 */
//	static void testFunction() {
//		String generatedString = RandomStringUtils.randomAlphanumeric(10);
//        System.out.println("Random String: " + generatedString);
//	}
	
}
