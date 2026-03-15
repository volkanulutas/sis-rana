package com.sis;

import com.sis.EnhanceUserExperience.Colors;
import com.sis.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystemV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        List<Student> studentList = new ArrayList<>();
        System.out.println(Colors.RED + "Welcome to SIS. Please proceed accordingly.");
        do {
            System.out.println(Colors.BLUE + "[1]" + Colors.RESET + " " + Colors.YELLOW + "Add new student" + Colors.RESET);
            System.out.println(Colors.BLUE + "[2]" + Colors.RESET + " " + Colors.YELLOW + "Update student" + Colors.RESET);
            System.out.println(Colors.BLUE + "[3]" + Colors.RESET + " " + Colors.YELLOW + "Delete student record" + Colors.RESET);
            System.out.println(Colors.BLUE + "[4]" + Colors.RESET + " " + Colors.YELLOW + "List the students" + Colors.RESET);
            System.out.println(Colors.BLUE + "[5]" + Colors.RESET + " " + Colors.YELLOW + "Exit" + Colors.RESET);

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(Colors.RED + " -----student adding system---- \n" + Colors.RESET + "Please enter the ID.");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the age");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    Student student = new Student(age, name, id);
                    studentList.add(student);
                    System.out.println(Colors.RED + "------" + name + " was added---------" + Colors.RESET);
                    break;
                case 2:

                    if (!studentList.isEmpty()) {
                        int currentIndex = -1;
                        String newName = "X";
                        Student updateThisStudent = null;
                        int newAge = 0;
                        System.out.println(Colors.RED + "-----student update system----- \n" + Colors.RESET + "Write the ID you want to update");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        int updateChoice = 0;
                        boolean isUpdateFound = false;
                        for (int i = 0; i < studentList.size(); i++) {

                            currentIndex = i;
                            if (studentList.get(i) != null && (studentList.get(i).getId() == id)) {
                                isUpdateFound = true;
                                System.out.println("To update the name press 1, to update the age press 2");
                                updateChoice = scanner.nextInt();
                                scanner.nextLine();
                                updateThisStudent = studentList.get(i);
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
                                    updateThisStudent.setAge(newAge);
                                } else if (updateChoice == 1) {
                                    updateThisStudent.setName(newName);
                                }
                            }
                        }
                        if (!isUpdateFound) {
                            System.out.println(Colors.RED + "No student match found to update." + Colors.RESET);
                        }

                    } else {
                        System.out.println(Colors.RED + "No students were found to update." + Colors.RESET);
                    }
                    break;


                case 3:
                    if (studentList.isEmpty() == false) {
                        System.out.println("Choose the id you want to delete");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        int indexToDelete = -1;

                        Student deletedStudent = null;
                        for (int i = 0; i < studentList.size(); i++) {
                            if (studentList.get(i).getId() == id) {
                                indexToDelete = i;

                                deletedStudent = studentList.get(i);
                            }
                        }
                        if (indexToDelete != -1) {
                            studentList.remove(indexToDelete);
                            System.out.println("Deleted: \n  " + deletedStudent.toString());
                        } else {
                            System.out.println("No id match");
                        }
                    } else {
                        System.out.println(Colors.RED + "No students were found to delete." + Colors.RESET);
                    }
                    break;
                case 4:
                    if (studentList.size() != 0) {
                        System.out.println("ID      NAME        AGE\n" +
                                "-----------------------");
                        for (Student s : studentList) {
                            System.out.println(s.showOnlyDetails());
                        }
                    } else {
                        System.out.println(Colors.RED + "No students were found." + Colors.RESET);
                    }
                    break;
                case 5:
                    System.out.println("You can exit");
                    break;
                default:
                    System.out.println(Colors.RED + "Please press a valid number." + Colors.RESET);
            }
        } while (choice != 5);

    }
}
