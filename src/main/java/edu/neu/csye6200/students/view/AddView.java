package edu.neu.csye6200.students.view;

import buttonEvents.SubmitClick;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class AddView extends JFrame {
    JLabel titleLabel = new JLabel("Day Care System", JLabel.CENTER);
    // borderoutlayout + jpanel
    private final DataView dataView;
    SubmitClick submitEvents;
    SpringLayout springLayout = new SpringLayout();
    JPanel SpringPanel = new JPanel(springLayout);
    JTextField nameField = new JTextField();
    JTextField idField = new JTextField(10); // should be number only



    JLabel idLabel = new JLabel("ID:       ");
    JLabel nameLabel = new JLabel("Name:     ");
    JLabel ageLabel = new JLabel("Age:      ");
    JLabel parentLabel = new JLabel("Parent:   ");
    JLabel addressLabel = new JLabel("Address:  ");
    JLabel hibLabel = new JLabel("Hib:      ");
    JLabel varicellaLabel = new JLabel("Varicella:");
    JLabel dtapLabel = new JLabel("DTaP:     ");
    JLabel polioLabel = new JLabel("Polio:    ");
    JLabel mmrLabel = new JLabel("MMR:      ");
    JLabel HepatitisLabel = new JLabel("Hepatitis:");


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
        setSize(800, 600); // in px
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
        nameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        idLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        ageLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        parentLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        hibLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        varicellaLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        dtapLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        polioLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        mmrLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        HepatitisLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        addressLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
        nameField.setPreferredSize(new Dimension(200, 20));
        idField.setPreferredSize(new Dimension(200,20));
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
        SpringPanel.add(idField);
        SpringPanel.add(addButton);
        SpringPanel.add(parentLabel);
        addButton.addActionListener(submitEvents);
        //addButton.addKeyListener(addCLickEvents);
        // wait to complete.. key to addx z
        getRootPane().setDefaultButton(addButton);
        Spring lineWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameField)), Spring.constant(20));
        int buttonPos = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameField)), Spring.constant(-140)).getValue()/2;
        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 25, SpringLayout.NORTH, SpringPanel);
        springLayout.putConstraint(SpringLayout.WEST, idLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, idLabel, 25, SpringLayout.NORTH, nameLabel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 20, SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
        springLayout.putConstraint(SpringLayout.WEST, ageLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, ageLabel, 25, SpringLayout.NORTH, idLabel);
        springLayout.putConstraint(SpringLayout.WEST, parentLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, parentLabel, 25, SpringLayout.NORTH, ageLabel);
        springLayout.putConstraint(SpringLayout.WEST, addressLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, addressLabel, 25, SpringLayout.NORTH, parentLabel);
        springLayout.putConstraint(SpringLayout.WEST, hibLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, hibLabel, 25, SpringLayout.NORTH, addressLabel);
        springLayout.putConstraint(SpringLayout.WEST, varicellaLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, varicellaLabel, 25, SpringLayout.NORTH, hibLabel);
        springLayout.putConstraint(SpringLayout.WEST, dtapLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, dtapLabel, 25, SpringLayout.NORTH, varicellaLabel);
        springLayout.putConstraint(SpringLayout.WEST, polioLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, polioLabel, 25, SpringLayout.NORTH, dtapLabel);
        springLayout.putConstraint(SpringLayout.WEST, mmrLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, mmrLabel, 25, SpringLayout.NORTH, polioLabel);
        springLayout.putConstraint(SpringLayout.WEST, HepatitisLabel, -lineWidth.getValue()/2, SpringLayout.HORIZONTAL_CENTER, SpringPanel);
        springLayout.putConstraint(SpringLayout.NORTH, HepatitisLabel, 25, SpringLayout.NORTH, mmrLabel);
        springLayout.putConstraint(SpringLayout.WEST, addButton, buttonPos, SpringLayout.HORIZONTAL_CENTER, HepatitisLabel);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 50, SpringLayout.NORTH, HepatitisLabel);
    }

    public String getnameFieldInput() {
        return nameField.getText();
    }



}

class MyDocumentFilter extends DocumentFilter
{
    @Override
    public void insertString(DocumentFilter.FilterBypass fp
            , int offset, String string, AttributeSet aset)
            throws BadLocationException
    {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++)
        {
            if (!Character.isDigit(string.charAt(i)))
            {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger)
            super.insertString(fp, offset, string, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fp, int offset
            , int length, String string, AttributeSet aset)
            throws BadLocationException
    {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++)
        {
            if (!Character.isDigit(string.charAt(i)))
            {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger)
            super.replace(fp, offset, length, string, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}
