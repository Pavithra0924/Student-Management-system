package studentmanangement.app;

import java.util.Scanner;

import studentmanagement.dao.StudentDAO;
import studentmanagement.model.Student;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\n=================================");
			System.out.println("   STUDENT MANAGEMENT SYSTEM");
			System.out.println("=================================");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Search Student by ID");
			System.out.println("4. Search Student by Name");
			System.out.println("5. Update Student");
			System.out.println("6. Delete Student");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			if (choice == 1) {

				sc.nextLine(); // Clears the Enter key

				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				if (name.trim().isEmpty()) {
					System.out.println("Name cannot be empty!");
					continue;
				}

				System.out.print("Enter Department: ");
				String department = sc.nextLine();

				System.out.print("Enter Email: ");
				String email = sc.nextLine();

				System.out.print("Enter Phone: ");
				String phone = sc.nextLine();
				if (phone.length() != 10) {
					System.out.println("Phone number must be 10 digits!");
					continue;
				}

				Student student = new Student(0, name, department, email, phone);

				StudentDAO dao = new StudentDAO();

				dao.addStudent(student);

			}

			else if (choice == 2) {

				StudentDAO dao = new StudentDAO();

				dao.viewStudents();

			}

			else if (choice == 3) {
				System.out.print("Enter Student ID: ");
				int id = sc.nextInt();

				StudentDAO dao = new StudentDAO();
				Student student = dao.searchStudent(id);

				if (student != null) {
					System.out.println("ID: " + student.getId());
					System.out.println("Name: " + student.getName());
					System.out.println("Department: " + student.getDepartment());
					System.out.println("Email: " + student.getEmail());
					System.out.println("Phone: " + student.getPhone());
				} else {
					System.out.println("Student not found!");
				}
			}

			else if (choice == 4) {

				sc.nextLine(); // Clear the Enter key

				System.out.print("Enter Student Name: ");
				String name = sc.nextLine();

				StudentDAO dao = new StudentDAO();

				Student student = dao.searchStudentByName(name);

				if (student != null) {
					System.out.println("ID : " + student.getId());
					System.out.println("Name : " + student.getName());
					System.out.println("Department : " + student.getDepartment());
					System.out.println("Email : " + student.getEmail());
					System.out.println("Phone : " + student.getPhone());
				} else {
					System.out.println("Student Not Found!");
				}
			}
			
			else if (choice == 5) {
				sc.nextLine();

				System.out.print("Enter Student ID to Update: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter New Name: ");
				String name = sc.nextLine();

				System.out.print("Enter New Department: ");
				String department = sc.nextLine();

				System.out.print("Enter New Email: ");
				String email = sc.nextLine();

				System.out.print("Enter New Phone: ");
				String phone = sc.nextLine();

				Student student = new Student(id, name, department, email, phone);

				StudentDAO dao = new StudentDAO();
				dao.updateStudent(student);
			}
			
			else if (choice == 6) {

			    System.out.print("Enter Student ID to Delete: ");
			    int id = sc.nextInt();

			    StudentDAO dao = new StudentDAO();
			    dao.deleteStudent(id);

			}


			else if (choice == 7) {
				System.out.println("Thank you for using Student Management System!");
				break;
			}

			System.out.println("You selected: " + choice);
		}
	}
}