package edu.neu.csye6200.classes;

public class Grades {

    private int math;
    private int english;
    private int chemistry;
    private int physics;
    private int java;
    private int music;

    public Grades(int math, int english, int chemistry, int physics, int java, int music) {
        this.math = math;
        this.english = english;
        this.chemistry = chemistry;
        this.physics = physics;
        this.java = java;
        this.music = music;
    }

    public int getMath() {return math;}
    public void setMath(int math) {this.math = math;}

    public int getEnglish() {return english;}
    public void setEnglish(int english) {this.english = english;}

    public int getChemistry() {return chemistry;}
    public void setChemistry(int chemistry) {this.chemistry = chemistry;}

    public int getPhysics() {return physics;}
    public void setPhysics(int physics) {this.physics = physics;}

    public int getJava() {return java;}
    public void setJava(int java) {this.java = java;}

    public int getMusic() {return music;}
    public void setMusic(int music) {this.music = music;}
}
