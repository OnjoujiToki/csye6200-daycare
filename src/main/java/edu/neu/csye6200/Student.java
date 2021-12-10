package edu.neu.csye6200;
import java.time.*;
import java.util.List;


public class Student {
    private int id;
    private int age;
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
    public String getName() {return this.name;}
    public int getId() {return this.id;}
    public int getAge() {return this.age;}
    public String getParent() {return this.parent;}

    public int getMath() {return this.math;}
    public int getEnglish() {return this.english;}
    public int getPhysics() {return this.physics;}
    public int getJava() {return this.java;}
    public int getChemistry() {return this.chemistry;}

}
