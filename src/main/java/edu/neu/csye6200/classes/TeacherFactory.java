package edu.neu.csye6200.classes;

import java.util.Scanner;

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
    public static Person addObject(String csvFile) {
        String[] fileOutput = csvFile.split("\\r?\\n");
        Person tmpTeacher = null;
        for (String inputLine : fileOutput) {
            Scanner input = new Scanner(inputLine);
            input.useDelimiter(",");
            int id = input.nextInt();
            String name = input.next();
            int age = input.nextInt();
            String email = input.next();
            int salary = input.nextInt();
            tmpTeacher = TeacherFactory.getObject(id, name, email, salary, age);
            School.addTeacher(tmpTeacher);
        }
        return tmpTeacher;
    }
    public static Teacher getObject(int id, String name, String email, int salary, int age){
        return new Teacher(id, name, email, salary, age);
    }
}
