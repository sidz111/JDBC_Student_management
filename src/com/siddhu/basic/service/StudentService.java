package com.siddhu.basic.service;

import java.util.List;

import com.siddhu.basic.model.Student;

public interface StudentService {
	String insertStudent(Student s);
	String updateStudent(Student s);
	String deleteStudentByRoll(Integer roll);
	Student findStudentByRoll(Integer roll);
	List<Student> showAllStudent();
	String deleteAllStudents();
}
