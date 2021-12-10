package edu.neu.csye6200;

public class PersonFactory {

    public static Student createstudent(int id, String name, int age, String email, String classroom, Teacher teacher, String parent, int math, int english, int chemistry, int physics, int java, int music) {

        return new Student(id,  name,  age,  email,  classroom,  teacher,  parent, new Grades(math,english,chemistry, physics,java,music));
//        super(id, name, age, email, classroom);
//        this.Teacher = teacher;
//        this.Parent = parent;
//        this.Math = math;
//        this.English = english;
//        this.Chemistry = chemistry;
//        this.Physics = physics;
//        this.Java = java;
//        this.Music = music;
    }
    public Teacher createteacher(int id, String name, int age, String email, String classroom, String subject, String homeroom, String level, int salary){
        return new Teacher( id,  name,  age,  email,  classroom,  subject,  homeroom,  level,  salary);
    }


}
