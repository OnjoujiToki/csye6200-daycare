package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classroom {

    private String name;
    private Teacher teacher;
    private List<Person> studentList = new ArrayList<>();

    public Classroom(Teacher headTeacher) {
        this.teacher = headTeacher;
    }
    public void printStudentsInformation() {
        if (studentList != null) {
            for (Person s:studentList) {
                System.out.println(s.getName());
            }
        }
        System.out.println("here it is classroom");

    }

    public void addStudent(Person newStudent) {
        studentList.add(newStudent);
    }
    public void setTeacher(Teacher newTeacher) {
        this.teacher=newTeacher;
    }

    public String getName(){return this.name;}
    public Teacher getTeacher(){return this.teacher;}
    public List<Person> getStudentList(){return this.studentList;}


}
