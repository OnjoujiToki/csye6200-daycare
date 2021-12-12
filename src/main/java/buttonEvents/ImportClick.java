package buttonEvents;

import database.TableModel;
//import edu.neu.csye6200.students.view.AddView;
import edu.neu.csye6200.classes.Demo;
import edu.neu.csye6200.classes.Student;
import edu.neu.csye6200.classes.StudentFactory;
import edu.neu.csye6200.students.view.DataView;
import edu.neu.csye6200.students.view.LoginView;
import buttonEvents.*;
import edu.neu.csye6200.students.view.SubmitView;
import utility.FileUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class ImportClick implements ActionListener {
    private final DataView instance;
    public ImportClick(DataView view){
        this.instance = view;
    }
    FileUtil fileUtil = new FileUtil();

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("import Clicked");
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(instance) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String csvFile = fileUtil.readCSVFile(f.getName());
            this.instance.dispose();
            Demo.studentList.removeAll(Demo.studentList);
            StudentFactory.addObject(csvFile);
            new DataView();
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
            System.out.println("User changed their idea...");
        }

    }

}
