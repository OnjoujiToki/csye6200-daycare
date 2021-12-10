package edu.neu.csye6200.classes;

import java.util.Vector;

public class School {
    public static Vector<Classroom> classrooms;
    //  Teacher (int id, String name, String email, int salary, int studentsNumber)
    private static final School instance = new School();
    private School (){
        classrooms = new Vector<Classroom>();
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
