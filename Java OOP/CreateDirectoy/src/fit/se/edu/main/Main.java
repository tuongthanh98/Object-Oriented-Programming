package fit.se.edu.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class
 * 
 * @author ISV-04
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		boolean exit = false;

		do {
			// show menu
			showMenu();
			try {
				choose = sc.nextInt();
			} catch (NumberFormatException e) {
				sc.next();
			}

			switch (choose) {
			case 1 -> {
				try {
					usingJavaNio();
					System.out.println("Directory is created!");
				} catch (IOException e) {
					System.out.println("Failed to create directory!" + e.getMessage());
				}
			}
			case 2 -> {
				try {
					usingJavaIO();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			default -> exit = true;
			}
		} while (!exit);
		System.exit(0);
	}

	/**
	 * create menu
	 */
	static void showMenu() {
		System.out.println("-----------Menu------------");
		System.out.println("1. Create directory by Java Nio.");
		System.out.println("2. Create directory by Java IO.");
		System.out.println("Enter any number except the numbers in the menu to exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}

	/**
	 * using Java Nio
	 * 
	 * @throws IOException
	 */
	static void usingJavaNio() throws IOException {
		Path path = Paths.get("Folder_" + generateNameFolder());
		Files.createDirectory(path);
	}

	/**
	 * using java IO
	 * 
	 * @throws IOException
	 */
	static void usingJavaIO() throws IOException {
//		String dir = generateNameFolder();
		String dir = "Foler";
		File file = new File(dir);
		
		// Both the file.mkdir and file.mkdirs methods 
		// return true if the directory is initialized successfully.
		if (file.mkdirs()) {
			System.out.println("Directory is created!");
		} else {
			System.out.println("Failed to create directory!");
		}
	}

	/**
	 * generate name foldler
	 */
	static String generateNameFolder() {
		int len = 110;
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		return new Random().ints(leftLimit, rightLimit + 1).limit(len)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}
}
