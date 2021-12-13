package buttonEvents;

import database.TableModel;
//import edu.neu.csye6200.students.view.AddView;
import edu.neu.csye6200.classes.Classroom;
import edu.neu.csye6200.classes.Person;
import edu.neu.csye6200.classes.School;
import edu.neu.csye6200.classes.StudentFactory;
import edu.neu.csye6200.students.view.DataView;
import edu.neu.csye6200.students.view.LoginView;
import buttonEvents.*;
import edu.neu.csye6200.students.view.SubmitView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class DeleteClick implements ActionListener {
    private final DataView instance;
    public DeleteClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("delete Clicked");
        int getSelectedRowForDeletion = instance.mainTable.getSelectedRow();
        if (getSelectedRowForDeletion != -1) {
            Object name = instance.mainTablemodel.getValueAt(getSelectedRowForDeletion, 1);
            String studentName = name.toString();
            String curClassroom = (String) instance.classroomCombox.getSelectedItem();
            for (Classroom classroom:School.getClassrooms()){
                    if (curClassroom == classroom.getName()) {
                        for (Person student:classroom.getStudentList()){
                            if(student.getName()==studentName){
                                classroom.removeStudent(student);
                                School.removeStudent(student);
                            }
                    }
                }
            }
            instance.mainTablemodel.removeRow(getSelectedRowForDeletion);
            JOptionPane.showMessageDialog(null, "Row Deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Unable To Delete");
        }
        System.out.println(DataView.data.length);
    }

}
