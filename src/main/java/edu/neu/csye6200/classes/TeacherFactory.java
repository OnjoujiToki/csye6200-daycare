package edu.neu.csye6200.classes;

public class TeacherFactory {
    private static TeacherFactory instance;

    private TeacherFactory(){
        instance = null;
    }

    public static synchronized TeacherFactory getInstance(){
        if(instance == null){
            instance = new TeacherFactory();
        }
        return instance;
    }

    public Teacher getObject(int id, String name, String email, int salary, int studentsNumber){
        return new Teacher(id, name, email, salary, studentsNumber);
    }
}
