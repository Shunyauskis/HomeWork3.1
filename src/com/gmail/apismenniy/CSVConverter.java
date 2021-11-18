package com.gmail.apismenniy;

public interface CSVConverter {

     public String toCSVFile();
     public Student fromCSVFile();

     public Student fromCSVString(String str);
     public String toCSVString();

}
