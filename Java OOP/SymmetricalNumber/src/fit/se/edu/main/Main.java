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
		int num = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please enter your number want to check: ");
			num = sc.nextInt();
			if (checkNumberSymmetry(num)) {
				System.out.println("This is a symmetric number!");
			} else {
				System.out.println("This is not a symmetric number!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
		System.exit(0);
	}
	
	/**
	 * Method to check if a number is symmetric
	 * @param num
	 * @return Returns true if this a symmetry number
	 */
	// Method checkNumberSymmetry
	//[START checkNumberSymmetry]
	static boolean checkNumberSymmetry(int num) {
		int digit, original, reversed = 0;
		original = num;
		
		// reverse number
		while (original != 0) {
			digit = original % 10;
			reversed = reversed * 10 + digit;
			original /= 10;
		}
		if (reversed == num) {
			return true;
		}
		
		return false;
	}
	//[END checkNumberSymmetry]

}
