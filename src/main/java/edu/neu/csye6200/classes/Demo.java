package edu.neu.csye6200.classes;

import edu.neu.csye6200.students.view.LoginView;
import utility.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Demo {

    public void run() {
        FileUtil fileUtil = new FileUtil();
        new LoginView();
        School.getInstance();
        String teacherCsvFile = fileUtil.readCSVFile("Teachers.csv");
        TeacherFactory.getInstance().addObject(teacherCsvFile);

        int numberOfClassrooms = 2; //Change this for changing number of initialised objects

        for (int k = 0, j = 1, i=65; k < numberOfClassrooms; k++, j++, i++) {
            char l =(char)i;
            String tmpname = "Classroom " + l;
            Classroom a = new Classroom(tmpname, (Teacher) School.getTeacherlist().get(k));
            School.addClassroom(a);
            System.out.println(j);
            String tmpfileName = "Students" + j + ".csv";
            String studentCsvFile = fileUtil.readCSVFile(tmpfileName);
            List<Person> tmplist = (StudentFactory.addObject(studentCsvFile));
            a.setStudentList(tmplist);
            for (Person student : tmplist) {
                student.setClassroom(a);
            }
        }

        for (Classroom classroom : School.getClassrooms()) {
            for (Person student : School.getStudentlist()) {
                if (student.getClassroom().getName() == classroom.getName()) {
                    System.out.println(student.getClassroom().getName());
                }
            }
        }
    }
}
