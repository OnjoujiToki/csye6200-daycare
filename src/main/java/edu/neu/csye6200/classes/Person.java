package edu.neu.csye6200.classes;

public abstract class Person {

    private int id;
    private String email;
    private String name;
    private int age;

    public Person(int id,  String name, int age, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public abstract String getParent();
    public abstract void setParent(String parent);
    public abstract Teacher getTeacher();
    public abstract void setTeacher(Teacher teacher);
//    public abstract
}
