package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classroom {
    public List<Student> studentList;
    public String name;
    public Teacher teacher;
    //Student(int id, int age, String name, String parent, String email, int math, int english, int chemistry, int physics, int java ,int music)
    public Classroom(String name, Teacher headTeacher) {
        this.name = name;
        studentList = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }

}
