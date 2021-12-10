package buttonEvents;

import database.TableModel;
//import edu.neu.csye6200.students.view.AddView;
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

public class SearchClick implements ActionListener {
    private final DataView dataInstance;
    public SearchClick(DataView dataView) {
        this.dataInstance = dataView;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Search Clicked");

        dataInstance.mainTablemodel = TableModel.analyzeData(dataInstance.data);
        dataInstance.mainTable.setModel(dataInstance.mainTablemodel);
        System.out.println(dataInstance.data.size());
        dataInstance.mainTable.render2();
    }

}
