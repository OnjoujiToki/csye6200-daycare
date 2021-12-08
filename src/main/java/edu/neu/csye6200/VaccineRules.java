package edu.neu.csye6200;

class singleRule{
    String vaccineName;

}
public class VaccineRules {
    private static final VaccineRules instance = new VaccineRules();

    private VaccineRules(){}

    public VaccineRules getInstance() {
        return instance;
    }

    public void printVaccineRules() {
        System.out.println("here to print vaccine rules.......");
    }
}
