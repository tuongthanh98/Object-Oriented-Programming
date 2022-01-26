package fit.se.edu.entity;

import java.text.NumberFormat;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Account class
 * 
 * @author Admin
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private long accountNO;
	private String accountName;
	private double amount;

	Scanner sc = new Scanner(System.in);

	/**
	 * declare method recharge
	 */
	public double recharge() {
		double recharge;
		System.out.println("Please enter the amount you need to deposit: ");
		recharge = sc.nextDouble();
		
		/* Check recharge 
		 * If the deposit amount is greater than 0, it is valid
		 * */
		if (recharge >= 0) {
			amount = amount + recharge;
			NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
			String str = currencyEN.format(recharge);
			System.out.println("You just deposited " + str + " into your account!");
		} else { // Otherwise, if the deposit amount is less than 0, it is not valid
			System.out.println("Invalid deposit amount!");
		}
		
		return recharge;
	}

	/**
	 * Declare method withdrawal
	 * */
	public void withdrawal() {
		double fee = 5;
		double withdrawal;
		System.out.println("Pleasse enter the amount you need to withdraw: ");
		withdrawal = sc.nextDouble();
		/*
		 * If the withdrawal amount is less than or 
		 * Equal to the amount in the account +
		 * Fee, it is valid
		 */
		if (withdrawal <= (amount - fee)) {
			amount = amount - fee - withdrawal;
			NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
			String str1 = currencyEN.format(withdrawal);
			System.out.println("You just withdrew" + str1 + " from the account. Fee is $5.");
		} else { // Otherwise,  if the withdrawal amount is larger than the amount in the account, it is not valid
			System.out.println("Invalid withdrawal amount!");
		}
	}
	
	/**
	 * Declare method Expire
	 */
	public double Expire() {
		double interestRate = 0.035;
		amount = amount + amount * interestRate;
		NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
		String str1 = currencyEN.format(amount);
		System.out.println("You just got " + str1 + " from 1 month maturity!");
		return amount;
	}
	
	/**
	 * print result 
	 */
	public void printResult() {
		NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
		String str1 = currencyEN.format(amount);
		System.out.printf("%-50d %-25s %-20s \n", accountNO, accountName, str1);
	}
}
