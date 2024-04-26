package GUI;

import domain.User;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ProfileForm extends JDialog  {
    private JPanel profilePanel;
    private JLabel profilePicture;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;

    public User user;
    private String profile_image_url = "/flaticons/default_profile_image.png";

    public ProfileForm(JFrame parent, User current_user) {
        super(parent);
        setTitle("Profile");
        setContentPane(profilePanel);
        setMinimumSize(new Dimension(600, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        URL imageUrl = getClass().getResource(profile_image_url);
        Image image = toolkit.getImage( imageUrl );


//        String email = textFieldEmail.getText();
//        String password = String.valueOf(passwordFieldLogin.getPassword());

        profilePicture.setIcon(new ImageIcon(image));
        nameField.setText(current_user.name);
        emailField.setText(current_user.email);
        phoneField.setText(current_user.phone);
        addressField.setText(current_user.address);

        setVisible(true);
    }

    public static void main(String[] args) {
        // dump user's data
        User user = new User();
        user.name = "name";
        user.phone = "phone";
        user.email = "email";
        user.address = "address";
        ProfileForm profileForm = new ProfileForm(null, user);
    }

}