package GUI.Dialogs;

import GUI.FirmGuiApplication;
import domain.User;
import utils.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldLogin;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel loginPanel;
    private DatabaseConnection databaseConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private String sql = null;
    public User user;
    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String password = String.valueOf(passwordFieldLogin.getPassword());

                user = getAuthenticateUser(email, password);

                if(user!=null){
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Email or Password Invalid",
                            "Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private User getAuthenticateUser(String email, String password) {
        User user = null;

        try{
            statement = makeConnection().createStatement();
            sql = "SELECT * FROM users WHERE email=? AND password=?";
            preparedStatement = makeConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            rs = preparedStatement.executeQuery();

            if (rs.next()){
                user = new User();
                user.name = rs.getString("name");
                user.email = rs.getString("email");
                user.phone = rs.getString("phone");
                user.address = rs.getString("address");
                user.password = rs.getString("password");
            }

            closeConnection();
//            statement.close();
//            makeConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public Connection makeConnection(){
        databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
    public void closeConnection() throws SQLException{
        statement.close();
        makeConnection().close();
    }

//    public static void main(String[] args) {
//        LoginForm loginForm = new LoginForm(null);
//        User user = loginForm.user;
//
//        if(user!=null){
//            System.out.println("Successful Authentication of " + user.name);
//            System.out.println("\t Email " + user.email);
//            System.out.println("\t Phone " + user.phone);
//            System.out.println("\t Address " + user.address);
////            FirmApplication
////            JFrame frame = new JFrame("FirmApplication");
////            frame.setContentPane(new FirmGuiApplication().getPanel());
////            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////            frame.pack();
////            frame.setVisible(true);
//        } else {
//            System.out.println("Authentication Canceled");
//        }
//
//    }

}
