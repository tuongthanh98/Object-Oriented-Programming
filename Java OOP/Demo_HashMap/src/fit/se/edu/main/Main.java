package fit.se.edu.main;

import java.util.HashMap;

/**
 * Main class
 * 
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		// declare HashMap
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		// add elements to hashMap
		hashMap.put(1, "Java");
		hashMap.put(2, "C#");
		hashMap.put(3, "Phython");
		hashMap.put(4, "Php");
		hashMap.put(5, "Nodejs");
		
		// print value of hashMap
//		System.out.println(hashMap);
		showValueOfHashMap(hashMap);
		System.exit(0);
	}
	
	/**
	 * 
	 * @param hashMap
	 */
	static void showValueOfHashMap(HashMap<Integer, String> hashMap) {
		if (!hashMap.isEmpty()) {
			for (Integer key : hashMap.keySet()) {
				// hashMap.get(key) is return value of key
				System.out.println(key + " - " + hashMap.get(key));
			}
		}
	}

}
