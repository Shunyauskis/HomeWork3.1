package com.gmail.apismenniy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group {
    private Student [] students = new Student[10];
    private String groupName;

    public Group() {
        super();
    }
    public Group(String groupName){
        this.groupName = groupName;
    }

    public Group(Student[] students, String groupName) {
        this.students = students;
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        String student = "";

        for (int i = 0; i<students.length; i++){
            student = student + students[i] + '\n';
        }
        return groupName + '\n' + student;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        int counter = 1;
        for (int i = 0; i<students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            } counter++;
            if (counter>students.length) {
                throw new GroupOverflowException("The group is full");
                }
            }
        }


    public Student deleteStudent(long id) {
        for (int i = 0; i<students.length; i++){
            if(students[i].getId() == id){
                students[i] = null;
            }
        }
        return null;
    }

    public Student searchByLastName(String lastName) throws NoSuchStudentException {

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && lastName.equals(students[i].getLastName())) {
                    return students[i];
                } else {throw new NoSuchStudentException("No such student");
                }
            }
        return null;
    }
    public void sortStudentsByLastName(){
        Arrays.sort(students, Comparator.nullsFirst (new SortStudentsByLastNameComparator()));
    }
    public void studentFromKeyboard() throws GroupOverflowException{
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        int counter = 1;
        for (int i = 0; i<students.length; i++) {
            if (students[i] == null) {
                students[i] = student;

                System.out.println("Please enter name");
                student.setName(sc.nextLine());

                System.out.println("Please enter last name");
                student.setLastName(sc.nextLine());

                for (;;) {
                    try {

                        System.out.println("Please enter gender");
                        student.setGender(com.gmail.apismenniy.Gender.valueOf(sc.nextLine()));

                    } catch
                    (IllegalArgumentException e) {
                        System.out.println("Please enter MALE or FEMALE");

                    }break;

                }

                    System.out.println("Please enter group name");
                    student.setGroupName(sc.nextLine());

                    System.out.println("Please enter ID");
                    student.setId(sc.nextLong());

                counter++;
                if (counter > students.length) {
                    throw new GroupOverflowException("The group is full");
                }
            }

        }

    }
}

