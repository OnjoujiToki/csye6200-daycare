package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Student extends Person{
    private String parent;
    private Grades grades;
    private Classroom classroom;

    public Student(int id, String name, int age, String email,  String parent, Grades grades) {
        super(id, name, age, email);
        this.parent = parent;
        this.grades = grades;
    }

    public String getParent() {return parent;}
    public void setParent(String parent) {this.parent = parent;}

    public Classroom getClassroom() {return classroom;}
    public void setClassroom(Classroom classroom) {this.classroom = classroom;}

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

    public Person getTeacher(){
        for (Person teacher:School.getTeacherlist()){
            if (teacher.getClassroom().getName()==this.getClassroom().getName()){
                return teacher;
            }
        }
        return null;
    }




}


