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
    public String[] dataToStringarray(){

        String[] tmp = new String[11];

        tmp[0] = String.valueOf(getId());
        tmp[1] = getName();
        tmp[2] = getParent();
        tmp[3] = String.valueOf(getAge());
        tmp[4] = getEmail();
        tmp[5] = String.valueOf(getMath());
        tmp[6] = String.valueOf(getEnglish());
        tmp[7] = String.valueOf(getChemistry());
        tmp[8] = String.valueOf(getPhysics());
        tmp[9] = String.valueOf(getJava());
        tmp[10] = String.valueOf(getMusic());

        return tmp;
    }

    public float getAverage(){
        return (this.getMath()+this.getEnglish()+this.getChemistry()+this.getPhysics()+this.getJava()+this.getMath())/6;
    }

    @Override
    public String toString() {
        StringBuilder outdata = new StringBuilder();

        outdata.append(" [ID]: # ").append(getId()).append(" [Name]:  ").append(getName()).append("\n");
        outdata.append(" [Age]: ").append(getAge()).append(" [Parent]: ").append(getParent()).append("\n");
        outdata.append(" [Average]: ").append(getAverage()).append("\n");

        return outdata.toString();
    }



}


