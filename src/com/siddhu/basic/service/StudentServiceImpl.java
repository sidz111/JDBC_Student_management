package com.siddhu.basic.service;

import java.sql.SQLException;
import java.util.List;

import com.siddhu.basic.dao.StudentDao;
import com.siddhu.basic.dao.StudentDaoImpl;
import com.siddhu.basic.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentServiceImpl() {
		try {
			studentDao = new StudentDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String insertStudent(Student s) {
		String ans = null;
		try {
			ans = studentDao.insertStudent(s);
		} catch (SQLException e) {
			return "use different Roll number please....";
//			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public String updateStudent(Student s) {
		String ans = null;
		try {
			ans = studentDao.updateStudent(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public String deleteStudentByRoll(Integer roll) {
		String ans = null;
		try {
			ans = studentDao.deleteStudentByRoll(roll);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Student findStudentByRoll(Integer roll) {
		Student s = null;
		try {
			s = studentDao.findStudentByRoll(roll);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> showAllStudent() {
		List<Student> list = null;
		try {
			list = studentDao.showAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteAllStudents() {
		String ans = null;
		try {
			ans = studentDao.deleteAllStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

}
