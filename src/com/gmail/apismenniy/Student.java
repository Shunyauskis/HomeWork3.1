package com.gmail.apismenniy;

import java.util.Scanner;

public class Student extends Human{
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

}
