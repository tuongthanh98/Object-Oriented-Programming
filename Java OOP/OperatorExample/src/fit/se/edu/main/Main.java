package fit.se.edu.main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author ISV-04
 *
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choose = 0;
		boolean exist = false;
		while (!exist) {
			// Show menu
			showMenu();
			try {
				choose = sc.nextInt();
				switch (choose) {
				case 1 ->{ 
					arithmeticOperators();
				}
				case 2 ->{ 
					assignmentOperator();
				}				
				case 3 -> { 
					RelationalOperators();
				}
				case 4 -> { 
					logicOperators();
				}
				case 5 -> { 
					unaryOperators();
				}
				case 6 -> { 
					ternaryOperator();
				}
				case 7 -> { 
					instanceofOperator();
				}
				case 0 -> { 
					exist = true;
				}
				default ->
					throw new IllegalArgumentException("Unexpected value: " + choose);
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.next(); // Move to next other wise exception
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} 
		}	
	}

	/**
	 * Create menu
	 */
	static void showMenu() {
		System.out.println("-----------Menu------------");
        System.out.println("1. Arithmetic Operators.");
        System.out.println("2. Assign Operator.");
        System.out.println("3. Relational Operators.");
        System.out.println("4. Logic Operators.");
        System.out.println("5. Unary Operators.");
        System.out.println("6. Ternary Operator.");
        System.out.println("7. Instanceof Operator.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
	}
	
	//STAR Method	
	/**
	 * 1/ Arithmetic Operators - Toán tử số học:
	 *   Operator	 					Operation		 			 	 	Example
	 * 		+ 		 Addition 	 	  									result = a + b;
	 * 		- 		 Subtraction	  									result = a - b;
	 * 		*    	 Multiplication 	 								result = a * b;
	 * 		/ 		 Division	 										result = a / b;
	 *		% 		 Modulo Operation (Remainder after division) 		result = a % b;
	 */
	static void arithmeticOperators() {
		// declare variables
	    int a = 12, b = 5;
	    System.out.println("Value a is " + a + " and value b is "+ b);
	    // addition operator
	    System.out.println("a + b = " + (a + b));

	    // subtraction operator
	    System.out.println("a - b = " + (a - b));

	    // multiplication operator
	    System.out.println("a * b = " + (a * b));

	    // division operator
	    System.out.println("a / b = " + (a / b));

	    // modulo operator
	    System.out.println("a % b = " + (a % b));
	}
	
	/**
	 * 2/ Assignment operator - Toán tử gán:
	 *   Operator	 	Example 	 	Equivalent to
	 *  	= 		 	a = b;		 		a = b; 
	 * 		+= 		 	a += b;  	 	  a = a + b;
	 * 		-= 		 	a -= b; 		  a = a - b;
	 * 		*=    	 	a *= b; 	 	  a = a * b;
	 * 		/= 		 	a /= b; 	 	  a = a / b;
	 *		%= 		 	a %= b; 	 	  a = a % b;
	 */
	static void assignmentOperator() {
		int var = 20;
		int p , q, r, s;
		p = q = r = s = 1;
		System.out.println("This is value of var: " + var);
		
		System.out.println("There are values of p, q, r, s before assign operator: " 
							+ p + ", "
							+ q + ", " 
							+ r + ", " 
							+ s);
		
		// Assign value using =
		p = q = var;
		System.out.println("Assign value of var for p, q using =");
		System.out.println("There are values of p, q, r, s after assign operator: " 
				+ p + ", "
				+ q + ", " 
				+ r + ", " 
				+ s);
		
		// Assign value using +=
		r += var;
		System.out.println("r using += var: " + r);
		
		// Assign value using *=
		s *= var;		
		System.out.println("s using *= var: " + s);
	}
		
	/**
	 * 3/ Relational Operators - Toán tử quan hệ:
	 *   Operator	 	Description 	 	   	  		   Example
	 *  	== 			Is Equal To		 	 		3 == 5 returns false  
	 *		!=			Not Equal To   		 		3 != 5 returns true
	 *		>			Greater Than   		 		3 >  5 returns false
	 *		<			Less Than   		 		3 <  5 returns true
	 *		>=			Greater Than or Equal To   	3 >= 5 returns false
	 *		<=			Less Than or Equal To   	3 <= 5 returns true
	 * */
	static void RelationalOperators() {
		// create varialbes
		int a = 7, b = 11;
		
		System.out.println("a is " + a + " and b is "+ b);
		// == operator
		System.out.println("Result of a == b: " + (a == b));
		// != operator
		System.out.println("Result of a != b: " + (a != b));
		// > operator
		System.out.println("Result of a > b: " + (a > b));
		// < operator
		System.out.println("Result of a < b: " + (a < b));
		// >= operator
		System.out.println("Result of a >= b: " + (a >= b));
		// <= operator
		System.out.println("Result of a <= b: " + (a <= b));
	}
	
	/**
	 * 4/ Logical Operators - Toán tử logic: 
	 *   Operator	 	  Example 	 	   				Meaning
	 *  &&(Logical 		expression1 &&		 true only if both expression1 and  
	 *	AND)			expression2   		 expression2 are true
	 *
	 * 	||(Logical 		expression1 ||  	 true if either expression1 or 
	 *	OR)				expression2   		 expression2 is true
	 *
	 * 	! (Logical 		!expression 		 true if expression is false and 
	 *	NOT)			   		  			 vice versa
	 */
	static void logicOperators() {
		// Declare variables;
		int a  = 3, b = 5, c = 8;
		System.out.println("Logic Operators: ");
		// && operator
	    System.out.println("\t(5 > 3) && (8 > 5): " + ((b > a) && (c > b)));  // true
	    System.out.println("\t(5 > 3) && (8 < 5): " + ((b > a) && (c < b)));  // false

	    // || operator
	    System.out.println("\t(5 < 3) || (8 > 5): " + ((b < a) || (c > b)));  // true
	    System.out.println("\t(5 > 3) || (8 < 5): " + ((b > a) || (c < b)));  // true
	    System.out.println("\t(5 < 3) || (8 < 5): " + ((b < a) || (c < b)));  // false

	    // ! operator
	    System.out.println("\t!(5 == 3): " + (!(b == a)));  // true
	    System.out.println("\t!(5 > 3): " + (!(b > a)));  // false
	}
		
	/**
	 * 5/ Unary Operators - Toán tử 1 ngôi:
	 * Operator				Meaning
	 * 	  +			Unary plus: not necessary to use since numbers are positive  
	 * 	  			without using it 
	 * 	  -			Unary plus: inverts the sign of an expression 
	 * 	  ++		Increment operator (Toán tử tăng dần): increments value by 1 
	 * 	  --		Decrement operator (Toán tử giảm dần): decrements value by 1 
	 * 	  ! 		Logical complement operator: inverts the value of a boolean
	 */
	static void unaryOperators() {
		// declare variables
	    int a = 12, b = 12;
	    int result1, result2;

	    // original value
	    System.out.println("Value of a: " + a);

	    // increment operator
	    result1 = ++a;
	    System.out.println("After increment: " + result1);

	    System.out.println("Value of b: " + b);

	    // decrement operator
	    result2 = --b;
	    System.out.println("After decrement: " + result2);
	}
	
	/**
	 * 6/ Ternary operator - Phép toán điều kiện: 
	 *  biểu thức logic ? giá trị trả về 1 : giá trị trả về 2
	 *  nếu biểu thức logic đúng (true) trả về "giá trị trả về 1"
	 *  Nếu sai trả về "giá trị trả về 2"
	 */
	static void ternaryOperator() {
		int a = 20;
		int b = 3;
//		String a = null;
//		String b = (a == null || a.isEmpty() || a.isBlank()) ? "A varible a is null" : "A varible a not null"; 
		String s = (a%b == 0) ? "a chia hết cho b" : "a không chia hết cho b"; 
		System.out.println(s);		
	}
		
	/**
	 * 7/ instanceof Operator - Toán tử kiểm đối tượng là một lớp cụ thể:
	 * The instanceof operator checks whether an object is an instanceof a particular class.
	 */
	static void instanceofOperator() {
		String newStr = "Hello";
		boolean result;
		result = newStr instanceof String;
		System.out.println("Is str an object of String? " + result);
	}
	//END method
}
