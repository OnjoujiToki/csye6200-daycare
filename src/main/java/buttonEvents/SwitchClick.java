package buttonEvents;

import database.TableModel;
import edu.neu.csye6200.classes.Classroom;
import edu.neu.csye6200.classes.Person;
import edu.neu.csye6200.classes.School;
import edu.neu.csye6200.classes.Student;
import edu.neu.csye6200.students.view.DataView;
import utility.EmailValidator;
import utility.mapStringNumber;

import javax.lang.model.element.Element;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class SwitchClick implements ActionListener {
    private final DataView instance;
    public SwitchClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Switch clicked");
        // whats next? refresh Jtable by given coressponding combox selection
        String curClassroom = (String) instance.classroomCombox.getSelectedItem();
        int curIdx = 0;
        if (curClassroom != " ") {
//            curIdx = mapStringNumber.convertStringtoNumber(curClassroom);
        } else {
            JOptionPane.showMessageDialog(null, "Please at least select one classroom");
        }

        System.out.println(curIdx);

        instance.setData(School.getStudentsFromClassroom(curClassroom), instance.getColumnsNames());
        // YourType varName = (YourType)comboBox.getSelectedItem();
//        DataView.data();


    }
}


