package edu.neu.csye6200.students.view;
import buttonEvents.*;

import database.TableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

//import edu.neu.csye6200.classes.Classroom;

import database.Table;
//import edu.neu.csye6200.classes.School;
//import edu.neu.csye6200.classes.Teacher;

import java.awt.event.*;
import java.net.URL;

public class DataView extends JFrame {
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    public JPanel operationPanel = new JPanel();
    public JPanel dataPanel = new JPanel(new FlowLayout((FlowLayout.RIGHT)));
    public Table mainTable =  new Table();
    JButton addClassButton = new JButton("New Class");
    public JButton addButton = new JButton("Add");
    public JComboBox classroomCombox = new JComboBox();

    JButton importButton = new JButton("Import");
    JButton exportButton = new JButton("Export");
    JButton deleteButton = new JButton("Delete");
    JButton switchButton = new JButton("Switch");

    JTextField searchField = new JTextField(20);
    JButton searchButton = new JButton("Search");
    JButton nextButton = new JButton("Next");
    JButton preButton = new JButton("Last");
    AddClassClick addClassButtonClickEvent = new AddClassClick(this);
    AddButtonClick addButtonClickEvent = new AddButtonClick(this);
    DeleteClick deleteButtonClickEvent = new DeleteClick(this);
    ImportClick importButtonClickEvent = new ImportClick(this);
    ExportClick exportButtonClickEvent = new ExportClick(this);
    SwitchClick switchButtonClickEvent = new SwitchClick(this);

    TrayIcon trayIcon;
    public static Vector<Vector<Object>> data = new Vector<>();
    public TableModel mainTablemodel;
    Vector<Object> row1 = new Vector<>();
    SystemTray systemTray;
    public DataView() {
        super("Day Care Database");
        Container contentPane = getContentPane();
        DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Classroom A");
        classroomCombox.setModel(defaultComboBoxModel1);
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
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(true); // make it nonchangeable
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((curScreenSize.width - 600) / 2, (curScreenSize.height - 400) / 2);

        // System Tray Support for Windows
        SystemTraySupportWindowsOS(iconImage);


        // Button Events
        // Classroom csye6200 = Classroom.getInstance();
        // csye6200.printStudentsInformation();
        addButton.addActionListener(addButtonClickEvent);
        addClassButton.addActionListener(addClassButtonClickEvent);
        deleteButton.addActionListener(deleteButtonClickEvent);
        importButton.addActionListener(importButtonClickEvent);
        exportButton.addActionListener(exportButtonClickEvent);
        switchButton.addActionListener(switchButtonClickEvent);
        School neu = School.getInstance();
        School.classrooms.add(new Classroom(new Teacher(0, "First Teacher", "firstteacher@email", 20000, 0)));
        neu.printClassroominformation();
        mainTablemodel = TableModel.analyzeData(data);
        mainTable.setModel(mainTablemodel);
        mainTable.render();
        JScrollPane jScrollPane = new JScrollPane(mainTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        contentPane.add(dataPanel, BorderLayout.SOUTH);
    }

    private void addAllButtons(Container contentPane) {
        // update Button
        operationPanel.add(addClassButton);
        operationPanel.add(addButton);
        operationPanel.add(importButton);
        operationPanel.add(exportButton);
        operationPanel.add(deleteButton);
        operationPanel.add(searchField);
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
