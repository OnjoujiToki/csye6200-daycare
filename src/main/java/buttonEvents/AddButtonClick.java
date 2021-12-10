package buttonEvents;

import database.TableModel;
//import edu.neu.csye6200.students.view.AddView;
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

public class AddButtonClick implements ActionListener {
    private final DataView instance;
    public AddButtonClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("submit Clicked");
       //new AddView(instance);
        JFrame jFrame = new JFrame("add");
        jFrame.setContentPane(new SubmitView(instance).$$$getRootComponent$$$());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
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
