package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private static Classroom instance;
    public static List<Student> studentList;
    //Student(int id, int age, String name, String parent, String email, int math, int english, int chemistry, int physics, int java ,int music)
    private Classroom() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Zhihao Zhang", "Renai Zhang","z@moon.moe",100,100,100,100,59,100));
                //
    }
    public void printStudentsInformation() {
        if (studentList != null) {
            for (Student s:studentList) {
                System.out.println(s.getName());
            }
        }
        System.out.println("here it is classroom");

    }

    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }
    public static Classroom getInstance() {
        if (instance == null) {
            instance = new Classroom();
        }
        return instance;
    }
}
