package edu.neu.csye6200.classes;

import java.util.List;
import java.util.Vector;

public class School {
    public static List<Classroom> classrooms;
    public static List<Person> studentlist;
    public static List<Person> teacherlist;


    private static final School instance = new School();
    private School (){
        classrooms = new Vector<Classroom>();
    }
    public static School getInstance( ) {
        return instance;
    }

    public void printClassroominformation( ) {
        for (Classroom C: classrooms) {
            System.out.print(C.getTeacher().getName());
        }
    }

    public static void addStudent(Person person){studentlist.add(person);}
    public static void addTeacher(Person person){teacherlist.add(person);}
    public static void addClassroom(Classroom classroom){classrooms.add(classroom);}

    public static List<Classroom> getClassrooms() {return classrooms;}
    public static List<Person> getStudentlist() {return studentlist;}
    public static List<Person> getTeacherlist() {return teacherlist;}
}
