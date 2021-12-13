package edu.neu.csye6200.students.view;
import buttonEvents.*;
import edu.neu.csye6200.classes.Demo;
import database.TableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
import java.util.List;
import edu.neu.csye6200.classes.*;

import database.Table;

import java.awt.event.*;
import java.net.URL;
import java.util.stream.Collectors;

import static edu.neu.csye6200.classes.School.studentlist;

public class DataView extends JFrame {
    private String[] columnsNames = {"Id", "Name", "Age", "Parent Name", "Email", "Math", "English", "Chemistry", "Physics", "Java", "Music"};
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    public JPanel operationPanel = new JPanel();
    public JPanel dataPanel = new JPanel(new FlowLayout((FlowLayout.RIGHT)));
    public static Table mainTable =  new Table();
    JButton addClassButton = new JButton("New Class");
    JButton addClassRoomButton = new JButton("Add Classroom");
    public JButton addButton = new JButton("Add");
    public JComboBox classroomCombox = new JComboBox();
    public JComboBox passvalueCombox = new JComboBox();

    JButton importButton = new JButton("Import");
    JButton exportButton = new JButton("Export");
    JButton deleteButton = new JButton("Delete");
    JButton switchButton = new JButton("Switch");

    JButton searchButton = new JButton("Set this Score As Pass");
    JButton nextButton = new JButton("Next");
    JButton preButton = new JButton("Last");
//    AddClassClick addClassButtonClickEvent = new AddClassClick(this);
    AddButtonClick addButtonClickEvent = new AddButtonClick(this);
    DeleteClick deleteButtonClickEvent = new DeleteClick(this);
    ImportClick importButtonClickEvent = new ImportClick(this);
    ExportClick exportButtonClickEvent = new ExportClick(this);
    SwitchClick switchButtonClickEvent = new SwitchClick(this);
    SearchClick searchButtonClickEvent = new SearchClick(this);
//    AddClassroomClick addClassroomClickEvent = new AddClassroomClick(this);
    TrayIcon trayIcon;

    public static Vector<Object> data1 = new Vector<>();
    public static Vector<Vector<Object>> data2 = new Vector<>();

    public static Object[][] data;

//    public Vector
    public static TableModel mainTablemodel;
    Vector<Object> row1 = new Vector<>();
    SystemTray systemTray;

    public String[] getColumnsNames() {
        return columnsNames;
    }

    public DataView() {
        data = new Object[studentlist.size()][11];
        System.out.println("---lenght-----" + studentlist.size());
        Container contentPane = getContentPane();
        DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Classroom A");
        classroomCombox.setModel(defaultComboBoxModel1);
        DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("30");
        defaultComboBoxModel2.addElement("40");
        defaultComboBoxModel2.addElement("50");
        passvalueCombox.setModel(defaultComboBoxModel2);
        addAllButtons(contentPane);
        // icon image path
        final URL iconPath = DataView.class.getClassLoader().getResource("icon.png");
        assert iconPath != null;
        final Image iconImage = new ImageIcon(iconPath).getImage();
        // set Dock image for MacOSX
        // Delete this part if showing error log
        final Taskbar taskbar = Taskbar.getTaskbar();
        try {
            taskbar.setIconImage(iconImage);
        } catch (final UnsupportedOperationException e) {
            System.out.println("Not running in Mac OSX");
        } catch (final SecurityException e) {
            System.out.println("Security expception for Taskbar.setIconImage");
        }
        // set icon image for Windows operating system;
        setIconImage(iconImage);

        // set window
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setVisible(true);
//        setResizable(true); // make it nonchangeable
//        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((curScreenSize.width - 600) / 2, (curScreenSize.height - 400) / 2);

        // System Tray Support for Windows
        SystemTraySupportWindowsOS(iconImage);


        // Button Events
        // Classroom csye6200 = Classroom.getInstance();
        // csye6200.printStudentsInformation();
        addButton.addActionListener(addButtonClickEvent);
//        addClassButton.addActionListener(addClassButtonClickEvent);
//        addClassRoomButton.addActionListener(addClassroomClickEvent);
        deleteButton.addActionListener(deleteButtonClickEvent);
        importButton.addActionListener(importButtonClickEvent);
        exportButton.addActionListener(exportButtonClickEvent);
        switchButton.addActionListener(switchButtonClickEvent);
        searchButton.addActionListener(searchButtonClickEvent);
        int i = 0;
        for(Person student: studentlist){
            data[i][0] = student.getId();
            data[i][1] = student.getName();
            data[i][2] = student.getAge();
            data[i][3] = student.getParent();
            data[i][4] = student.getEmail();
            data[i][5] = student.getMath();
            data[i][6] = student.getEnglish();
            data[i][7] = student.getChemistry();
            data[i][8] = student.getPhysics();
            data[i][9] = student.getJava();
            data[i][10] = student.getMusic();
            i++;
        }
        mainTablemodel = TableModel.analyzeData(data, columnsNames);
        mainTable.setModel(mainTablemodel);
        mainTable.render(columnsNames);
        JScrollPane jScrollPane = new JScrollPane(mainTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        contentPane.add(dataPanel, BorderLayout.SOUTH);
    }

    private void addAllButtons(Container contentPane) {
        // update Button
        operationPanel.add(addClassButton);
        operationPanel.add(addButton);
        operationPanel.add(addClassRoomButton);
        operationPanel.add(importButton);
        operationPanel.add(exportButton);
        operationPanel.add(deleteButton);
        operationPanel.add(passvalueCombox);
        operationPanel.add(searchButton);
        operationPanel.add(classroomCombox);
        operationPanel.add(switchButton);
        contentPane.add(nextButton);
        contentPane.add(preButton);
        contentPane.add(operationPanel, BorderLayout.NORTH);
    }


    private void SystemTraySupportWindowsOS(Image iconImage) {
        if (SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
            trayIcon = new TrayIcon(iconImage);
            trayIcon.setImageAutoSize(true);
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            // adapting mininizing for window
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    //super.windowIconified(e);
                    DataView.this.dispose();
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override

                public void mouseClicked(MouseEvent e) {
                    // super.mouseClicked(e);
                    int cntClicks = e.getClickCount();
                    if (cntClicks == 1)  {
                        DataView.this.setExtendedState(JFrame.NORMAL);
                    }
                    DataView.this.setVisible(true);
                }
            });
        }
    }

}
