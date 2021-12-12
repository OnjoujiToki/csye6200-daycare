package edu.neu.csye6200.classes;

import edu.neu.csye6200.students.view.LoginView;
import utility.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Demo {
    public static List<Student> studentList = new ArrayList<>();
    static Vector<Person> teacherList = new Vector<>();
    FileUtil fileUtil = new FileUtil();
    public void run() {
        new LoginView();
        School.getInstance();
        String csvFile = fileUtil.readCSVFile("Students.csv");
         new Student(csvFile);
    }
//    public String readStudentsFromFile(){
//
//    }
    public List<Student> getStudentsList(){
        return studentList;
    }
    public static void addStudent(Student p){
        Demo.studentList.add(p);
    }
}
