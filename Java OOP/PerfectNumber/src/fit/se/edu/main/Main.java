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
			System.out.println("Please enter your number want to check: ");
			num = sc.nextInt();
			if (checkPerfectNum(num)) {
				System.out.println("This is the perfect number!");
			} else {
				System.out.println("This is not a perfect number!");
			}
			sc.close();
			System.exit(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param num check number
	 * @return if the check number is a perfect number then returns true . Returns
	 *         false
	 */
	// Method checkPerfectNum
	// [START checkPerfectNum]
	static boolean checkPerfectNum(int num) {
		int sum = 0;
		// Sum of the positive integer divisors of the num
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}

		// If sum = num, this is perfect number
		// returns true
		if (sum == num) {
			return true;
		}
		return false;
	}
	// [END checkPerfectNum]
}
