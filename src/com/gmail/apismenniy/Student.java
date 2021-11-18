package com.gmail.apismenniy;

import java.io.*;
import java.util.Scanner;

public class Student extends Human implements CSVConverter {
    private String groupName;
    private long id;

    public Student() {
        super();
    }

    public Student(String name, String lastName, Gender gender, String groupName, long id) {
        super(name, lastName, gender);
        this.groupName = groupName;
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                '\'' +
                "id=" + id + super.toString() + '}';
    }

    @Override
    public String toCSVFile() {
        String delimiter = ";";
        File file = new File("Student.csv");

        String[] studentCsv = new String[]{getName(), getLastName(), String.valueOf(getGender()), groupName, String.valueOf(id)};
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < studentCsv.length; i++) {
                pw.print(studentCsv[i] + delimiter);

            }
        } catch (IOException e) {

        }
        return null;
    }

    @Override
    public Student fromCSVFile() { // метод считывает поля из файла и на их основе создает студента
        File file = new File("Student_copy.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = br.readLine();

            String[] csvList = str.split(";");
            for (int i = 0; i < csvList.length; i += 5) {

                setName(csvList[i]);
                setLastName(csvList[i + 1]);
                setGender(Gender.valueOf(csvList[i + 2]));
                setGroupName(csvList[i + 3]);
                setId(Long.parseLong(csvList[i + 4]));
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return new Student();
    }

    @Override
    public Student fromCSVString(String str) { // метод считывает поля из строки и на их основе создает студента
        String[] strng = str.split(";");
        for (int i = 0; i < strng.length; i+=5) {

            setName(strng[i]);
            setLastName(strng[i + 1]);
            setGender(Gender.valueOf(strng[i + 2]));
            setGroupName(strng[i + 3]);
            setId(Long.parseLong(strng[i + 4]));
        }

        return new Student(getName(), getLastName(), getGender(), getGroupName(), getId());
    }

    @Override
    public String toCSVString() { // метод считывает поля студента и возвращает строку в CSV формате
        String delimiter = ";";
        String str = "";

        String[] studentCsv = new String[]{getName(), getLastName(), String.valueOf(getGender()), groupName, String.valueOf(id)};

        for (int i = 0; i < studentCsv.length; i++) {
            str = str + (studentCsv[i] + delimiter);

        }
        return str;
    }

}

