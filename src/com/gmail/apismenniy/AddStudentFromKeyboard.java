package com.gmail.apismenniy;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddStudentFromKeyboard {
    public static Student addStudentFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

                System.out.println("Please enter name");
                student.setName(sc.nextLine());

                System.out.println("Please enter last name");
                student.setLastName(sc.nextLine());

                for (;;) {
                    try {
                        System.out.println("Please enter gender");
                        student.setGender(com.gmail.apismenniy.Gender.valueOf(sc.nextLine()));
                        break;
                    } catch
                    (IllegalArgumentException e) {
                        System.out.println("Please enter MALE or FEMALE");
                    }
                }

//                    System.out.println("Please enter group name");
//                    student.setGroupName(sc.nextLine());

                    for (;;) {
                        try {
                                System.out.println("Please enter ID");
                                student.setId(sc.nextLong());
                                break;
                        } catch
                        (InputMismatchException e) {
                            System.out.println("Please enter correct ID");
                        }
                    }
        return student;
    }

}

