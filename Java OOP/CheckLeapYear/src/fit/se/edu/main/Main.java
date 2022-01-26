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
		int year;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter year you want to check: ");

		try {
			year = sc.nextInt();

			// check leap year
			if (check(year)) {
				System.out.println("This is leap year!");
			} else {
				System.out.println("This is not leap year!");
			}
			
			// another way
			// use operator ?:
			System.out.println(check(year) ? "This is leap year!" : "This is not leap year!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.exit(0);
		}
	}

	/**
	 *  A leap year is a year that is divisible by 400 .
	 *  A leap year is a year that is divisible by 4 but not by 100
	 * 
	 * @param year
	 * @return True. This is leap year
	 */
	static boolean check(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
}
