package com.siddhu.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.siddhu.basic.model.Student;

public class StudentDaoImpl implements StudentDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private String query = null;

	public StudentDaoImpl() throws ClassNotFoundException, SQLException {
		connection = MyConnection.getConnection();
	}

	@Override
	public String insertStudent(Student s) throws SQLException {
		query = "insert into emp values(?,?);";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, s.getRoll());
		preparedStatement.setString(2, s.getName());
		Integer row = preparedStatement.executeUpdate();
		return row + " rows affected";
	}

	@Override
	public String updateStudent(Student s) throws SQLException {
		query = "update emp set name=? where roll=?;";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, s.getName());
		preparedStatement.setInt(2, s.getRoll());
		Integer row = preparedStatement.executeUpdate();
		return row + " rows affected";
	}

	@Override
	public String deleteStudentByRoll(Integer roll) throws SQLException {
		query = "delete from emp where roll=?;";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, roll);
		Integer row = preparedStatement.executeUpdate();
		return row + " Student deleted";
	}

	@Override
	public Student findStudentByRoll(Integer roll) throws SQLException {
		query = "select * from emp where roll=?;";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, roll);
		ResultSet resultSet = preparedStatement.executeQuery();
		Student s = new Student();
		if (resultSet.next()) {
			s.setRoll(resultSet.getInt(1));
			s.setName(resultSet.getString(2));
		} else {
			s = null;
		}
		return s;
	}

	@Override
	public List<Student> showAllStudent() throws SQLException {
		query = "Select * from emp;";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while (resultSet.next()) {
			Student s = new Student();
			s.setRoll(resultSet.getInt(1));
			s.setName(resultSet.getString(2));
			list.add(s);
		}
		return list;
	}

	@Override
	public String deleteAllStudents() throws SQLException {
		query = " truncate table emp;";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeUpdate();
		return "All Students Deleted";
	}
}
