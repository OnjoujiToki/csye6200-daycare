package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
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
    public static List<Person> addObject(String csvFile) {
        String[] fileOutput = csvFile.split("\\r?\\n");
        Person tmpTeacher = null;
        List<Person> tmplist = new ArrayList<>();
        for (String inputLine : fileOutput) {
            Scanner input = new Scanner(inputLine);
            input.useDelimiter(",");
            int id = input.nextInt();
            String name = input.next();
            int age = input.nextInt();
            String email = input.next();
            int salary = input.nextInt();
            tmpTeacher = TeacherFactory.getObject(id, name, email, salary, age);
            tmplist.add(tmpTeacher);
        }
        return tmplist;
    }
    public static Person getObject(int id, String name, String email, int salary, int age){
        Person tmpteacher = new Teacher(id, email, name, salary, age);
        School.addTeacher(tmpteacher);
        return tmpteacher;
    }
}
