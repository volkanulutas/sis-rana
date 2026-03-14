package com.sis;

import com.sis.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystemV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice=0;
        List<Student> studentList = new ArrayList<>();

        do {
            System.out.println("1. Add new student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student record");
            System.out.println("4. List the students");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You are now in student adding system. \n Please enter the id.");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the age");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Student student = new Student(age,name,id);
                    studentList.add(student);
                    System.out.println("Added");
                    break;
                case 2:
                    System.out.println("You can now update a student");
                    break;
                case 3:
                    System.out.println("Choose the id you want to delete");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    int indexToDelete=-1;

                    Student deletedStudent = null;
                    for(int i =0; i<studentList.size();i++){
                       if(studentList.get(i).getId() == id ) {
                            indexToDelete = i;

                            deletedStudent = studentList.get(i);
                       }
                    }
                    if(indexToDelete!=-1)
                    {studentList.remove(indexToDelete);
                        System.out.println("Deleted: " + deletedStudent.toString());
                    }else{
                        System.out.println("No id match");
                    }
                    break;
                case 4:
                    if(studentList.size()!=0){for(Student s: studentList){
                        System.out.println(s.toString());
                    }}else{
                        System.out.println("No students were found.");
                    }
                    break;
                case 5:
                    System.out.println("You can exit");
                    break;
                default:
                    System.out.println("You can exit");
            }
        } while (choice != 5);

    }
}
