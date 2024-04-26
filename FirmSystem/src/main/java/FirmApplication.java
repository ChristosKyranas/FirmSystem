import GUI.Dialogs.LoginForm;
import GUI.FirmGuiApplication;
import domain.User;

import javax.swing.*;

public class FirmApplication {

    public static User current_user;

    private static void loginProcess(){
        LoginForm loginForm = new LoginForm(null);
        current_user = loginForm.user;
    }

    private static void startApplication(){
        // start app
        JFrame frame = new JFrame("FirmApplication");
        frame.setContentPane(new FirmGuiApplication(current_user).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

//        LoginForm loginForm = new LoginForm(null);
//        User user = loginForm.user;
//        current_user = loginForm.user;

        loginProcess();

        if(current_user !=null){
            System.out.println("Successful Authentication of " + current_user.name);
            System.out.println("\t Email " + current_user.email);
            System.out.println("\t Phone " + current_user.phone);
            System.out.println("\t Address " + current_user.address);
            // user passed the login process
            startApplication();
        } else {
            System.out.println("Authentication Canceled");
        }

    }
}
