package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1;
import com.vti.ultis.ScannerUltis;

public class Demo {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

		Exercise1 exercise1 = new Exercise1();
		while (true) {
			System.out.println("Mời bạn chọn câu hỏi:");
			System.out.println("1. Hiển thi danh sách sinh viên ");
			System.out.println("2.Tìm student theo ID ");
			System.out.println("3.Kiểm tra môn học có tồn tại ko ");
			System.out.println("4.Thêm sinh viên: ");
			System.out.println("5.Update tên sinh viên: ");
			System.out.println("6. Xóa sinh viên");

			int chooseMenu = ScannerUltis.inputIntPositive();
			switch (chooseMenu) {
			case 1:
				exercise1.question1();
				break;
			case 2:
				exercise1.question2();
				break;
			case 3:
				exercise1.question3();
				break;
			case 4:
				exercise1.question4();
				break;
			case 5:
				exercise1.question5();
				break;
			case 6:
				exercise1.question6();
				break;

			}
		}
	}
}
