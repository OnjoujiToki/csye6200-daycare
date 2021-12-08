package buttonEvents;

import database.TableModel;
import edu.neu.csye6200.students.view.DataView;
import edu.neu.csye6200.students.view.LoginView;
import buttonEvents.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class addButtonClick implements ActionListener {
    private final DataView instance;
    public addButtonClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Login Clicked");
        Vector<Object> row3 = new Vector<>();
        row3.addElement("1");
        row3.addElement("nm");
        row3.addElement("1sl");
        row3.addElement("1");
        row3.addElement("1");
        row3.addElement("1");
        instance.data.addElement(row3);
        // instance.mainTablemodel.fireTableDataChanged();
        instance.mainTablemodel = TableModel.analyzeData(instance.data);
        instance.mainTable.setModel(instance.mainTablemodel);
        System.out.println(instance.data.size());
    }

}
