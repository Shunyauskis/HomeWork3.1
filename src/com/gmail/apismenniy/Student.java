package com.gmail.apismenniy;

import java.io.*;
import java.util.Scanner;

public class Student extends Human implements CSVConverter{
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
    public String toCSVString() {
        String delimiter = ";";
        File file = new File("Student.csv");

        String [] studentCsv = new String []{getName(), getLastName(), String.valueOf(getGender()), groupName, String.valueOf(id)};
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < studentCsv.length; i++) {
                pw.print(studentCsv[i]+delimiter);

            }
        }catch (IOException e){

        }
        return null;
    }

    @Override
    public Student fromCSVString() {
        File file = new File("Student_copy.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str= br.readLine();

            String [] csvList = str.split(";");
            for (int i = 0; i< csvList.length; i+=5){

                setName(csvList[i]);
                setLastName(csvList[i+1]);
                setGender(Gender.valueOf(csvList[i+2]));
                setGroupName(csvList[i+3]);
                setId(Long.parseLong(csvList[i+4]));
             }

            } catch (IOException e){
            System.out.println(e);
        }
        return new Student();
    }
}

