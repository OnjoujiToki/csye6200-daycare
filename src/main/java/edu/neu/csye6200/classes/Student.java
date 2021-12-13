package edu.neu.csye6200.classes;
import java.time.*;
import java.util.List;


public class Student extends Person{
    private int id;
    private String name;
    private String parent;
    private String Email;
    private int math;
    private int english;
    private int chemistry;
    private int physics;
    private int java;
    private int music;
    public Student(int id, String name, String parent, String email, int math, int english, int chemistry, int physics, int java, int music) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.Email = email;
        this.math = math;
        this.english = english;
        this.chemistry = chemistry;
        this.physics = physics;
        this.java = java;
        this.music = music;
    }
<<<<<<< Updated upstream
    public String getName() {return this.name;}
    public int getId() {return this.id;}
    public String getParent() {return this.parent;}
    public String getEmail() {return this.Email;};
    public int getMath() {return this.math;}
    public int getEnglish() {return this.english;}
    public int getPhysics() {return this.physics;}
    public int getJava() {return this.java;}
    public int getChemistry() {return this.chemistry;}
    public int getMusic() {return this.music;}
}
=======

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

        String[] tmp = new String[10];

            tmp[0] = String.valueOf(getId());
            tmp[1] = getName();
            tmp[2] = getParent();
            tmp[3] = getEmail();
            tmp[4] = String.valueOf(getMath());
            tmp[5] = String.valueOf(getEnglish());
            tmp[6] = String.valueOf(getChemistry());
            tmp[7] = String.valueOf(getPhysics());
            tmp[8] = String.valueOf(getJava());
            tmp[9] = String.valueOf(getMusic());

         return tmp;
      }
    }




>>>>>>> Stashed changes
