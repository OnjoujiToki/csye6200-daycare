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
public class DataView extends JFrame {
    JFrame window = new JFrame("DayCare System");
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    TrayIcon trayIcon;
    SystemTray systemTray;
    public DataView() {
        Container contentPane = window.getContentPane();
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
        window.setIconImage(iconImage);

        // set window
        window.setSize(600, 400); // in px
        window.setVisible(true);
        window.setResizable(false); // make it nonchangeable
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((curScreenSize.width - 600) / 2, (curScreenSize.height - 400) / 2);

        // System Tray Support for Windows
        // SystemTraySupportWindowsOS(iconImage);
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
