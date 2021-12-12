package buttonEvents;

import edu.neu.csye6200.students.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassClick implements ActionListener {
    private final DataView dataInstance;
    public AddClassClick(DataView dataView) {
        this.dataInstance = dataView;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ADD CLASS Clicked");
        JFrame jFrame = new JFrame("add");
        jFrame.setContentPane(new AddTeacherView(dataInstance).$$$getRootComponent$$$());
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
        //Add student to the vector
        //
        dataInstance.data.addElement(row3);
        // instance.mainTablemodel.fireTableDataChanged();
        dataInstance.mainTablemodel = TableModel.analyzeData(dataInstance.data);
        dataInstance.mainTable.setModel(dataInstance.mainTablemodel);
        System.out.println(dataInstance.data.size());
        dataInstance.mainTable.render();*/

    }

}
