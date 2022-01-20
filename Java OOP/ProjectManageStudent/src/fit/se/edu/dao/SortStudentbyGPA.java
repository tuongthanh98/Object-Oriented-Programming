package fit.se.edu.dao;

import java.util.Comparator;

import fit.se.edu.entity.Student;

/**
 * SortStudentByGPA class
 *
 * @author ISV-04
 * */
public class SortStudentbyGPA implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getGpa() > s2.getGpa()) {
			return 1;
		}
		return -1;
	}
}
