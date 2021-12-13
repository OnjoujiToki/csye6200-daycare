package buttonEvents;

import edu.neu.csye6200.students.view.AddClassroom;
import edu.neu.csye6200.students.view.DataView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassroomClick implements ActionListener {
    private final DataView dataInstance;

    public AddClassroomClick(DataView dataView) {
        this.dataInstance = dataView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jFrame = new JFrame("Add ClassRoom");
        jFrame.setPreferredSize(new Dimension(500, 600));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setContentPane(new AddClassroom(dataInstance).$$$getRootComponent$$$());
        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
