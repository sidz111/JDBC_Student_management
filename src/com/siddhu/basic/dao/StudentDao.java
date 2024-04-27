package com.siddhu.basic.dao;

import java.sql.SQLException;
import java.util.List;

import com.siddhu.basic.model.Student;

public interface StudentDao {

	String insertStudent(Student s) throws SQLException;
	String updateStudent(Student s) throws SQLException;
	String deleteStudentByRoll(Integer roll) throws SQLException;
	Student findStudentByRoll(Integer roll) throws SQLException;
	List<Student> showAllStudent() throws SQLException;
	String deleteAllStudents() throws SQLException;
	
}
