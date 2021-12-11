package edu.neu.csye6200.classes;

import java.time.LocalDate;

public class Teacher extends Person{
    private int id;
    private String email;
    private String name;
    private int age;
    private int salary;
    private int studentsNumber;
    private LocalDate enterTime; // Time when teacher enter the school

    public Teacher(int id, String name, String email, int age, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    String getEmail() {
        return this.email;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    int getSalary(){
        return this.salary;
    }
    LocalDate getEnterTime() {
        return this.enterTime;
    }

}
