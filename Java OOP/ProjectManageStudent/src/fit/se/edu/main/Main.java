package fit.se.edu.main;

import java.util.Scanner;

import fit.se.edu.dao.StudentManager;

/**
 * Main class
 * 
 * @author ISV-04
 *
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String choose = null;
		boolean exit = false;
		StudentManager manager = new StudentManager();
		int studentId;
		
		// Show menu
		showmenu();
		while (true) {
			choose = sc.nextLine();
			
			switch (choose) {
			case "1" -> { manager.add();}	
			case "2" -> { 
				studentId = manager.inputId(); 
				manager.edit(studentId);
			}	
			case "3" -> { 
				studentId = manager.inputId();
				manager.delete(studentId);				
			}	
			case "4" -> { 
				manager.sortStudentByGPA();
			}	
			case "5" -> { 
				manager.sortStudentByName();
			}	
			case "6" -> { 
				manager.show();
			}
			case "0" -> { 
				System.out.println("exited!");
				exit = true;
			}
			default -> throw new IllegalArgumentException("Unexpected value: " + choose);
			}
			
			if (exit) {
				break;
			}
			// Show menu again
			showmenu();
		}			
	}
	
	/**
	 * create menu
	 */
	static void showmenu() {
		System.out.println("-----------Menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}
}
