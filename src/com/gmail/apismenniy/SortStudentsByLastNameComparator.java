package com.gmail.apismenniy;

import java.util.Comparator;

public class SortStudentsByLastNameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student studentOne = (Student) o1;
        Student studentTwo = (Student) o2;

        String lastNameOne = studentOne.getLastName();
        String lastNameTwo = studentTwo.getLastName();

        if(lastNameOne.compareTo(lastNameTwo)>0){
            return 1;
        }
        if(lastNameOne.compareTo(lastNameTwo)<0) {
            return -1;
        }
        return 0;
    }
}
