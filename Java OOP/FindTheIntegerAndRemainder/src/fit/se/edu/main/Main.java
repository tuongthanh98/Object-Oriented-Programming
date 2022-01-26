package fit.se.edu.main;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Main class
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		double n;
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter your number:");
			n = sc.nextDouble();
			HashMap<String, Integer> hashMap = cal(n);
			if (!hashMap.isEmpty()) {
				System.out.println("The integer part is " + hashMap.get("intergers"));
				System.out.println("The remainder is " + hashMap.get("remainders"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * @param n
	 * @return key-value pairs of integers and remainders
	 */
	static HashMap<String, Integer> cal(double n) {
		int intergers, remainders;
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		// calculate
		intergers = (int) (n);
		remainders = ((int) ((n - (int) n) * 100) % 10) == 0 ? (int) ((n - (int) n) * 10) 
															 : (int) ((n - (int) n) * 100) ;
		
		// put elements to hashMap
		hashMap.put("intergers", intergers);
		hashMap.put("remainders", remainders);
		
		return hashMap;
	}

}
