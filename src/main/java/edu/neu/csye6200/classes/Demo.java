package edu.neu.csye6200.classes;

import edu.neu.csye6200.students.view.LoginView;
import utility.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Demo {
//    public static List<Person> studentList = School.getStudentlist();
    static Vector<Person> teacherList = new Vector<>();
    FileUtil fileUtil = new FileUtil();
    public void run() {
        new LoginView();
        School.getInstance();
        String studentCsvFile = fileUtil.readCSVFile("Students.csv");
         StudentFactory.addObject(studentCsvFile);
        String teacherCsvFile = fileUtil.readCSVFile("Teachers.csv");
        TeacherFactory.getInstance().addObject(teacherCsvFile);
        School.classrooms.add(new Classroom("ClassName", new Teacher(1, "ks@gmail.com", "Katherine", 23, 323)));
//        School.addTeacher(new Teacher(1, "asr@gmail.com", "dbshdh", 89, 1000));

    }
//    public String readStudentsFromFile(){
//
//    }
//    public List<Person> getStudentsList(){
//        return studentList;
//    }
//    public static void addStudent(Person p){
//        Demo.studentList.add(p);
//    }
}
