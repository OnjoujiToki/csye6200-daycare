package edu.neu.csye6200.classes;

public abstract class Person {
    private int id;
    private String email;
    private String name;
    abstract String getName();
    abstract int getId();
    abstract String getEmail();
}
