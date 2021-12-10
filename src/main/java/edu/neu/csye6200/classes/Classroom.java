package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classroom {

    public Vector<Student> studentList;
    public Teacher teacher;
    //Student(int id, int age, String name, String parent, String email, int math, int english, int chemistry, int physics, int java ,int music)
    public Classroom(Teacher headTeacher) {
        studentList = new Vector<Student>();
       // studentList.add(new Student(1, "Zhihao Zhang", "Renai Zhang","z@moon.moe",100,100,100,100,59,100));
        this.teacher = headTeacher;

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

}
