package edu.neu.csye6200.students.view;

import buttonEvents.LoginClick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
/*
// jtextarea
textArea.setFont(new Font("Monaco", Font.PLAIN, 20));

// jlabel
label.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

// jlist
list.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
 */
public class LoginView extends JFrame {

    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    // borderoutlayout + jpanel
    SpringLayout springLayout = new SpringLayout();
    JPanel SpringPanel = new JPanel(springLayout);
    JTextField userField = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JLabel userNameLabel = new JLabel("UserName:");
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    LoginClick loginCLickEvents = new LoginClick(this);

    TrayIcon trayIcon;
    SystemTray systemTray;
    public LoginView() {
        super("Day Care System");
        Container contentPane = getContentPane();
        fontSizeInitialization();
        SpringLayoutSetup();
        contentPaneAdd(contentPane);
        // icon image path
        final URL iconPath = LoginView.class.getClassLoader().getResource("icon.png");
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
        SystemTraySupportWindowsOS(iconImage);
    }

    private void contentPaneAdd(Container contentPane) {
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.add(SpringPanel,BorderLayout.CENTER);
    }

    private void fontSizeInitialization() {
        // initialization fonts and size;
        titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        userNameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        passwordLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        userField.setPreferredSize(new Dimension(200, 30));
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
                    LoginView.this.dispose();
                }
            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override

                public void mouseClicked(MouseEvent e) {
                    // super.mouseClicked(e);
                    int cntClicks = e.getClickCount();
                    if (cntClicks == 1)  {
                        LoginView.this.setExtendedState(JFrame.NORMAL);
                    }
                    LoginView.this.setVisible(true);
                }
            });
        }
    }

    private void SpringLayoutSetup() {
        // Spring Layout
        SpringPanel.add(userNameLabel);
        SpringPanel.add(userField);
        SpringPanel.add(passwordLabel);
        SpringPanel.add(passwordField);
        SpringPanel.add(loginButton);
        loginButton.addActionListener(loginCLickEvents);
        //loginButton.addKeyListener(loginCLickEvents);
        getRootPane().setDefaultButton(loginButton);
        Spring lineWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel), Spring.width(userField)), Spring.constant(20));
        int buttonPos = Spring.sum(Spring.sum(Spring.width(userNameLabel), Spring.width(userField)), Spring.constant(-140)).getValue()/2;
        springLayout.putConstraint(SpringLayout.WEST, userNameLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 25, SpringLayout.NORTH, SpringPanel);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 100, SpringLayout.NORTH, SpringPanel);
        springLayout.putConstraint(SpringLayout.WEST, userField, 20, SpringLayout.EAST, userNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, userField, 0, SpringLayout.NORTH, userNameLabel);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 25, SpringLayout.EAST,passwordLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH,passwordLabel);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, buttonPos, SpringLayout.HORIZONTAL_CENTER, passwordLabel);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 50, SpringLayout.NORTH, passwordLabel);
    }

    public String getUserFieldInput() {
        return userField.getText();
    }

    public char[] getPassword(){
        return passwordField.getPassword();
    }

    public static void main(String[] args) {
        new LoginView();
    }
}


