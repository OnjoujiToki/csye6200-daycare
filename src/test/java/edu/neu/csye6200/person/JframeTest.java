package edu.neu.csye6200.person;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
public class JframeTest {
    public static void main(String[] args) {
        JFrame window = new JFrame("DayCare System");
        URL iconPath = JframeTest.class.getClassLoader().getResource("icon.png");
        Image iconImage = new ImageIcon(iconPath).getImage();
        window.setIconImage(iconImage);
        window.setSize(600, 400); // in px
        window.setVisible(true);
        window.setResizable(false); // make it nonchangeable
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE); // exit when closing
        Dimension curScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation((curScreenSize.width - 600) /2, (curScreenSize.height - 400) /2);
    }
}
