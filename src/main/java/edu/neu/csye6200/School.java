package edu.neu.csye6200;

import java.util.*;

public class School {

    private static final School instance = new School();

    private static Vector<Classroom> ClassroomList = new Vector<>();
    private static  Vector<Teacher> TeacherList = new Vector<>();
    private static Vector<Student> Students = new Vector<>();

    private static final School instance = new School();

    public static School getInstance( ) {
        return instance;
    }

    public static Vector<Classroom> getClassrooms() {
        return Classrooms;
    }
    public static void setClassrooms(Vector<Classroom> classrooms) {
        Classrooms = classrooms;
    }

    public static Vector<Teacher> getTeachers() {return Teachers;}
    public static void setTeachers(Vector<Teacher> teachers) {
        Teachers = teachers;
    }

    public static Vector<Student> getStudents() {
        return Students;
    }
    public static void setStudents(Vector<Student> students) {
        Students = students;
    }

    public static void addStudent(Student student){
        students.add(student);
    }
    public static void addTeacher(Teacher teacher){
        TeacherList.add(teacher);
    }
    public static void addClassroom(Classroom classroom){
        ClassroomList.add(classroom);
    }

}
