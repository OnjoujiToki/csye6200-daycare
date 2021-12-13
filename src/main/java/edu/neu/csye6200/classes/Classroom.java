package edu.neu.csye6200.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Classroom {

    private String name;
    private Person teacher;
    private List<Person> studentList = new ArrayList<>();

    public Classroom(String name, Teacher headTeacher) {
        this.name = name;
        studentList = new ArrayList<>();
        this.teacher = headTeacher;
    }

    public Classroom(){
       int i = School.getClassrooms().size()+65;
       int j = School.getClassrooms().size();
       char l = (char)i;
       this.name="Classroom "+l;
       studentList=new ArrayList<>();
       this.teacher=School.getTeacherlist().get(j);
    }
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

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   public void addStudent(Person newStudent) {
        studentList.add(newStudent);
    }
    public void setTeacher(Teacher newTeacher) {
        this.teacher=newTeacher;
    }

    public String getName(){return this.name;}
    public Person getTeacher(){return this.teacher;}
    public List<Person> getStudentList(){return this.studentList;}
    public void setStudentList(List<Person> studentList) {this.studentList = studentList;}


}
