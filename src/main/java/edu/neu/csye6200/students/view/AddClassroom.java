package edu.neu.csye6200.students.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.neu.csye6200.classes.Classroom;
import edu.neu.csye6200.classes.Person;
import edu.neu.csye6200.classes.School;
import edu.neu.csye6200.classes.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClassroom extends JFrame {
    private JLabel classroom;
    private JTextField classroomName;
    private JComboBox teacherName;
    private JButton submitButton;
    private JPanel panel1;
    private JLabel classRoomLabel;
    private JLabel homeroomTeacherLabel;

    public AddClassroom(DataView dataView) {
        {
            setPreferredSize(new Dimension(500, 600));
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            for (Person t : School.getTeacherlist()) {
                comboBoxModel.addElement(t);
            }
            teacherName.setModel(comboBoxModel);
        }
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classroom = classroomName.getText();
                Teacher teacher = (Teacher) teacherName.getSelectedItem();
                School.classrooms.add(new Classroom(classroom, teacher));
            }
        });
    }

    public AddClassroom(ClassroomDetails classroomDetails) {
        {
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            for (Person t : School.getTeacherlist()) {
                comboBoxModel.addElement(t);
            }
            teacherName.setModel(comboBoxModel);
        }
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classroom = classroomName.getText();
                Teacher teacher = (Teacher) teacherName.getSelectedItem();

//                teacherName.addElement(" ");
                School.classrooms.add(new Classroom(classroom, teacher));
                classroomDetails.maintableModel.addRow(new Object[]{classroomDetails.maintableModel.getRowCount() + 1, classroom, teacher});
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 3, new Insets(24, 24, 24, 24), -1, -1));
        panel1.setPreferredSize(new Dimension(1000, 500));
        panel1.setRequestFocusEnabled(false);
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(1, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        classRoomLabel = new JLabel();
        classRoomLabel.setText("ClassRoom Name");
        panel1.add(classRoomLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        homeroomTeacherLabel = new JLabel();
        homeroomTeacherLabel.setText("Homeroom Teacher");
        panel1.add(homeroomTeacherLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        classroomName = new JTextField();
        classroomName.setText("");
        panel1.add(classroomName, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        teacherName = new JComboBox();
        teacherName.setEditable(false);
        panel1.add(teacherName, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        classroom = new JLabel();
        classroom.setAlignmentX(1.0f);
        classroom.setText("ClassRoom");
        panel1.add(classroom, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setText("Submit");
        panel1.add(submitButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
