package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFactory {
    public static Person getObject(int id, String name, int age, String parent, String email, int math, int english, int chemistry, int physics, int java, int music) {
        Person tmpstudent = new Student(id, name, age, email, parent, new Grades(math, english, chemistry, physics, java, music));
//        School.addStudent(tmpstudent);
        return tmpstudent;

    }

    public static List<Person> addObject(String csvFile) {
        String[] fileOutput = csvFile.split("\\r?\\n");
        Person tmpStudent = null;
        List<Person> tmplist = new ArrayList<>();
        for (String inputLine : fileOutput) {
            Scanner input = new Scanner(inputLine);
            input.useDelimiter(",");
            int id = input.nextInt();
            String name = input.next();
            int age = input.nextInt();
            String parent = input.next();
            String email = input.next();
            int math = input.nextInt();
            int english = input.nextInt();
            int chemistry = input.nextInt();
            int physics = input.nextInt();
            int java = input.nextInt();
            int music = input.nextInt();

            tmpStudent = StudentFactory.getObject(id, name, age, parent, email, math, english, chemistry, physics, java, music);
//            School.addStudent(tmpStudent);
            tmplist.add(tmpStudent);
        }
        return tmplist;
    }
}
