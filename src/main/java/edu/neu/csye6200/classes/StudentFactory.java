package edu.neu.csye6200.classes;

public class StudentFactory {
    public static Student getObject(int id, String name, int age, String parent, String email, int math, int english, int chemistry, int physics, int java, int music){
        return new Student(id, name, age, email, parent, new Grades(math, english, chemistry, physics, java, music));
    }
}
