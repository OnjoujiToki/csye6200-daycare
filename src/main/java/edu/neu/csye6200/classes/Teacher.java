package edu.neu.csye6200.classes;

import java.util.Vector;

public class Teacher extends Person{

    private int salary;

    public Teacher(int id, String email, String name, int age, int salary) {
        super(id, name, age, email);
        this.salary = salary;
    }

    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}

    public Vector<Person> getStudents(){
        Vector<Person> templist = new Vector<>();
        for(Person student:School.studentlist){
            if (student.getTeacher().getName()==this.getName()){
                templist.add(student);
            }
        }
        return templist;

    }

    @Override
    public String getParent() {return null;}
    @Override
    public void setParent(String parent) {}
    @Override
    public Teacher getTeacher() {return null;}
    @Override
    public void setTeacher(Teacher teacher) {}
}
