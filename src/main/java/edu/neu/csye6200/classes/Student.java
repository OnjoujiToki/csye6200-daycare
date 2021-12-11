package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Student extends Person{
    private int id;
    private String name;
    private String parent;
    private String email;
    private int age;
    private int math;
    private int english;
    private int chemistry;
    private int physics;
    private int java;
    private int music;
    Vector<Person> studentsList = new Vector<>();
    StudentFactory factory = new StudentFactory();
    public Student(int id, String name, int age, String parent, String email, int math, int english, int chemistry, int physics, int java, int music) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.email = email;
        this.math = math;
        this.english = english;
        this.chemistry = chemistry;
        this.physics = physics;
        this.java = java;
        this.music = music;
        this.age = age;
    }
    public Student(String csvFile) {
        String[] fileOutput = csvFile.split("\\r?\\n");
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
            Demo.studentList.add(factory.getObject(id, name, age, parent, email, math, english, chemistry, physics, java, music));
            input.close();
        }
    }
    public String getName() {return this.name;}
    public int getId() {return this.id;}
    public String getParent() {return this.parent;}
    public String getEmail() {return this.email;}
    public int getMath() {return this.math;}
    public int getEnglish() {return this.english;}
    public int getPhysics() {return this.physics;}
    public int getJava() {return this.java;}
    public int getChemistry() {return this.chemistry;}
    public int getMusic() {return this.music;}
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public void setMusic(int music) {
        this.music = music;
    }
}
