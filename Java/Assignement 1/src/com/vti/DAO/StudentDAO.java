package com.vti.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Student;
import com.vti.ultis.jdbcUltis;

public class StudentDAO {
	private jdbcUltis jdbc;

	public StudentDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

// Lấy danh sách Student
	public List<Student> getListStudent() throws ClassNotFoundException, SQLException {
		String sqlSelect = "SELECT * FROM student;";
		ResultSet resultSet = jdbc.executeQuery(sqlSelect);

		List<Student> studentList = new ArrayList<>();
		while (resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setBirthdayDate(resultSet.getDate(3).toLocalDate());
			student.setEmail(resultSet.getString(4));
			student.setClassStudy(resultSet.getString(5));
			student.setCreateDate(resultSet.getDate(6).toLocalDate());

			studentList.add(student);

		}
		return studentList;

	}

	public Student getStudentByID(int idFind) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlSelect = "SELECT * FROM student where StudentID=?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlSelect);
		preparedStatement.setInt(1, idFind);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setBirthdayDate(resultSet.getDate(3).toLocalDate());
			student.setEmail(resultSet.getString(4));
			student.setClassStudy(resultSet.getString(5));
			student.setCreateDate(resultSet.getDate(6).toLocalDate());
			return student;

		} else {
			return null;
		}
	}

	public Boolean isClassExist(String name) throws ClassNotFoundException, SQLException {
		String sqlSelect = "SELECT * FROM student where ClassStudy =?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlSelect);
		preparedStatement.setString(1, name);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {

			return false;
		}

	}

	public Boolean createStudent(String studentNameCreate, LocalDate studentBirthday, String studentEmail,
			String studentClass) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO student(FullName, Birthdate, Email, ClassStudy) VALUE(?,?,?,?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlInsert);
		preparedStatement.setString(1, studentNameCreate);
		preparedStatement.setDate(2, java.sql.Date.valueOf(studentBirthday));
		preparedStatement.setString(3, studentEmail);
		preparedStatement.setString(4, studentClass);
		int result = preparedStatement.executeUpdate();

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean updateStudentName(int idUpdate, String newStudentName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlUpdate = "UPDATE student SET FullName =? WHERE StudentID =?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlUpdate);
		preparedStatement.setString(1, newStudentName);
		preparedStatement.setInt(2, idUpdate);

		int result = preparedStatement.executeUpdate();

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean deleteStudentName(int idDelete) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlUpdate = "DELETE FROM student WHERE StudentID =?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlUpdate);
		preparedStatement.setInt(1, idDelete);

		int result = preparedStatement.executeUpdate();

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}