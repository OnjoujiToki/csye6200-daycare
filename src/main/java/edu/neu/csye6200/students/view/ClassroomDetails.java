package edu.neu.csye6200.students.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import database.Table;
import edu.neu.csye6200.classes.Classroom;
import edu.neu.csye6200.classes.School;
import edu.neu.csye6200.classes.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassroomDetails extends JFrame {
    ClassroomDetails classroomDetails;
    private JTable classroomTable1;
    private JPanel jPanel1;
    private JButton deleteClassroomButton;
    private JButton addClassroomButton;
    private JPanel panel1;
    private JScrollPane jScrollPane;
    private Table classroomTable = new Table();
    //    private JFrame frame = new JFrame();
    String[] columnNames = {"Id", "ClassroomName", "Teacher"};
    DefaultTableModel maintableModel = new DefaultTableModel();

    public ClassroomDetails() {
        classroomDetails = this;
        $$$setupUI$$$();
        System.out.println("---------jnjnj---------");
        Object[][] classRoomObject = new Object[School.classrooms.size()][3];
        int i = 0;
        for (Classroom c : School.classrooms) {
            classRoomObject[i][0] = i + 1;
            classRoomObject[i][1] = c.getName();
            classRoomObject[i][2] = c.getTeacher().toString();
            i++;
        }
        Container contentPane = getContentPane();
        maintableModel.setDataVector(classRoomObject, columnNames);
        classroomTable.setModel(maintableModel);
        classroomTable.render(columnNames);

        addClassroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Add ClassRoom");
                jFrame.setContentPane(new AddClassroom(classroomDetails).$$$getRootComponent$$$());
                jFrame.pack();
                jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                jFrame.setVisible(true);
            }
        });
        deleteClassroomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getSelectedRowForDeletion = classroomTable.getSelectedRow();
                System.out.println("Dsadas" + classroomTable.getSelectedRow());
                //Check if their is a row selected
                if (getSelectedRowForDeletion != -1) {
                    maintableModel.removeRow(getSelectedRowForDeletion);
                    String name = String.valueOf(classroomTable.getValueAt(getSelectedRowForDeletion, 2));
                    School.classrooms.stream().filter(n -> n.getName() == name).map(n -> School.classrooms.remove(n));
                    JOptionPane.showMessageDialog(null, "Row Deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Unable To Delete");
                }
            }
        });
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setContentPane(this.$$$getRootComponent$$$());
//        this.pack();
//        setVisible(true);
//        setResizable(true); // make it nonchangeable
//        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((curScreenSize.width - 600) / 2, (curScreenSize.height - 400) / 2);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(12, 12, 12, 12), -1, -1));
        jPanel1.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        deleteClassroomButton = new JButton();
        deleteClassroomButton.setText("Delete Classroom");
        panel1.add(deleteClassroomButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addClassroomButton = new JButton();
        addClassroomButton.setText("Add Classroom");
        panel1.add(addClassroomButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jPanel1.add(jScrollPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        jScrollPane = new JScrollPane(classroomTable);
        add(jScrollPane, BorderLayout.CENTER);
        jScrollPane.setVisible(true);
    }
}
