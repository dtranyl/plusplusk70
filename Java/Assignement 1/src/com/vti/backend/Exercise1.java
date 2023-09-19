package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.vti.DAO.StudentDAO;
import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1 {
	public StudentDAO studentDAO;

	public Exercise1() throws FileNotFoundException, IOException {
		studentDAO = new StudentDAO();
	}

//	private jdbcUltis jdbc;
//
//	public Exercise1() throws FileNotFoundException, IOException {
//		jdbc = new jdbcUltis();
//	}
//
//	public void question1() throws ClassNotFoundException, SQLException {
//		jdbc.connnectionTestting();
//	}
//
//	public void question2() throws ClassNotFoundException, SQLException {
//		String sqlSelect = "SELECT * FROM student;";
//		ResultSet resultSet = jdbc.executeQuery(sqlSelect);
//		System.out.println("Thông tin student");
//		while (resultSet.next()) {
//			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
//		}
//	}
//
//	public void question3() throws ClassNotFoundException, SQLException {
//		System.out.println("Thêm mới tên");
//		String studentName = ScannerUltis.inputString();
//		String sqlInsert = "INSERT INTO student (FullName) VALUES(?);";
//		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlInsert);
//		preparedStatement.setString(1, studentName);
//		int result = preparedStatement.executeUpdate();
//		if (result == 1) {
//			System.out.println("Insert dữ liệu thành công");
//		} else {
//			System.out.println("Có lỗi xảy ra");
//		}
//	}
//
//	public void question4() throws ClassNotFoundException, SQLException {
//		System.out.println("Update Name");
//		System.out.println("Mời bạn nhập vào ID cần update");
//		int id = ScannerUltis.inputIntPositive();
//
//		System.out.println("Mời bạn nhập vào studentName cần update");
//		String name = ScannerUltis.inputString();
//
//		String sqlUppdate = "UPDATE student SET FullName =? WHERE StudentID = ?;";
//
//		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sqlUppdate);
//		preparedStatement.setString(1, name);
//		preparedStatement.setInt(2, id);
//		int result = preparedStatement.executeUpdate();
//		if (result == 1) {
//			System.out.println("Update dữ liệu thành công");
//		} else {
//			System.out.println("Có lỗi xảy ra");
//		}
//
//	}
	public void question1() throws ClassNotFoundException, SQLException {
		List<Student> studentList = studentDAO.getListStudent();

		for (Student student : studentList) {
			System.out.println(student.getId() + " " + student.getName() + " " + student.getBirthdayDate() + " "
					+ student.getEmail() + " " + student.getClassStudy() + " " + student.getCreateDate());
		}

	}

	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập ID cần tìm kiếm");
		int idFind = ScannerUltis.inputIntPositive();
		Student student = studentDAO.getStudentByID(idFind);
		if (student != null) {
			System.out.println(student.getId() + " " + student.getName() + " " + student.getBirthdayDate() + " "
					+ student.getEmail() + " " + student.getClassStudy() + " " + student.getCreateDate());
		} else {
			System.out.println("Không có student này");
		}
	}

	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập tên môn học");
		String name = ScannerUltis.inputString();

		Boolean result = studentDAO.isClassExist(name);
		if (result == true) {
			System.out.println("Môn học này tồn tại");
		} else {
			System.out.println("Môn học này ko tồn tại");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập tên sinh viên cần tạo");
		String studentNameCreate = ScannerUltis.inputString();
		System.out.println("Mời bạn nhập ngày sinh cũa sinh viên cần tạo");
		LocalDate studentBirtDate = ScannerUltis.inputLocalDate();
		System.out.println("Mời bạn nhập email của sinh viên cần tạo");
		String studentEmail = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập lớp học của sinh viên cần tạo");
		String studentClass = ScannerUltis.inputString();

		Boolean resultCreate = studentDAO.createStudent(studentNameCreate, studentBirtDate, studentEmail, studentClass);
		if (resultCreate == true) {
			System.out.println("Thêm student thành công");
			question1();
		} else {
			System.out.println("Không thành công");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập vào id của phòng ban cần update");
		int idUpdate = ScannerUltis.inputIntPositive();

		System.out.println("Mời bạn nhập tên sinh viên cần đổi:");
		String newStudentName = ScannerUltis.inputString();

		Boolean resultBoolean = studentDAO.updateStudentName(idUpdate, newStudentName);
		if (resultBoolean == true) {
			System.out.println("Thêm student thành công");
			question1();
		} else {
			System.out.println("Không thành công");
		}
	}

	public void question6() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập vào id của phòng ban cần xóa");
		int idDelete = ScannerUltis.inputIntPositive();

		Boolean resultBoolean = studentDAO.deleteStudentName(idDelete);
		if (resultBoolean == true) {
			System.out.println("Xóa student thành công");
			question1();
		} else {
			System.out.println("Không thành công");
		}
	}

}
