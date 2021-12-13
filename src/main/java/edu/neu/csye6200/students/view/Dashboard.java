package edu.neu.csye6200.students.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dashboard extends JFrame {
    private JPanel jPanel1;
    private JButton studentsButton;
    private JButton teachersButton;
    private JButton classroomsButton;
    private JPanel buttonsPanel;
    private JPanel dashboardPanel;
    private JLabel headingLabel;

    public void setDashboardPanel(Component comp) {
        this.dashboardPanel.removeAll();
        this.dashboardPanel.add(comp);
        this.dashboardPanel.repaint();
        this.dashboardPanel.revalidate();
    }

    public Dashboard() throws IOException {
        $$$setupUI$$$();
        Dashboard dashboard = this;
        headingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel picLabel = new JLabel();
        BufferedImage myPicture = ImageIO.read(new File("ClassRoom.jpeg"));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(myPicture).getImage().getScaledInstance(1200, 850, Image.SCALE_SMOOTH));
        picLabel.setIcon(imageIcon);
        dashboardPanel.add(picLabel);
        classroomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.removeAll();
                dashboardPanel.add(new ClassroomDetails().$$$getRootComponent$$$());
                dashboardPanel.repaint();
                dashboardPanel.revalidate();
//                new ClassroomDetails();
            }
        });
        teachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JFrame jFrame = new JFrame("Teacher Details");
//                setContentPane(new ClassroomDetails().$$$getRootComponent$$$());
//                pack();
//                setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                dashboardPanel.removeAll();
                dashboardPanel.add(new TeacherDetails().$$$getRootComponent$$$());
                dashboardPanel.repaint();
                dashboardPanel.revalidate();
            }
        });
        studentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardPanel.removeAll();
                dashboardPanel.add(new DataView(dashboard).getContentPane());
                dashboardPanel.repaint();
                dashboardPanel.revalidate();
            }
        });

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(this.$$$getRootComponent$$$());
        this.pack();
        setVisible(true);
        setResizable(true); // make it nonchangeable
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when closing
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
        jPanel1 = new JPanel();
        jPanel1.setLayout(new GridBagLayout());
        jPanel1.setMinimumSize(new Dimension(1000, 174));
        jPanel1.setPreferredSize(new Dimension(1000, 400));
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        buttonsPanel.setBackground(new Color(-15843775));
        buttonsPanel.setPreferredSize(new Dimension(400, 300));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        jPanel1.add(buttonsPanel, gbc);
        classroomsButton = new JButton();
        classroomsButton.setBorderPainted(false);
        classroomsButton.setFocusPainted(false);
        classroomsButton.setMargin(new Insets(12, 12, 12, 12));
        classroomsButton.setText("Classrooms");
        buttonsPanel.add(classroomsButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentsButton = new JButton();
        studentsButton.setMargin(new Insets(12, 12, 12, 12));
        studentsButton.setText("Students");
        buttonsPanel.add(studentsButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teachersButton = new JButton();
        teachersButton.setMargin(new Insets(12, 12, 12, 12));
        teachersButton.setText("Teachers");
        buttonsPanel.add(teachersButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        headingLabel = new JLabel();
        headingLabel.setBackground(new Color(-3809828));
        headingLabel.setForeground(new Color(-2757670));
        headingLabel.setText("Student Management System");
        buttonsPanel.add(headingLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new CardLayout(0, 0));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(24, 24, 24, 24);
        jPanel1.add(dashboardPanel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanel1;
    }

    private void createUIComponents() {
        buttonsPanel.setBounds(10, 10, 500, 1000);
    }
}
