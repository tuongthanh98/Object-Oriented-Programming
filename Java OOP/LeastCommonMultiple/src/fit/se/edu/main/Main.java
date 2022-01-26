package fit.se.edu.main;

import java.util.Scanner;

/**
 * Main class
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Please enter the first number: ");
			a = sc.nextInt();
			System.out.print("Please enter the second number: ");
			b = sc.nextInt();
			System.out.println("The least common multiple of " + a + " and " + b + " is: " + getTheLeastCommonMultiple(a, b));
			System.out.println("Use recursion get the least common multiple of " + a + " and " + b + " is: " + useRecursion(a, b, (a > b) ? a : b));
			System.out.println("Use recursion get the least common multiple using the greatest common divisor of " + a + " and " + b + " is: " + useRecursion(a, b));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();		
		System.exit(0);
	}

	/**
	 * Get the Least Common Multiple
	 * @param a first number
	 * @param b second number 
	 * @return Returns the least common multiple
	 */
	// Method getTheLeastCommonMultiple
	//[START getTheLeastCommonMultiple]
	static int getTheLeastCommonMultiple(int a, int b) {
		int lcm; // last common multiple
		// Use the ternary operator to assign the maximum value between a and b to lcm
		lcm = (a > b) ? a : b;
		while (true) {
			// if lcm % num1 and num2, lcm is last common multiple of a and b
			if (lcm % a == 0 && lcm % b == 0) {
				break;
			}
			++lcm;
		}
		return lcm;
	}
	//[END getTheLeastCommonMultiple]
	
	
	/**
	 * Using Recursion get the least common multiple 
	 * @param a the first number
	 * @param b the second number
	 * @param lcm largest number between 2 numbers
	 * @return Returns the least common multiple
	 */
	// Method useRecursion
	//[START useRecursion]
	static int useRecursion(int a, int b, int lcm) {
		if (lcm % a == 0 && lcm % b == 0) 
			return lcm;
		return useRecursion(a, b, ++lcm);
	}
	//[END useRecursion]
	
	
	/**
	 * Using Recursion get Least Common Multiple by Greatest Common Divisor
	 * @param a the first number
	 * @param b the second number
	 * @return Returns the least common multiple
	 */
	static int useRecursion(int a, int b) {
		return (a * b / getGreatestCommonDivisor(a, b));
	}
	
	/**
	 * Get greatest common divisor. Note: Euclidean algorithm
	 * @param a the first number
	 * @param b the second number
	 * @return Returns the greatest common divisor
	 */
	static int getGreatestCommonDivisor(int a, int b) {
		if (b == 0) 
			return a;
		return getGreatestCommonDivisor(b, a % b);
	}
}
