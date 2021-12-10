package edu.neu.csye6200.classes;

public abstract class Person {
    private int id;
    private String email;
    private String name;
    private int age;
    abstract String getName();
    abstract int getId();
    abstract String getEmail();
    public abstract void setId(int id);
    public abstract void setEmail(String email);
    public abstract void setName(String name);
    public abstract int getAge();
    public abstract void setAge(int age);
}
