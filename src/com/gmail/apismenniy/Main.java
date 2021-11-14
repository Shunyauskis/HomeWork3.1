package com.gmail.apismenniy;

public class Main {

    public static void main(String[] args) throws GroupOverflowException, NoSuchStudentException {

        Student studentOne = new Student("Petya", "Petechkin", Gender.MALE, "Economical", 566781L);
        Student studentTwo = new Student("Vasya", "Vasichkin", Gender.MALE, "Economical", 566782L);
        Student studentThree = new Student("Valera", "Kovalskiy", Gender.MALE, "Economical", 566783L);
        Student studentFour = new Student("Masha", "Rasputina", Gender.FEMALE, "Economical", 566784L);
        Student studentFive = new Student("Silvestr", "Stallone", Gender.MALE, "Economical", 566785L);
        Student studentSix = new Student("Megan", "Fox", Gender.FEMALE, "Economical", 566786L);
        Student studentSeven = new Student("Antonio", "Banderos", Gender.MALE, "Economical", 566787L);
        Student studentEight = new Student("Khristina", "Orbakayte", Gender.FEMALE, "Economical", 566788L);
        Student studentNine = new Student("Mike", "Tyson", Gender.MALE, "Economical", 566789L);
        Student studentTen = new Student("Pamela", "Anderson", Gender.FEMALE, "Economical", 566790L);
        Student studentEleven = new Student("Alla", "Pugacheva", Gender.FEMALE, "Economical", 566791L);
        Student studentTwelve = new Student("Denzel", "Washington", Gender.MALE, "Economical", 566792L);



        Group economical = new Group("economical");

        economical.addStudent(studentOne);
        economical.addStudent(studentTwo);
        economical.addStudent(studentThree);
        economical.addStudent(studentFour);
        economical.addStudent(studentFive);
        economical.addStudent(studentSix);
        economical.addStudent(studentSeven);
        economical.addStudent(studentEight);
        economical.addStudent(studentNine);
        economical.addStudent(studentTen);
//        economical.addStudent(studentEleven);
//        economical.addStudent(studentTwelve);
//        economical.addStudent(AddStudentFromKeyboard.addStudentFromKeyboard());


        System.out.println();
        System.out.println(economical.toString());

        economical.sortStudentsByLastName();
        System.out.println(economical.toString());

        System.out.println("Searched student is "+economical.searchByLastName("Tyson"));
        System.out.println();

        economical.deleteStudent(566789);
        System.out.println(economical.toString());

    }

}
