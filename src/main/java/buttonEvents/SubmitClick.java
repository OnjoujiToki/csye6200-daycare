package buttonEvents;

import database.TableModel;
import edu.neu.csye6200.students.view.AddView;
import edu.neu.csye6200.students.view.DataView;
import edu.neu.csye6200.students.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class SubmitClick implements ActionListener {
    private final AddView instance;
    private final DataView dataInstance;
    public SubmitClick(AddView view, DataView dataView) {
        this.instance = view;
        this.dataInstance = dataView;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Submit Clicked");
        instance.dispose();
        Vector<Object> row3 = new Vector<>();
        row3.addElement("1");
        row3.addElement("nm");
        row3.addElement("1sl");
        row3.addElement("1");
        row3.addElement("1");
        row3.addElement("1");
        dataInstance.data.addElement(row3);
        // instance.mainTablemodel.fireTableDataChanged();
        dataInstance.mainTablemodel = TableModel.analyzeData(dataInstance.data);
        dataInstance.mainTable.setModel(dataInstance.mainTablemodel);
        System.out.println(dataInstance.data.size());
        dataInstance.mainTable.render();
    }

}
