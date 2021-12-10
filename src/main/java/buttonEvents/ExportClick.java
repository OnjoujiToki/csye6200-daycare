package buttonEvents;

import database.TableModel;
import edu.neu.csye6200.Classroom;
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

public class ExportClick implements ActionListener {
    private final DataView instance;
    public ExportClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("export Clicked");
        //new AddView(instance);
        Classroom instance = Classroom.getInstance();
        instance.printStudentsInformation();
        /*
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
        instance.mainTable.render();*/
    }

}
