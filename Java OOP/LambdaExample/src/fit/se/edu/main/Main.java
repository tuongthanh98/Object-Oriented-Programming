package fit.se.edu.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import fit.se.edu.entity.Product;

/**
 * Drawable interface class
 * 
 * @author ISV-04
 *
 */
interface Drawable {
	public void draw();
//	public void draw(int width);
}

/**
 * Sayable interface class
 * 
 * @author ISV-04
 *
 */
interface Sayable {
	public String say(String value);
}

/**
 * Operation interface class
 * 
 * @author ISV-04
 *
 */
interface Operation {
	public int plus(int a, int b);
}

/**
 * Main class
 * 
 * @author ISV-04
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int width = 10;
		String choose = "";
		boolean checkExist = true;
		// Show menu
		showMenu();
		while (checkExist) {
			try {
				choose = sc.nextLine();

				switch (choose) {
				case "1" -> {
					// The method no use lambda
					noUseLambda(width);
				}
				case "2" -> {
					// The method use lambda
					useLambda(width);
				}
				case "3" -> {
					// The method use lambda with parameter
					useLambdaWithParameter();
				}
				case "4" -> {
					// The method use lambda with parameters
					useLambdaWithParameters(8, 9);
				}
				case "5" -> {
					// The method use lambda with foreach
					useLambdaWithForEach();
				}
				case "6" -> {
					// The method use lambda with Comparator
					useLambdaWithComparator();
				}

				case "7" -> {
					// The method use lambda with Filter Collection Data
					useLambdaWithFilterCollectionData();
				}

				case "0" -> {
					checkExist = false;
				}

				default -> throw new IllegalArgumentException("Unexpected value: " + choose);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// Show menu again
				if (checkExist) {
					showMenu();
				}
			}
		}
	}

	/**
	 * create menu
	 */
	static void showMenu() {
		System.out.println("-----------Menu------------");
		System.out.println("1. Example no use Lambda.");
		System.out.println("2. Example use Lambda.");
		System.out.println("3. Example use Lambda with parameter.");
		System.out.println("4. Example use Lambda with more parameters.");
		System.out.println("5. Example use Lambda with Foreach.");
		System.out.println("6. Example use Lambda with Collections.");
		System.out.println("7. Example use Lambda with Filter Collection Data.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}

	/**
	 * @param value: width
	 */
	static void noUseLambda(int value) {
		Drawable drawable = new Drawable() {

			@Override
			public void draw() {
				// TODO Auto-generated method stub
				System.out.println("No use lambda. Drawing: " + value);
			}
		};

		drawable.draw();
	}

	/**
	 * use lambda
	 * 
	 * @param value: width
	 */
	static void useLambda(int value) {
		Drawable drawable = () -> {
			System.out.println("Use lambda! Drawing " + value);
		};

		drawable.draw();
	}

	/**
	 * use lambda with parameter
	 */
	static void useLambdaWithParameter() {
		Sayable sayable = (value) -> {
			return value;
		};

		System.out.println(sayable.say("Sayable.say: Hello"));
	}

	/**
	 * use Lambda with more parameter
	 */
	static void useLambdaWithParameters(int value1, int value2) {
		Operation operation = (a, b) -> {
			return a + b;
		};

		System.out.println("Plus a + b = " + operation.plus(value1, value2));
	}

	/**
	 * use lambda with foreach
	 */
	static void useLambdaWithForEach() {
		List<String> newLst = new ArrayList<String>();

		newLst.add("Java");
		newLst.add("C#");
		newLst.add("PHP");
		newLst.add("ReactJS");
		newLst.add("NodeJS");
		newLst.add("Python");

		System.out.println("Use lambda with foreach: ");
		newLst.forEach((element) -> {
			System.out.println(element);
		});
	}

	/**
	 * use lambda with Comparator
	 */
	static void useLambdaWithComparator() {
		List<Product> products = new ArrayList<Product>();

		products.add(new Product(1, "Dell Laptop", 25000f));
		products.add(new Product(2, "Keyboard", 300f));
		products.add(new Product(3, "Dell Mouse", 150f));

		System.out.println("Sort products by name: ");

		// Lambda expression implementation
		Collections.sort(products, (p1, p2) -> {
			return p1.name.compareTo(p2.name);
		});

		for (Product product : products) {
			System.out.println(product.id + " " + product.name + " " + product.price);
		}
	}

	/**
	 * use lambda with Filter Collection Data
	 */
	static void useLambdaWithFilterCollectionData() {
		List<Product> products = new ArrayList<Product>();

		products.add(new Product(1, "SamSung A8", 17000f));
		products.add(new Product(2, "Iphone 8 Plus", 65000f));
		products.add(new Product(3, "Sony Xperia X8", 25000f));
		products.add(new Product(4, "Nokia L7", 15000f));
		products.add(new Product(5, "Redmi Note 7 ", 26000f));
		products.add(new Product(6, "Lenevo Vibe", 19000f));

		// Use lambda expression to filter data
		Stream<Product> stream = products.stream().filter(p -> p.price > 20000);

		// use lambda to traverse the elements of the collection
		stream.forEach(product -> {
			System.out.println(product.name + ": " + product.price);
		});
	}
	
}
