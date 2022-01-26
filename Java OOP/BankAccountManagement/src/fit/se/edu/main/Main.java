package fit.se.edu.main;

import java.util.Scanner;

import fit.se.edu.entity.Account;

/**
 * Main class
 * 
 * @author Admin
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);

	/**
	 * method input Account
	 * 
	 * @param account
	 */
	static void inputAccount(Account account) {
		System.out.println("Please input your account number blank: ");
		account.setAccountNO(sc.nextLong());
		sc.nextLine();
		System.out.println("Please input your account name: ");
		account.setAccountName(sc.nextLine());
		account.setAmount(50000);
	}

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Account a[] = null;
		int choose, quantily = 0;

		long depositAccountNO, d, receiveAccountNO, f;
		boolean flag = true;
		do {
			// Show menu
			showMenu();
			choose = sc.nextInt();
			switch (choose) {
			case 1 -> {
				System.out.println("Please enter the number of customers you want to import: ");
				quantily = sc.nextInt();
				a = new Account[quantily];
				for (int i = 0; i < quantily; i++) {
					a[i] = new Account();
					inputAccount(a[i]);
				}
			}
			case 2 -> {
				System.out.printf("%-15s %-25s %-20s\n", "Account NO", "Account Name", "The amount in the account");
				for (int i = 0; i < quantily; i++) {
					a[i].printResult();
				}
			}
			case 3 -> {
				System.out.println("Please enter the customer account number to send money: ");
				depositAccountNO = sc.nextLong();
				for (int i = 0; i < quantily; i++) {
					d = a[i].getAccountNO();
					if (depositAccountNO == d) {
						System.out.println("You choose an account: " + d);
						a[i].recharge();
					} else {
						System.out.println("");
					}
				}
			}
			case 4 -> {
				System.out.println("Please enter the customer account number to withdraw money: ");
				depositAccountNO = sc.nextLong();
				for (int i = 0; i < quantily; i++) {
					d = a[i].getAccountNO();
					if (depositAccountNO == d) {
						System.out.println("You choose the account:");
						a[i].withdrawal();
					}
				}
			}
			case 5 -> {
				System.out.println("Please enter the customer account number to be due: ");
				depositAccountNO = sc.nextLong();
				for (int i = 0; i < quantily; i++) {
					d = a[i].getAccountNO();
					if (depositAccountNO == d) {
						System.out.println("You choose an account: " + d);
						a[i].Expire();
					} else {
						System.out.println("");
					}
				}
			}
			case 6 -> {
				double tranfer, receive, moneyTransfer;
				System.out.print("Please enter the customer's account number to transfer money: ");
				depositAccountNO = sc.nextLong();
				System.out.print("Please enter the customer's account number to receive money: ");
				receiveAccountNO = sc.nextLong();

				// loop 
				for (int i = 0; i < quantily; i++) {
					d = a[i].getAccountNO();
					if (depositAccountNO == d) {
						tranfer = a[i].getAmount();	// Get amount
						
						for (int j = 0; j < quantily; j++) {
							f = a[j].getAccountNO();
							if (receiveAccountNO == f) {
								receive = a[j].getAmount();
								System.out.println("Enter the amount to be transferred: ");
								moneyTransfer = sc.nextDouble();
								
								if (moneyTransfer <= tranfer) {
									tranfer = tranfer - moneyTransfer;
									receive = receive + moneyTransfer;
									a[i].setAmount(tranfer);
									a[j].setAmount(receive);
									System.out.println("Account No " + d + " just transfer: $" + moneyTransfer);
									System.out.println("Account No " + f + " just receive: $" + moneyTransfer);
								} else {
									System.out.println("Invalid amount entered!");
								}
							} else {
								System.out.println("");
							}
						}
					} else {
						System.out.println("");
					}
				}
			}

			default -> {flag = false;}
			}
		} while (flag);
		System.exit(0);
	}

	/**
	 * Create menu
	 */
	static void showMenu() {
		System.out.println("-----------Menu------------");
		System.out.println("1. Enter customer information.");
		System.out.println("2. Export the list of information of the customers.");
		System.out.println("3. Deposit to account.");
		System.out.println("4. Withdrawal.");
		System.out.println("5. Expire.");
		System.out.println("6. Transfer money to another account.");
		System.out.println("Enter another number to exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
}
