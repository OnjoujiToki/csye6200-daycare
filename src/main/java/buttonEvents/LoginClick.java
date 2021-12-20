package buttonEvents;

import edu.neu.csye6200.students.view.ClassroomDetails;
import edu.neu.csye6200.students.view.Dashboard;
import edu.neu.csye6200.students.view.DataView;
import edu.neu.csye6200.students.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class LoginClick implements ActionListener {
    private final LoginView instance;
    final JButton addbtm = new JButton("");

    public LoginClick(LoginView view) {
        this.instance =  view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Login Clicked");
        instance.dispose();
        boolean correctUserName = false;
        if (Objects.equals(instance.getUserFieldInput(), "sysadmin"))  {
            System.out.println("Correct UserName Entered");
            correctUserName = true;
        }
        String str = "sysadmin";
        char[] realPassword = str.toCharArray();
        boolean correctPassword = false;
        if (Arrays.equals(instance.getPassword(), realPassword)) {
            System.out.println("Correct Password Entered");
            correctPassword = true;
        }
        if (!correctUserName || !correctPassword) {
            JOptionPane.showMessageDialog(instance, "User name or password is wrong!");
        } else {
            // enter into the main panel
            try {
                new Dashboard();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
