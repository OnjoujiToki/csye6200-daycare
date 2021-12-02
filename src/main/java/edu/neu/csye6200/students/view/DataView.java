package edu.neu.csye6200.students.view;

import buttonEvents.LoginClick;
import database.Table;
import database.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Vector;

public class DataView extends JFrame {
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    JPanel operationPanel = new JPanel();
    JPanel dataPanel = new JPanel();
    Table mainTable =  new Table();
    JButton addButton = new JButton("Add");
    JButton importButton = new JButton("Import");
    JButton refreshButton = new JButton("Refresh");
    JButton deleteButton = new JButton("Delete");
    JTextField searchField = new JTextField(20);
    JButton searchButton = new JButton("Search");
    JButton nextButton = new JButton("Next");
    JButton preButton = new JButton("Last");

    TrayIcon trayIcon;
    SystemTray systemTray;
    public DataView() {
        super("Day Care Database");
        Container contentPane = getContentPane();

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

    }

    private void addAllButtons(Container contentPane) {
        // update Button
        operationPanel.add(addButton);
        operationPanel.add(importButton);
        operationPanel.add(refreshButton);
        operationPanel.add(deleteButton);
        operationPanel.add(searchField);
        operationPanel.add(searchButton);
        contentPane.add(nextButton);
        contentPane.add(preButton);
        contentPane.add(operationPanel, BorderLayout.NORTH);
        // Test Data
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> row1 = new Vector<>();
        row1.addElement("1");
        row1.addElement("nm");
        row1.addElement("1sl");
        row1.addElement("1");
        row1.addElement("1");
        row1.addElement("1");
        row1.addElement("1");
        Vector<Object> row2 = new Vector<>();
        row2.addElement("1");
        row2.addElement("nm");
        row2.addElement("1sl");
        row2.addElement("1");
        row2.addElement("1");
        row2.addElement("1");
        row2.addElement("1");
        data.addElement(row1);
        data.addElement(row2);
        TableModel mainTablemodel = TableModel.analyzeData(data);
        mainTable.setTableModel(mainTablemodel);
        JScrollPane jScrollPane = new JScrollPane(mainTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        contentPane.add(dataPanel, BorderLayout.SOUTH);
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
