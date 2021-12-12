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

    public abstract Classroom getClassroom();
    public abstract void setClassroom(Classroom classroom);
    public abstract String getParent();
    public abstract void setParent(String parent);
    public abstract int getMath();
    public abstract void setMath(int math);
    public abstract int getEnglish();
    public abstract void setEnglish(int english);
    public abstract int getChemistry();
    public abstract void setChemistry(int chemistry);
    public abstract int getPhysics();
    public abstract void setPhysics(int physics);
    public abstract int getJava();
    public abstract void setJava(int javava);
    public abstract int getMusic();
    public abstract void setMusic(int music);
    public int getSalary(){return 0;};
    public void setSalary(int salary){};
//    public abstract
}
