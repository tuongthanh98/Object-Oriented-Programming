package fit.se.edu.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	@NonNull
	private String name;
	private byte age;
	private String address;
	
	/*GPA of student*/
	private float gpa;
}
