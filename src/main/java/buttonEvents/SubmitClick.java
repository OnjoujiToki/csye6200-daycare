package buttonEvents;

import database.TableModel;
//import edu.neu.csye6200.students.view.AddView;
import edu.neu.csye6200.students.view.DataView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SubmitClick implements ActionListener {
//    private final AddView instance;
    private DataView dataInstance;

    public SubmitClick(DataView dataInstance) {
        this.dataInstance = dataInstance;
    }
//    public SubmitClick(AddView view, DataView dataView) {
//        this.instance = view;
//        this.dataInstance = dataView;
//    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Submit Clicked");
//        instance.dispose();
        Vector<Object> row3 = new Vector<>();


        // instance.mainTablemodel.fireTableDataChanged();
        dataInstance.mainTablemodel = TableModel.analyzeData(dataInstance.data);
        dataInstance.mainTable.setModel(dataInstance.mainTablemodel);
        System.out.println(dataInstance.data.length);
        dataInstance.mainTable.render();
    }

}
