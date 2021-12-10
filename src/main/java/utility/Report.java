package utility;

import edu.neu.csye6200.Student;

public class Report {

    public String GenerateStudentReport(Student student){

        StringBuilder outdata = new StringBuilder();

        outdata.append(" [ID]: # ").append(student.getId()).append("\n");
        outdata.append(" [Name]: ").append(student.getName()).append(" ");
        outdata.append(" [Age]: ").append(student.getAge()).append("\n");
        outdata.append(" [Classroom]: ").append(student.getClassroom()).append("\n");
        outdata.append("################## GRADES ##################").append("\n");




        return outdata.toString();
    }

}

