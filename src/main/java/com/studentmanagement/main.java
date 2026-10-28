package com.studentmanagement;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        studentDAO dao = new studentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(name,age,course,email);


                    dao.addStudent(student);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int searchId =
                            Integer.parseInt(sc.nextLine());

                    dao.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int updateId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Age: ");
                    int newAge =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    dao.updateStudent(updateId, newName,
                            newAge, newCourse, newEmail);
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    int deleteId =
                            Integer.parseInt(sc.nextLine());

                    dao.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}