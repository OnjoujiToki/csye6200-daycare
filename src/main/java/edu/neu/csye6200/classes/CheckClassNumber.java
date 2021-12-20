package edu.neu.csye6200.classes;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Scanner;

public class CheckClassNumber {

    private static int classroomsquantity;

    public static int getClassroomsquantity() {return classroomsquantity;}
    public static void setClassroomsquantity(int classroomsquantity) {CheckClassNumber.classroomsquantity = classroomsquantity;}

    public static int getQuantity() {

        StringBuilder csvFile = new StringBuilder();
        int inputLine = 0;
        try {
            Scanner inLine = new Scanner(new BufferedReader(new FileReader("numberofclassrooms.csv")));
            while (inLine.hasNextLine()) {
                inputLine = Integer.parseInt(inLine.nextLine());
            }
            inLine.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        int temp = Integer.parseInt(csvFile.toString());
        CheckClassNumber.setClassroomsquantity(inputLine);
        return inputLine;
    }

    public static void checkQuantity(){

        CheckClassNumber.setClassroomsquantity(School.getClassrooms().size());
    }
    public static void putQuantity (){

        File file = new File("numberofclassrooms.csv");
        try {
            FileWriter outputfile = new FileWriter(file);
            String[] tmp = new String[1];
            tmp[0]=(String.valueOf(CheckClassNumber.getClassroomsquantity()));

            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

                writer.writeNext(tmp);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

