package edu.neu.csye6200;
import java.time.*;
import java.util.List;
import java.util.Locale;

class VaccineStatus{
    public List<LocalDate> status;
    public int dozeSize;
}
public class Student {
    private int id;
    private int age;
    private int ageMonth;
    private String name;
    private String parent;
    private String address;
    private LocalDate birthday;
    private VaccineStatus hib;
    private VaccineStatus datp;
    private VaccineStatus polio;
    private VaccineStatus hepatitis;
    private VaccineStatus mmr;
    private VaccineStatus varicella;

    public boolean checkHib() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkDatp() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkPolio() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkHepatitis() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkMmr() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public boolean checkVaricella() {
        LocalDate today = LocalDate.now();
        return false;
    }

    public String getName() {return this.name;}
    public int getId() {return this.id;}
    public int getAge() {return this.age;}
    public String getParent() {return this.parent;}
    public String getAddress() {return this.address;}

}
