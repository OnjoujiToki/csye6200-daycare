package edu.neu.csye6200.classes;

import edu.neu.csye6200.students.view.LoginView;
import utility.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Demo {
//    public static List<Person> studentList = School.getStudentlist();
    static Vector<Person> teacherList = new Vector<>();
    FileUtil fileUtil = new FileUtil();
    public void run() {
        new LoginView();
        School.getInstance();

//        String studentCsvFile = fileUtil.readCSVFile("Students.csv");
//         StudentFactory.addObject(studentCsvFile);

        String teacherCsvFile = fileUtil.readCSVFile("Teachers.csv");
        TeacherFactory.getInstance().addObject(teacherCsvFile);

        for(Person teacher:School.getTeacherlist()){
            char i = 'A'; int j=1;
            String tmpname = "Classroom "+i;
            Classroom a = new Classroom("tmpname", (Teacher) teacher);
            String tmpfileName = "Students"+j+".csv";
            String studentCsvFile = fileUtil.readCSVFile("Students.csv");
            List<Person> tmplist = (List<Person>) StudentFactory.addObject(studentCsvFile);
            a.setStudentList(tmplist);
            for (Person student:tmplist){
                student.setClassroom(a);
            }
            i++;
        }


    }
//    public String readStudentsFromFile(){
//
//    }
//    public List<Person> getStudentsList(){
//        return studentList;
//    }
//    public static void addStudent(Person p){
//        Demo.studentList.add(p);
//    }
}
