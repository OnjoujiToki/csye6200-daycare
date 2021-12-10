package edu.neu.csye6200;


public class Student extends AbstractPerson {

    private Teacher Teacher;
    private String Parent;
    public Grades Grades;

    public Student(int id, String name, int age, String email, String classroom, Teacher teacher, String parent, Grades grades) {
        super(id, name, age, email, classroom);
        this.Teacher = teacher;
        this.Parent = parent;
        this.Grades=grades;

    }

    public edu.neu.csye6200.Teacher getTeacher() {return Teacher;}
    public void setTeacher(edu.neu.csye6200.Teacher teacher) {Teacher = teacher;}

    public String getParent() {return Parent;}
    public void setParent(String parent) {Parent = parent;}


}
//    private int Math;
//    private int English;
//    private int Chemistry;
//    private int Physics;
//    private int Java;
//    private int Music;



//    public Student(int id, String name, int age, String email, String classroom, Teacher teacher, String parent, int math, int english, int chemistry, int physics,
//                   int java, int music) {
//        super(id, name, age, email, classroom);
//        this.Teacher = teacher;
//        this.Parent = parent;
//        this.Math = math;
//        this.English = english;
//        this.Chemistry = chemistry;
//        this.Physics = physics;
//        this.Java = java;
//        this.Music = music;
//    }

//    public int getMath() {return Math;}
//    public void setMath(int math) {Math = math;}
//
//    public int getEnglish() {return English;}
//    public void setEnglish(int english) {English = english;}
//
//    public int getChemistry() {return Chemistry;}
//    public void setChemistry(int chemistry) {Chemistry = chemistry;}
//
//    public int getPhysics() {return Physics;}
//    public void setPhysics(int physics) {Physics = physics;}
//
//    public int getJava() {return Java;}
//    public void setJava(int java) {Java = java;}
//
//    public int getMusic() {return Music;}
//    public void setMusic(int music) {Music = music;}
