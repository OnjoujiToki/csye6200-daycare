package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Student extends Person{
    private String parent;
    private Grades grades;
    private Teacher teacher;
    StudentFactory factory = new StudentFactory();

    public Student(int id, String name, int age, String email,  String parent, Grades grades) {
        super(id, name, age, email);
        this.parent = parent;
        this.grades = grades;
    }

    public String getParent() {return parent;}
    public void setParent(String parent) {this.parent = parent;}

    public Teacher getTeacher() {return teacher;}
    public void setTeacher(Teacher teacher) {this.teacher = teacher;}

    public int getMath() {return grades.getMath();}
    public void setMath(int math) {grades.setMath(math);}

    public int getEnglish() {return grades.getEnglish();}
    public void setEnglish(int english) {grades.setEnglish(english);}

    public int getChemistry() {return grades.getChemistry();}
    public void setChemistry(int chemistry) {grades.setChemistry(chemistry);}

    public int getPhysics() {return grades.getPhysics();}
    public void setPhysics(int physics) {grades.setPhysics(physics);}

    public int getJava() {return grades.getJava();}
    public void setJava(int java) {grades.setJava(java);}

    public int getMusic() {return grades.getMusic();}
    public void setMusic(int music) {grades.setMusic(music);}


    public Student(String csvFile) {
        super();
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

    }


