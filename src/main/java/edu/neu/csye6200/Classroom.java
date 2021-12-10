package edu.neu.csye6200;

import java.util.*;

public class Classroom {

    private static Teacher Teacher;
    private static Vector<Student> Students = new Vector<>();

    public Classroom(edu.neu.csye6200.Teacher teacher) {
        this.Teacher=teacher;
    //    this.Students=students;
    }

    public static edu.neu.csye6200.Teacher getTeacher() {return Teacher;}
    public static void setTeacher(edu.neu.csye6200.Teacher teacher) {Teacher = teacher;}

    public void addStudent(Student newStudent) {
        Students.add(newStudent);
    }

}
