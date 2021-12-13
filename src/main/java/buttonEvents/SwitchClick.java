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
        System.out.println("Switch cliked");
        // whats next? refresh Jtable by given coressponding combox selection
        String curClassroom = (String) instance.classroomCombox.getSelectedItem();
        int curIdx = -1;
        if (curClassroom != " ") {
            curIdx = mapStringNumber.convertStringtoNumber(curClassroom);
        } else {
            JOptionPane.showMessageDialog(null, "Please at least select one classroom");
        }

        System.out.println(curIdx);
        Classroom curCr = School.classrooms.get(curIdx);
        // YourType varName = (YourType)comboBox.getSelectedItem();
//        DataView.data();
        for (Person s: curCr.getStudentList()) {
            Vector<Object> curRow = new Vector<>();
            curRow.addElement(s.getId());
            curRow.addElement(s.getName());
            curRow.addElement(s.getParent());
            curRow.addElement(s.getEmail());
            curRow.addElement(s.getMath());
            curRow.addElement(s.getEnglish());
            curRow.addElement(s.getChemistry());
            curRow.addElement(s.getPhysics());
            curRow.addElement(s.getJava());
            curRow.addElement(s.getMusic());
//            DataView.data.addElement(curRow);
        }
        instance.mainTablemodel = TableModel.analyzeData(DataView.data, instance.getColumnsNames());
        instance.mainTable.setModel(instance.mainTablemodel);
//        System.out.println(DataView.data.size());
        instance.mainTable.render(instance.getColumnsNames());

    }
}


