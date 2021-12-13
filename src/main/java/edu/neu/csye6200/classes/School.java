package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class School {
    public static List<Classroom> classrooms;
    public static List<Person> studentlist;
    public static List<Person> teacherlist;

    private static final School instance = new School();
    private School (){
        classrooms = new ArrayList<>();
        teacherlist = new ArrayList<>();
        studentlist = new ArrayList<>();
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

    public static void removeStudent(Person student){studentlist.remove(student);}

    public static List<Person> getStudentsFromClassroom(Classroom classroom){
        List<Person> tmplist = new ArrayList<>();
        for (Person student:School.getStudentlist()){
            if (classroom.getName()==student.getClassroom().getName()){
                tmplist.add(student);
            }
        }
        return tmplist;
    }
    public static List<Person> getStudentsFromClassroom(String classroom){
        List<Person> tmplist = new ArrayList<>();
        for (Person student:School.getStudentlist()){
            if (classroom==student.getClassroom().getName()){
                tmplist.add(student);
            }
        }
        return tmplist;
    }

    public static List<Person> getStudentsUnderTeacher(Teacher teacher){
        List<Person> tmplist = new ArrayList<>();
        for (Person student:School.getStudentlist()){
            if (teacher.getClassroom().getName()==student.getClassroom().getName()){
                tmplist.add(student);
            }
        }
        return tmplist;

    }
    public static List<Person> getStudentsUnderTeacher(String teacher){
        List<Person> tmplist = new ArrayList<>();
        for (Person student:School.getStudentlist()){
            if (teacher==student.getClassroom().getTeacher().getName()){
                tmplist.add(student);
            }
        }
        return tmplist;

    }
}
