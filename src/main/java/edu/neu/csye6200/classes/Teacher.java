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

//    public Vector<Person> getStudents(){
//        Vector<Person> templist = new Vector<>();
//        for(Person student:School.studentlist){
//            if (student.getTeacher().getName()==this.getName()){
//                templist.add(student);
//            }
//        }
//        return templist;
//
//    }

    @Override public String getParent() {return null;}
    @Override public void setParent(String parent) {}
    @Override public int getMath() {return 0;}
    @Override public void setMath(int math) {}
    @Override public int getEnglish() {return 0;}
    @Override public void setEnglish(int english) {}
    @Override public int getChemistry() {return 0;}
    @Override public void setChemistry(int chemistry) {}
    @Override public int getPhysics() {return 0;}
    @Override public void setPhysics(int physics) {}
    @Override public int getJava() {return 0;}
    @Override public void setJava(int javava) {}
    @Override public int getMusic() {return 0;}
    @Override public void setMusic(int music) {}
    @Override public Classroom getClassroom() {return null;}
    @Override public void setClassroom(Classroom classroom) {}

//    @Override
//    public Teacher getTeacher() {return null;}
//    @Override
//    public void setTeacher(Teacher teacher) {}
}
