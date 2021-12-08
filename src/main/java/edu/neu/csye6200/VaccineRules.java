package edu.neu.csye6200;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class singleRule{
    String vaccineName;
    int size;
    List<LocalTime> timestmp = new ArrayList<LocalTime>();

}
public class VaccineRules {
    private static final VaccineRules instance = new VaccineRules();
    public static List<singleRule> rules;
    private VaccineRules(){}

    public VaccineRules getInstance() {
        return instance;
    }

    public static void printVaccineRules() {
        System.out.println("here to print vaccine rules.......");
    }
}
