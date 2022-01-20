package fit.se.edu.dao;

import java.util.Comparator;

import fit.se.edu.entity.Student;

/**
 * SortStudentByName class
 *
 * @author ISV-04
 * */
public class SortStudentByName implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
