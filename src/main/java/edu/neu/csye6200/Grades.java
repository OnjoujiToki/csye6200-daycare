package edu.neu.csye6200;

public class Grades {

    private int Math;
    private int English;
    private int Chemistry;
    private int Physics;
    private int Java;
    private int Music;

    public Grades(int Math, int english, int chemistry, int physics, int java, int music) {
        English = english;
        Chemistry = chemistry;
        Physics = physics;
        Java = java;
        Music = music;
    }

    public int getMath() {return Math;}
    public void setMath(int math) {Math = math;}

    public int getEnglish() {return English;}
    public void setEnglish(int english) {English = english;}

    public int getChemistry() {return Chemistry;}
    public void setChemistry(int chemistry) {Chemistry = chemistry;}

    public int getPhysics() {return Physics;}
    public void setPhysics(int physics) {Physics = physics;}

    public int getJava() {return Java;}
    public void setJava(int java) {Java = java;}

    public int getMusic() {return Music;}
    public void setMusic(int music) {Music = music;}
}
