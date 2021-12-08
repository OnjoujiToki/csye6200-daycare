package edu.neu.csye6200.students.view;

import buttonEvents.SubmitClick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class AddView extends JFrame {
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    // borderoutlayout + jpanel
    private final DataView dataView;
    SubmitClick submitEvents;
    SpringLayout springLayout = new SpringLayout();
    JPanel SpringPanel = new JPanel(springLayout);
    JTextField nameField = new JTextField();
    JLabel idLabel = new JLabel("ID: ");
    JLabel nameLabel = new JLabel("UserName:");
    JLabel ageLabel = new JLabel("Age: ");
    JLabel parentLabel = new JLabel("Parent: ");
    JLabel addressLabel = new JLabel("Address: ");
    JLabel hibLabel = new JLabel("Hib: ");
    JLabel varicellaLabel = new JLabel("Varicella: ");
    JLabel dtapLabel = new JLabel("DTaP: ");
    JLabel polioLabel = new JLabel("Polio: ");
    JLabel mmrLabel = new JLabel("MMR: ");
    JLabel HepatitisLabel = new JLabel("Hepatitis: ");

    JPasswordField passwordField = new JPasswordField();
    JButton addButton = new JButton("add");
    TrayIcon trayIcon;
    SystemTray systemTray;
    public AddView(DataView view) {
        super("Day Care System");
        this.dataView = view;
        submitEvents = new SubmitClick(this,view);
        Container contentPane = getContentPane();
        fontSizeInitialization();
        SpringLayoutSetup();
        contentPaneAdd(contentPane);
        // icon image path
        final URL iconPath = AddView.class.getClassLoader().getResource("icon.png");
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
        setSize(600, 400); // in px
        setVisible(true);
        setResizable(false); // make it nonchangeable
        setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((curScreenSize.width - 600) / 2, (curScreenSize.height - 400) / 2);

        // System Tray Support for Windows
        // SystemTraySupportWindowsOS(iconImage);
    }

    private void contentPaneAdd(Container contentPane) {
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.add(SpringPanel,BorderLayout.CENTER);
    }

    private void fontSizeInitialization() {
        // initialization fonts and size;
        titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        nameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        idLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        nameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        titleLabel.setPreferredSize(new Dimension(0,80));
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
                    AddView.this.dispose();
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override

                public void mouseClicked(MouseEvent e) {
                    // super.mouseClicked(e);
                    int cntClicks = e.getClickCount();
                    if (cntClicks == 1)  {
                        AddView.this.setExtendedState(JFrame.NORMAL);
                    }
                    AddView.this.setVisible(true);
                }
            });
        }
    }

    private void SpringLayoutSetup() {
        // Spring Layout
        SpringPanel.add(idLabel);
        SpringPanel.add(nameLabel);
        SpringPanel.add(ageLabel);
        SpringPanel.add(addressLabel);
        SpringPanel.add(hibLabel);
        SpringPanel.add(varicellaLabel);
        SpringPanel.add(dtapLabel);
        SpringPanel.add(polioLabel);
        SpringPanel.add(mmrLabel);
        SpringPanel.add(HepatitisLabel);
        SpringPanel.add(nameField);
        SpringPanel.add(passwordField);
        SpringPanel.add(addButton);
        SpringPanel.add(parentLabel);
        addButton.addActionListener(submitEvents);
        //addButton.addKeyListener(addCLickEvents);
        // wait to complete.. key to add
        getRootPane().setDefaultButton(addButton);
        Spring lineWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameField)), Spring.constant(20));
        int buttonPos = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameField)), Spring.constant(-140)).getValue()/2;
        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 25, SpringLayout.NORTH, SpringPanel);
        springLayout.putConstraint(SpringLayout.WEST, idLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, idLabel, 100, SpringLayout.NORTH, SpringPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 20, SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 25, SpringLayout.EAST,idLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH,idLabel);
        springLayout.putConstraint(SpringLayout.WEST, addButton, buttonPos, SpringLayout.HORIZONTAL_CENTER, idLabel);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 50, SpringLayout.NORTH, idLabel);
    }

    public String getnameFieldInput() {
        return nameField.getText();
    }

    public char[] getPassword(){
        return passwordField.getPassword();
    }


}


