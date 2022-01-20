package fit.se.edu.dao;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fit.se.edu.entity.Student;
import lombok.Getter;
import lombok.Setter;

/**
 * StudentManager class
 * 
 * @author ISV-04
 */
public class StudentManager {
	public static Scanner sc = new Scanner(System.in);

	@Getter
	@Setter
	private List<Student> students;
	private StudentDao dao;

	/**
	 * init StudentDao object and read lit student when init StudentManager object
	 */
	public StudentManager() {
		dao = new StudentDao();
		students = dao.read();
	}

	/**
	 * add student to students
	 */
	public void add() {
		int id = (students.size() > 0) ? (students.size() + 1) : 1;
		System.out.println("student id = " + id);
		String name = inputName();
		byte age = inputAge();
		String address = inputAddress();
		float gpa = inputGpa();
		
		Student student = new Student(id, name, age, address, gpa);
		students.add(student);
		dao.write(students);
	}
	
	/**
	 * edit student by id
	 * 
	 * @param id 
	 */
	public void edit (int id) {
		boolean isExisted = false;
//		int size = students.size();
		
		for (Student student : students) {
			if (student.getId() == id) {
				isExisted = true;
				student.setName(inputName());
				student.setAge(inputAge());
				student.setAddress(inputAddress());
				student.setGpa(inputGpa());
				break;
			}
		}
		
		if (!isExisted) {
			System.out.printf("id = %d not existed.\n", id);
		}else {
			dao.write(students);
		}
	}
	
	/**
	 * delete student by id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		Student st = null;
		for (Student student : students) {
			if (student.getId() == id) {
				st = student;
			}
		}		
		if (st != null) {
			students.remove(st);
			dao.write(students);
		}else {
			System.out.printf("id = %d not existed. \n", id);
		}
	}

	/**
	 * sort student by GPA
	 */
	public void sortStudentByGPA() {
		Collections.sort(students, new SortStudentbyGPA());
	}

	/**
	 * sort student by Name
	 */
	public void sortStudentByName() {
		Collections.sort(students, new SortStudentByName());
	}

	/**
	 * show list student to screen
	 */
	public void show() {
		for (Student student : students) {
			System.out.format("%5d ", student.getId());
			System.out.format("%20s ", student.getName());
			System.out.format("%5d ", student.getAge());
			System.out.format("%5s ", student.getAddress());
			System.out.format("%10.1f%n ", student.getGpa());
		}
	}

	/**
	 * input student id
	 * 
	 * @return student id
	 */
	public int inputId() {
		System.out.println("Input student  id: ");
		while (true) {
			try {
				int id = Integer.parseInt(sc.nextLine());
				return id;
			} catch (NumberFormatException e) {
				System.out.println("Invalid! Input student id again: ");
			}

		}
	}

	/**
	 * input stundent name
	 * 
	 * @return student name
	 */
	private String inputName() {
		System.out.println("Please input student name: ");
		return sc.nextLine();
	}

	/**
	 * input student address
	 * 
	 * @return student address
	 */
	private String inputAddress() {
		System.out.println("Please input student address: ");
		return sc.nextLine();
	}

	/**
	 * input student age
	 * 
	 * @return student age
	 */
	private byte inputAge() {
		System.out.println("Please input student age: ");
		while (true) {
			try {
				byte age = Byte.parseByte(sc.nextLine());
				if (age < 0 && age > 100)
					throw new NumberFormatException();
				return age;
			} catch (NumberFormatException e) {
				System.out.println("Invalid! Input student age again: ");
			}
		}
	}
	
	/**
	 * input stundet
	 * 
	 * @return student gpa
	 */
	private float inputGpa() {
		System.out.println("Please input student gpa: ");
		while (true) {
			try {
				float gpa = Float.parseFloat(sc.nextLine());
				if (gpa < 0.0 && gpa > 10.0) {
					throw new NumberFormatException();
				}
				return gpa;
			} catch (Exception e) {
				System.out.println("invalid! Input student student gpa again: ");
			}
		}
	}
	
	
}
