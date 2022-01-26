package fit.se.edu.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		boolean checkExits = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Mời bạn nhập số n cần kiểm tra: ");
				n = sc.nextInt();
				
				if (checkParity(n)) {
					System.out.println(n + " là số chẵn!");
				}else {
					System.out.println(n + " là số lẻ!");
				}
				
				// Exit
				checkExits = false;
				sc.close();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Bạn nhập chưa đúng format! Mời bạn nhập lại: ");
			} catch (NumberFormatException e) {
				sc.next();
				System.out.println("Bạn nhập chưa đúng format! Mời bạn nhập lại: ");
			}
		} while (checkExits);
		System.exit(0);
	}

	/**
	 * Method check parity
	 * @param n
	 * @return
	 */
	static boolean checkParity(int n) {
		if (n % 2 == 0) {
			return true;
		}
		return false;
	}
}
