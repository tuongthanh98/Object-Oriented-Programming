package fit.se.edu.main;

import java.util.HashMap;
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
		double p, r, n;
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter the principal amount: ");
			p = sc.nextDouble();
			System.out.println("Enter the annual interest rate: ");
			r = sc.nextDouble();
			System.out.println("Enter the money time is used or loan: ");
			t = sc.nextInt();
			System.out.println("Enter interest rate: ");
			n = sc.nextDouble();

			// calculate compound interest
			HashMap<String, Double> hashMap = calCompoundInterest(p, r, t, n);

			System.out.println("Compound interest after " + t + " years is: " + hashMap.get("interest"));
			System.out.println("The amount obtained after " + t + " year is: " + hashMap.get("amount"));
		
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		} finally {
			sc.close();
			System.exit(0);
		}
	}

	/**
	 * Calculate Compound Interest method
	 * 
	 * @param p is principal amount.
	 * @param r is the annual interest rate.
	 * @param t is the money time is used or loan.
	 * @param n is the number of times interest is compounded per unit t, 
	 * 			if interest is compounded monthly and t is annual, then n is 12. 
	 * 			If interest is compounded quarterly and t is annually, then n is 4
	 */
	static HashMap<String, Double> calCompoundInterest(double p, double r, int t, double n) {

		HashMap<String, Double> hashMap = new HashMap<String, Double>();
		if (n <= 0) {
			hashMap.put("amount", p);
			hashMap.put("interest", 0.0);
		} else {
			double amount = p * Math.pow(1 + (r / n), n * t);
			// calculate interest
			double interest = amount - p;

			hashMap.put("amount", amount);
			hashMap.put("interest", interest);
		}
		
		return hashMap;
	}
}
