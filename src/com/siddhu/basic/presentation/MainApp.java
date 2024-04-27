package com.siddhu.basic.presentation;

import java.util.Scanner;

public class MainApp {

	static {
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|                                  TEAM SPARK SCHOOL                                    |");
		System.out.println("+---------------------------------------------------------------------------------------+");
	}

	public static void main(String[] args) {
		Integer choice = 0;
		App app = new AppImpl();
		Scanner sc = new Scanner(System.in);
		while (choice != 7) {
			System.out.println(
					"-----------------------------------------------------------------------------------------\n");
			System.out.print("1. Insert Student\t\t");
			System.out.print("2. Update Student\t\t");
			System.out.print("3. Delete Student By Roll");
			System.out.print("\n\n4. Find Student By Roll No\t");
			System.out.print("5. Show All Students\t\t");
			System.out.print("6. Delete All Students\t\t");
			System.out.print("\n\n7. Exit Program");
			System.out.println("Enter Your Choice");
			System.out.println(
					"-----------------------------------------------------------------------------------------\n");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				app.insertStudent();
				break;

			case 2:
				app.updateStudent();
				break;

			case 3:
				app.deleteStudentByRoll();
				break;

			case 4:
				app.findStudentByRoll();
				break;

			case 5:
				app.showAllStudent();
				break;

			case 6:
				app.deleteAllStudents();
				break;

			case 7:
				System.out.println("User does not want to continue.");
				sc.close();
				break;
			default:
				System.out.println("Invalid option.");
			}
		}
	}

}
