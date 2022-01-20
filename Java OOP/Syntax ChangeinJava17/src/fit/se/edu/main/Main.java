package fit.se.edu.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		declareNewString();
		declareSwitchCase();
		declareSwitchCaseWithYield("ORANGE");
	}

	/**
	 * @hidden
	 * @author ISV-04
	 * */
	static void declareNewString() {
		String newStr = """
				{
					"Date": "20220118102933",
					"FirstName": "Test",
					"LastName": "Data",
					"Gender": "Male",
					"Age": 9,
					"Email": "testdata@gmail.com",
					"City": "",
					"Country": "",
					"MobieNo": "0903179325",
					"Fax": "1234567890"
				}
				""";
		System.out.println(newStr);
	}
	
	/**
	 * @hidden
	 * @author ISV-04
	 * */
	static void declareSwitchCase() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input name of food ur favorite: ");
		
		try {
			String fruit = sc.nextLine();
			
			// Old way
			switch (fruit) {
			case "APPLE", "PEAR": {
				System.out.println("Common fruit");
				break;
			}
			case "ORGANE", "AVOCADO": {
				System.out.println("Exotic fruit");
				break;
			}
			default:
				System.out.println("Undefined fruit");
			}	
			
			// New way
			// Use Label Expression
			switch (fruit) {
			case "APPLE", "PEAR" ->	System.out.println("New way: Common fruit");
			case "ORGANE", "AVOCADO" ->	System.out.println("New way: Exotic fruit");		
			default -> System.out.println("New way: Undefined fruit");
			}
			
			// Another way
			// A Switch Expression can also return a value.
			// You can return the String values and assign them to a variable text
			// After this, the text variable can be printed
			// 
			String text = switch (fruit) {
			case "APPLE", "PEAR" -> "New way: Common fruit";
			case "ORGANE", "AVOCADO" ->	"New way: Exotic fruit";		
			default -> "New way: Undefined fruit";
			};
			
			System.out.println(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// TODO: handle finally clause
			sc.close();
		}
	}
	
	/**
	 * @hidden
	 * @author ISV-04
	 * */
	static void declareSwitchCaseWithYield(String key) {
		String text = switch (key) {
			// declare with block
			// Handler more task
			// Example: 
			// case "APPLE", "PEAR" -> { String a = "Hello World!"; System.out.println(a);; yeild "Common Fruit!"}
			case "APPLE", "PEAR" -> { yield "Common Fruit!"; }		
			case "ORANGE", "AVOCADO" -> { yield "Exotic fruit";}		
			default ->{yield "Undenfined fruit";}		
		};
		System.out.println(text);
	}
}
