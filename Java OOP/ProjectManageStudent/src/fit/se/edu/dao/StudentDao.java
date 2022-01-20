package fit.se.edu.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fit.se.edu.entity.Student;

/**
 * StudentDao calss
 * @author ISV-04
 *
 * */
public class StudentDao {
	private static final String STUDENT_FILE_NAME = "student.txt";

	/**
	 * Save list student to file
	 *
	 * @param studentList: list student to save
	 * */
	public void write(List<Student> studentList) {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(studentList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(fos);
		}
	}


	/**
	 * read list student from file
	 *
	 * @return list student
	 * */
	@SuppressWarnings("unchecked")
	public List<Student> read(){
		List<Student> studentList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(new File(STUDENT_FILE_NAME));
			ois = new ObjectInputStream(fis);
			studentList = (List<Student>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeStream(fis);
			closeStream(ois);
		}

		return studentList;
	}


	/**
	 * Close input stram
	 * @param is: input stream
	 * */
	private void closeStream(InputStream is) {
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


	/**
	 * Close output stream
	 *
	 * @param os: output stream
	 * */
	private void closeStream(OutputStream os) {
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
