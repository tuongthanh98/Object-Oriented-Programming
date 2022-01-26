package fit.se.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Complex class
 * 
 * @author Thanh Tuong
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexNumber {
	// Declare real and imaginary parts of complex numbers
	private double real, img;
}
