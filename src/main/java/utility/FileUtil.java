package utility;

import com.opencsv.CSVWriter;
import edu.neu.csye6200.classes.*;
import java.io.*;
import java.util.Scanner;

public class FileUtil {
    /*
     * writeCSVFile method takes items String array as input and write it to a file
     * i.e., creates a file
     */
    public void writeCSVFile(String[] items, String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for(String item : items) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * readCSVFile takes fileName as an input and reads file and returns String format of CSV
     */
    public String readCSVFile(String fileName){
        StringBuilder csvFile = new StringBuilder();
        try {
            Scanner inLine = new Scanner(new BufferedReader(new FileReader(fileName)));
            while(inLine.hasNextLine()) {
                String inputLine = inLine.nextLine();
                csvFile.append(inputLine).append("\n");
            }
            inLine.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return csvFile.toString();
    }

    public static void writeDataLineByLine(Classroom classroom, String fileName)
    {
        File file = new File(fileName);
        try {
            FileWriter outputfile = new FileWriter(file);

                    CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

           // String[] details = {classroom.getName(), classroom.getTeacher().getName()};
            //writer.writeNext(details);
            //String[] header = { "ID", "Name", "Parent", "Email", "Math", "English", "Chemistry", "Physics", "Java", "Music" };
            //writer.writeNext(header);

            for (Person student:classroom.getStudentList()){

                writer.writeNext(student.dataToStringarray());
            }

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

