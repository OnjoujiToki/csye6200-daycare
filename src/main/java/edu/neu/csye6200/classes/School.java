package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class School {
    public static List<Classroom> classrooms;
    public static List<Teacher> teachers;
    //  Teacher (int id, String name, String email, int salary, int studentsNumber)
    private static final School instance = new School();
    private School (){
        classrooms = new ArrayList<>();
        teachers = new ArrayList<>();
    }
    public static School getInstance( ) {
        return instance;
    }
    // new Classroom(new Teacher(0, "First Teacher", "firstteacher@email", 20000, 0));
    //
    public void printClassroominformation( ) {
        for (Classroom C: classrooms) {
            System.out.print(C.teacher.getName());
        }
    }

}
