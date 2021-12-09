package buttonEvents;

import database.TableModel;
import edu.neu.csye6200.students.view.AddView;
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
        //Check if their is a row selected
        if (getSelectedRowForDeletion != -1) {
            instance.mainTablemodel.removeRow(getSelectedRowForDeletion);
            JOptionPane.showMessageDialog(null, "Row Deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Unable To Delete");
        }
    }

}
