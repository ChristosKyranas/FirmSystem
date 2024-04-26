package GUI.Dialogs;

import domain.User;
import factory.DatabaseConnectionFactory;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldLogin;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel loginPanel;
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

                // check user's login credentials
                // if exists returns object user
                user = getAuthenticateUser(email, password);

                if(user!=null){
                    // release resources
                    dispose();
                }else {
                    // display error message to user
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
                // release resources
                dispose();
            }
        });

        setVisible(true);
    }

    private User getAuthenticateUser(String email, String password) {
        User user = null;

        // run test hashed code
        try {
            test(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        try{
            // make connection with database
            Statement statement = makeConnection().createStatement();
            String query = "SELECT * FROM users WHERE email=? AND password_hashed=?";
//            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = makeConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, getHashedPassword(password));
//            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                user = new User();
                user.name = rs.getString("name");
                user.email = rs.getString("email");
                user.phone = rs.getString("phone");
                user.address = rs.getString("address");
                // exposed password
//                user.password = rs.getString("password");
            }

            // close connection
            statement.close();
            makeConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private String getHashedPassword(String password){
        MessageDigest md;
        try {
            // it;s not case-sensitive
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte [] messageDigest = md.digest(password.getBytes(StandardCharsets.UTF_8));

        BigInteger bigint = new BigInteger(1, messageDigest);
        // hp = hashed password
        String hp = bigint.toString(16);
        while (hp.length() < 32) {
            hp = "0".concat(hp);
        }

        return hp;
    }


    public void test(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String  originalPassword = password;
//        String  originalPassword = "password";

        String generatedSecuredPasswordHash = generateStrongPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);

        String  originalPassword1 = " ";

        String generatedSecuredPasswordHash1 = generateStrongPasswordHash(originalPassword1);
        System.out.println("Space password: " + generatedSecuredPasswordHash1);

//        boolean matched = validatePassword("password", generatedSecuredPasswordHash);
        boolean matched = validatePassword(password, generatedSecuredPasswordHash);
        System.out.println(matched);

        matched = validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);
    }

    private static String generateStrongPasswordHash(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    private static boolean validatePassword(String originalPassword, String storedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);

        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(),
                salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i < bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    public Connection makeConnection(){
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();

        return databaseConnectionFactory.getConnection();
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
    }

}
