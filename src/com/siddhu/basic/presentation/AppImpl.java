package com.siddhu.basic.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.siddhu.basic.model.Student;
import com.siddhu.basic.service.StudentService;
import com.siddhu.basic.service.StudentServiceImpl;
import com.siddhu.basic.validation.MyValidation;

public class AppImpl implements App {

	private StudentService studentService;
	private Student s;
	Scanner sc = new Scanner(System.in);

	AppImpl() {
		studentService = new StudentServiceImpl();
	}

	@Override
	public void insertStudent() {
		Boolean run = true;
		while (run) {
			Integer roll = null;
			String name = null;
			Boolean rollFlag = true;
			Boolean nameFlag = true;
			while (rollFlag) {
				System.out.print("Enter Roll no: ");
				roll = sc.nextInt();
				if (MyValidation.checkRoll(roll)) {
					rollFlag = false;
					while (nameFlag) {
						System.out.print("Enter Name: ");
						name = sc.next();
						if (MyValidation.checkName(name)) {
							nameFlag = false;
							s = new Student();
							s.setRoll(roll);
							s.setName(name);
							System.out.println(studentService.insertStudent(s));
							System.out.println("Do you want to add more record? [y/n]");
							Character c = sc.next().charAt(0);
							if (c.equals('n') || c.equals('N')) {
								System.out.println("Adding Records Terminated.");
								run = false;
								break;
							}

						} else {
							System.out.println("Name contains only Character\nplease type in correct form");
						}
					}
				} else {
					System.out.println("Number should be Positive");
				}
			}
		}

	}

	@Override
	public void updateStudent() {
		Boolean run = true;
		while (run) {
			Integer roll = null;
			String name = null;
			Boolean rollFlag = true;
			Boolean nameFlag = true;
			while (nameFlag) {
				System.out.print("Enter New Name: ");
				name = sc.next();
				if (MyValidation.checkName(name)) {
					nameFlag = false;
					while (rollFlag) {
						System.out.print("Enter roll u wanna Update: ");
						roll = sc.nextInt();
						if (MyValidation.checkRoll(roll)) {
							rollFlag = false;
							s = new Student();
							s.setName(name);
							s.setRoll(roll);
							System.out.println(studentService.updateStudent(s));
							System.out.println("Do you want to Update more record? [y/n]");
							Character c = sc.next().charAt(0);
							if (c.equals('n') || c.equals('N')) {
								System.out.println("Adding Records Terminated.");
								run = false;
								break;
							}

						} else {
							System.out.println("Roll Number should be Positive");
						}
					}

				} else {
					System.out.println("Enter Name in Correct formate...");
				}
			}
		}

	}

	@Override
	public void deleteStudentByRoll() {
		Boolean run = true;
		while (run) {
			Integer roll = null;
			Boolean rollFlag = true;
			while (rollFlag) {
				System.out.print("Enter Roll u wanna Delete: ");
				roll = sc.nextInt();
				if (MyValidation.checkRoll(roll)) {
					if (studentService.deleteStudentByRoll(roll) != null) {

						rollFlag = false;
						s = new Student();
						s.setRoll(roll);
						System.out.println(studentService.deleteStudentByRoll(roll));
						System.out.println("Do you want to Update more record? [y/n]");
						Character c = sc.next().charAt(0);
						if (c.equals('n') || c.equals('N')) {
							System.out.println("Deleting Records Terminated.");
							run = false;
							break;
						}
					} else {
						System.out.println("Id not found...");
						run = false;
						break;
					}
				} else {
					System.out.println("Roll Number should Positive");
				}
			}
		}

	}

	@Override
	public void findStudentByRoll() {
		Boolean run = true;
		while (run) {
			Boolean rollFlag = true;
			Integer roll = null;
			while (rollFlag) {
				System.out.print("Enter Roll: ");
				roll = sc.nextInt();
				if (MyValidation.checkRoll(roll)) {
					s = studentService.findStudentByRoll(roll);
					if (studentService.findStudentByRoll(roll) != null) {
						rollFlag = false;
						System.out.println("Roll no is: " + s.getRoll());
						System.out.println("Name is: " + s.getName());
						System.out.println("Do you want to Find more Students? [y/n]");
						Character c = sc.next().charAt(0);
						if (c.equals('n') || c.equals('N')) {
							System.out.println("Finding Records Terminated.");
							run = false;
							break;
						}
					} else {
						System.out.println("Record not found");
						run = false;
						break;
					}

				} else {
					System.out.println("Number should be Positive");
				}
			}
		}
	}

	@Override
	public void showAllStudent() {
		List<Student> list = studentService.showAllStudent();
		Iterator<Student> itr = list.listIterator();
		while (itr.hasNext()) {
			
			System.out.println("__________________________________________\n");
			Student s = itr.next();
			System.out.println("Roll no is: " + s.getRoll());
			System.out.println("Name is: " + s.getName());
			System.out.println("__________________________________________\n");
		}
		if (list.size()==0) {
			System.out.println("+-----------------------------------+");
			System.out.println("|           Zero Students           |");
			System.out.println("+-----------------------------------+");
		}
	}

	@Override
	public void deleteAllStudents() {
		System.out.println(studentService.deleteAllStudents());
	}

}
