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
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		boolean exits = false;

		do {
			// show menu
			showMenu();
			try {
				choose = sc.nextInt();

				switch (choose) {
				case 1 -> {
					System.out.println("Enter your number you want to check: ");
					int num = sc.nextInt();
					if (checkArmstrong(num)) {
						System.out.println("This is Amrstrong's number!");
					} else {
						System.out.println("This is not Amrstrong's number!");
					}
				}
				case 2 -> {
					int count = 0;
					System.out.print("Enter the starting number: ");
					int start = sc.nextInt();
					System.out.print("Enter the ending number: ");
					int end = sc.nextInt();

					for (int i = start; i < end; i++) {
						if (checkArmstrong(i)) {
							// If count = 0 print the statement less than 1 time only - Nếu count = 0 in ra câu lệnh dưới 1 lần duy nhất
							if (count == 0) {
								System.out.print("Armstrong numbers between " + start + " and " + end + ": ");
								count++;
							}
							System.out.print(i + " ");
						}  
						if (i == (end -1)) {
							System.out.print("\n");
						}
					}
					
					// If count = 0 there is no Armstrong number - Nếu count = 0 không có số Armstrong
					if (count == 0) {
						System.out.println("There is no Armstrong number between " + start + " and " + end + "!");
					}
				}
				default -> {
					exits = true;
				}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!exits);

		sc.close();
		System.exit(0);
	}

	
	/**
	 * Create menu
	 */
	// Create menu
	//[START showMenu]
	static void showMenu() {
		System.out.println("-----------Menu------------");
		System.out.println("1. Check Armstrong number.");
		System.out.println("2. Print Armstrong in the range.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
	//[END showMenu]

	
	/**
	 * Check armstrong method
	 * 
	 * @param num
	 * @return Returns true if this is armstrong
	 */
	// Phương thức kiểm tra một số có phải là số Armstrong
	// [START checkArmstrong]
	static boolean checkArmstrong(int num) {
		int rem, temp, sum, numberDigit;
		temp = num;
		sum = 0;
		numberDigit = countDigit(num); // number of digits

		do {
			rem = temp % 10;
			temp /= 10; // temp = temp / 10
			sum += Math.pow(rem, numberDigit); // sum = sum + rem * rem * rem;
		} while (temp != 0);

		// check Armstrong
		// Num < 0, it is not an Armstrong number
		if (sum == num && num < 0) {
			return true;
		}
		return false;
	}
	// [END checkArmstrong]

	
	/**
	 * Count the number of digits in the number
	 * 
	 * @return count
	 */
	// Phương thức đếm số lượng chữ số trong số
	// [START countDigit]
	static int countDigit(int num) {
		int count = 0;
		while (num > 0) {
			num /= 10;
			++count;
		}
		if (count == 0) {
			return 1;
		}
		return count;
	}
	// [END countDigit]
}
