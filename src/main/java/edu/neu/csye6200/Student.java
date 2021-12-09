package edu.neu.csye6200;
import java.time.*;
import java.util.List;


public class Student {
    private int id;
    private int age;
    private String name;
    private String parent;
    private String address;
    private String Email;
    private int math;
    private int english;
    private int chemistry;
    private int physics;
    private int java;
    private int music;


    public boolean checkHib() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkDatp() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkPolio() {
        LocalDate today = LocalDate.now();

        return false;
    }

    public boolean checkHepatitis() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkMmr() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkVaricella() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public String getName() {return this.name;}
    public int getId() {return this.id;}
    public int getAge() {return this.age;}
    public String getParent() {return this.parent;}
    public String getAddress() {return this.address;}
    public int getMath() {return this.math;}
    public int getEnglish() {return this.english;}
    public int getPhysics() {return this.physics;}
    public int getJava() {return this.java;}
    public int getChemistry() {return this.chemistry;}

}
