package edu.neu.csye6200;

public abstract class AbstractPerson {

    private int Id;
    private String Name;
    private int Age;
    private String Email;
    private String Classroom;

    public AbstractPerson(int id, String name, int age, String email, String classroom) {
        this.Id = id;
        this.Name = name;
        this.Age = age;
        this.Email = email;
        Classroom = classroom;
    }

    public int getId() {return Id;}
    public void setId(int id) {this.Id = id;}

    public String getName() {return Name;}
    public void setName(String name) {this.Name = name;}

    public int getAge() {return Age;}
    public void setAge(int age) {this.Age = age;}

    public String getEmail() {return Email;}
    public void setEmail(String email) {this.Email = email;}

    public String getClassroom() {return Classroom;}
    public void setClassroom(String classroom) {Classroom = classroom;}

}


