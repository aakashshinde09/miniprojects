package com.springcore.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.orm.dao.StudentDao;
import com.springcore.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/orm/Config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student = new Student(1, "Akash Shinde", "Pune"); int r =
		 * studentDao.insert(student); System.out.println("Done " + r);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			System.out.println("Press 1 to add new Student");
			System.out.println("Press 2 for Displaying all Students");
			System.out.println("Press 3 to Display single Student");
			System.out.println("Press 4 to Delete Student");
			System.out.println("Press 5 to Update Student");
			System.out.println("Press 6 to Exit");
			System.out.println();

			try {
				int input = Integer.parseInt(br.readLine());
				System.out.println();

				switch (input) {
				case 1:
					// add student
					System.out.println("Enter User Id : ");
					int uId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter User Name : ");
					String uName = br.readLine();
					
					System.out.println("Enter the City : ");
					String uCity = br.readLine();
					
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					int r = studentDao.insert(s);
					System.out.println("Student Added with Id "+r);
					System.out.println("---------------------------------------");
					System.out.println();
					break;

				case 2:
					// Display all Students
					List<Student> all = studentDao.getAllStudent();
					
					for(Student st : all) {
						System.out.println("Id : "+st.getStudentId());
						System.out.println("Name : "+st.getStudentName());
						System.out.println("City : "+st.getStudentCity());
						System.out.println("-----------------------------------------------------------------");
					}
					System.out.println("-----------------------------------------------");
					System.out.println();
					break;

				case 3:
					// Display single Student
					System.out.println("Enter User Id : ");
					int userId = Integer.parseInt(br.readLine());
					
					Student student = studentDao.getStudent(userId);
					System.out.println("Id : "+student.getStudentId());
					System.out.println("Name : "+student.getStudentName());
					System.out.println("City : "+student.getStudentCity());
					System.out.println("-----------------------------------------------------------------");
					System.out.println();
					
					break;

				case 4:
					// Delete Student
					System.out.println("Enter User Id : ");
					int stId = Integer.parseInt(br.readLine());
					
					studentDao.deleteStudent(stId);
					System.out.println("Student Deleted");
					System.out.println("---------------------------------------");
					System.out.println();
					break;

				case 5:
					// update student
					System.out.println("Enter User Id : ");
					int sId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter User Name : ");
					String sName = br.readLine();
					
					System.out.println("Enter the City : ");
					String sCity = br.readLine();
					
					Student su = new Student();
					su.setStudentId(sId);
					su.setStudentName(sName);
					su.setStudentCity(sCity);
					
					studentDao.updateStudent(su);
					
					System.out.println("Student Updated Successfully");
					System.out.println("-----------------------");
					System.out.println();
					
					break;

				case 6:
					// exit
					go = false;
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input Please try with another one !!");
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
		System.out.println("Thank You For Your Time");
		System.out.println("See You Soon......... !!");
	}
}
