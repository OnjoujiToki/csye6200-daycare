package edu.neu.csye6200.classes;

import java.time.LocalDate;

public class Teacher extends Person{
    private int id;
    private String email;
    private String name;
    private int salary;
    private int studentsNumber;
    private LocalDate enterTime; // Time when teacher enter the school

    public Teacher(int id, String name, String email, int salary, int studentsNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.studentsNumber = studentsNumber;
    }
    @Override
    String getName() {
        return this.name;
    }

    @Override
    int getId() {
        return this.id;
    }

    @Override
    String getEmail() {
        return this.email;
    }
    int getSalary(){
        return this.salary;
    }
    LocalDate getEnterTime() {
        return this.enterTime;
    }


}
