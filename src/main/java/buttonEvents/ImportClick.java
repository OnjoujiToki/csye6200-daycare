package buttonEvents;

import edu.neu.csye6200.classes.StudentFactory;
import edu.neu.csye6200.students.view.Dashboard;
import edu.neu.csye6200.students.view.DataView;
import utility.FileUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import edu.neu.csye6200.classes.*;


public class ImportClick implements ActionListener {
    private final DataView instance;
    public ImportClick(DataView view){
        this.instance = view;
    }
    FileUtil fileUtil = new FileUtil();

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("import Clicked");
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(instance) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String csvFile = fileUtil.readCSVFile(f.getName());
            this.instance.dispose();
            String curClassroom = (String) instance.classroomCombox.getSelectedItem();
            System.out.println("------------djsadjsandas-------" + curClassroom);
            for (Classroom classroom:School.getClassrooms()){
                if (curClassroom==classroom.getName()){
                    List<Person> tmplist = (StudentFactory.addObject(csvFile));
                    classroom.setStudentList(tmplist);
                    for (Person student:tmplist){
                        student.setClassroom(classroom);
                    }

                }
            }

//            for (Classroom classroom : School.getClassrooms()) {
//                for (Person student : School.getStudentlist()) {
//                    if (student.getClassroom().getName() == classroom.getName()) {
//                        System.out.println(student.getClassroom().getName());
//                    }
//                }
//            }
this.instance.dashboardInstance.setDashboardPanel(new DataView(this.instance.dashboardInstance).getContentPane());
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
            System.out.println("User changed their idea...");
        }

    }

}
