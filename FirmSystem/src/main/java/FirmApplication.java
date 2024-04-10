import GUI.Dialogs.LoginForm;
import GUI.FirmGuiApplication;
import domain.User;
import service.FirmServiceImpl;

import javax.swing.*;

public class FirmApplication {

//    public FirmApplication(){
//        JFrame frame = new JFrame("FirmApplication");
//        frame.setContentPane(new FirmGuiApplication().getPanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//
//    }
    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;

        if(user!=null){
            System.out.println("Successful Authentication of " + user.name);
            System.out.println("\t Email " + user.email);
            System.out.println("\t Phone " + user.phone);
            System.out.println("\t Address " + user.address);
            JFrame frame = new JFrame("FirmApplication");
            frame.setContentPane(new FirmGuiApplication().getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        } else {
            System.out.println("Authentication Canceled");
        }
//        JFrame frame = new JFrame("FirmApplication");
//        frame.setContentPane(new FirmGuiApplication().getPanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

    }
}
