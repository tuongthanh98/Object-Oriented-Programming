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
		int t;
		float p, r, interest;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter the amount deposited in the bank : ");
			p = sc.nextFloat();
			System.out.print("Enter the annual interest rate (%) : ");
			r = sc.nextFloat();
			System.out.print("Enter the time of submission (in years): ");
			t = sc.nextInt();
			// calculate interset rate
			interest = calInterest(p, r, t);
			System.out.print("The amount of profit is: " + interest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.exit(0);
		}
	}
	
	/**
	 * calculate interest rate 
	 * @param p
	 * @param r
	 * @param t
	 * @return Profit amount
	 */
	static float calInterest(float p, float r, int t) {
		return (float) ((p * r * t) / (100));
	}
}
