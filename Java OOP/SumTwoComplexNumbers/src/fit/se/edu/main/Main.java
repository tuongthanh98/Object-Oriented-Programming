package fit.se.edu.main;

import fit.se.edu.entity.ComplexNumber;

/**
 * Main class
 * 
 * @author Thanh Tuong
 *
 */
public class Main {

	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(4.8, 10.3);
		ComplexNumber c2 = new ComplexNumber(9.7, 6.8);
		ComplexNumber temp = sum(c1, c2);
		System.out.println("Result is " + temp.getReal() + " + " + temp.getImg() + "i");
	}

	/**
	 * methd plus two complex number
	 */
	static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
		// create a complex number that holds the sum of two numbers
		ComplexNumber temp = new ComplexNumber(0, 0);
		
		temp.setReal(c1.getReal() + c2.getReal());
		temp.setImg(c1.getImg() + c2.getImg());
		
		return temp;
	}
}
