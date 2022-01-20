package fit.se.edu.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// The String is immutable
		StringLo();
		newOperatorString();
		
		// use new way declare new String by JDK 17
		declareNewStringByJDK17();

		// StringBuilder and StringBuffer are mutable
		
		// use StringJoiner
		declareStringJoiner();
	}

	/**
	 * @author ISV-04 Declare String by new operator
	 * @hidden
	 */
	static String newOperatorString() {
		String str = new String("The Cat");
		System.out.println(str);
		return str;
	}

	/**
	 * @author ISV-04
	 * @hidden
	 */
	static String StringLo() {
		String str = "The Cat";
		System.out.println(str);
		return str;
	}

	static StringBuffer declareStringBuffer() {
		StringBuffer sbf = new StringBuffer("String Buffer");
		return sbf;
	}

	/**
	 * @author ISV-04 
	 * Declare String Builder
	 * @hidden
	 */
	static StringBuilder declareStringBuilder() {
		StringBuilder sb = new StringBuilder("String Builder");
		return sb;
	}

	/**
	 * @author ISV-04
	 * Declare new String by JDK 17
	 * */
	static void declareNewStringByJDK17() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		String newStr = """
				{
					"Date": "@Datetime",
					"FirstName": "Test",
					"LastName": "Data",
					"Gender": "Male";
					"Age": 20,
					"Country": "",
				}""";
		newStr = newStr.replace("@Datetime", dateFormat.format(date));
		System.out.println(newStr);
	}
	
	/**
	 * Declare new string by use StringJoiner
	 */
	static void declareStringJoiner() {
		StringJoiner strJoiner = new StringJoiner(" ", "{ ", " }");
		strJoiner.add("Hello");
		strJoiner.add("World!");
		
		System.out.println("This is StringJoiner 1: " + strJoiner);
		
		StringJoiner strJoiner2 = new StringJoiner(", ", "\"", "\"");
		strJoiner2.add("Hello2");
		strJoiner2.add("World2!");
		
		System.out.println("This is StringJoiner 2: " + strJoiner2);
		System.out.println("This is merge two StringJoiner: "+ strJoiner2.merge(strJoiner));
		System.out.println("This is merge two StringJoiner: "+ strJoiner.merge(strJoiner2));
	}
}
