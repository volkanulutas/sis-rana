package com.sis;

import com.sis.EnhanceUserExperience.Colors;
import com.sis.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystemV2 {

    public static void printMenu() {
        System.out.println(Colors.BLUE + "[1]" + Colors.RESET + " " + Colors.YELLOW + "Add new student" + Colors.RESET);
        System.out.println(Colors.BLUE + "[2]" + Colors.RESET + " " + Colors.YELLOW + "Update student" + Colors.RESET);
        System.out.println(Colors.BLUE + "[3]" + Colors.RESET + " " + Colors.YELLOW + "Delete student record" + Colors.RESET);
        System.out.println(Colors.BLUE + "[4]" + Colors.RESET + " " + Colors.YELLOW + "List the students" + Colors.RESET);
        System.out.println(Colors.BLUE + "[5]" + Colors.RESET + " " + Colors.YELLOW + "Exit" + Colors.RESET);
    }

    public static Student updateStudent(int id, List<Student> studentList) {
        String newName = "X";
        int newAge = 0;
        Scanner scanner = new Scanner(System.in);
        int index = findStudentIndex(id, studentList);
        if (index == -1) {
            System.out.println(Colors.RED + "No student match found to update." + Colors.RESET);
            return null;
        } else {
            System.out.println("To update the name press 1, to update the age press 2");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();

            if (updateChoice == 1) {
                System.out.println("Please enter the new name.");
                newName = scanner.nextLine();

            } else if (updateChoice == 2) {
                System.out.println("Please enter the new age");
                newAge = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(Colors.RED + "Please enter a valid number." + Colors.RESET);
                //It should repeat itself from here
            }
            if (updateChoice == 2) {
                studentList.get(index).setAge(newAge);
            } else if (updateChoice == 1) {
                studentList.get(index).setName(newName);
            }
            return studentList.get(index);
        }


    }

    public static boolean deleteStudent(int id, List<Student> studentList) {
        int indexToDelete = findStudentIndex(id, studentList);
        if (indexToDelete != -1) {
            System.out.println("Deleted: \n  " + studentList.get(indexToDelete).getName());
            studentList.remove(indexToDelete);
            return true;
        } else {
            System.out.println("No id match");
            return false;
        }
    }

    public static int findStudentIndex(int studentId, List<Student> studentList) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == studentId) {
                index = i;
            }
        }
        return index;
    }

    public static void listStudents(List<Student> studentList) {
        if (studentList.size() != 0) {
            System.out.println("ID      NAME        AGE\n" +
                    "-----------------------");
            for (Student s : studentList) {
                System.out.println(s.showOnlyDetails());
            }
        } else {
            System.out.println(Colors.RED + "No students were found." + Colors.RESET);
        }
    }

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Colors.RED + " -----student adding system---- \n" + Colors.RESET + "Please enter the ID.");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        System.out.println("Please enter the age");
        int age = scanner.nextInt();
        scanner.nextLine();
        Student student = new Student(age, name, id);
        return student;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        List<Student> studentList = new ArrayList<>();
        System.out.println(Colors.RED + "Welcome to SIS. Please proceed accordingly.");
        do {
            printMenu();

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Student student = createStudent();
                    studentList.add(student);
                    System.out.println(Colors.RED + "------" + student.getName() + " was added---------" + Colors.RESET);
                    break;
                case 2:
                    if (studentList.isEmpty()) {
                        System.out.println(Colors.RED + "No students were found to update." + Colors.RESET);
                        break;
                    }
                    System.out.println(Colors.RED + "-----student update system----- \n" + Colors.RESET + "Write the ID you want to update");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Student updatedStudent = updateStudent(id, studentList);
                    if(updatedStudent!=null){
                        System.out.println(id + "  is successfully updates." );
                    }

                case 3:
                    if (!studentList.isEmpty()) {
                        System.out.println("Choose the id you want to delete");
                        int idToDelete = scanner.nextInt();
                        scanner.nextLine();
                        boolean isDeleted = deleteStudent(idToDelete, studentList);
                        if (isDeleted) {
                            System.out.println(idToDelete + "is deleted succesfully,");
                        } else {
                            System.out.println("Can not delete " + idToDelete);
                        }
                    } else {
                        System.out.println(Colors.RED + "No students were found to delete." + Colors.RESET);
                    }
                    break;
                case 4:
                    listStudents(studentList);
                    break;
                case 5:
                    exitSystem();
                    break;
                default:
                    System.out.println(Colors.RED + "Please press a valid number." + Colors.RESET);
            }
        } while (choice != 5);

    }

    private static void exitSystem() {
        System.out.println("Exitting...");
        System.exit(0);
    }
}
