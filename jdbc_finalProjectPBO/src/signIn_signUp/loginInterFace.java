package signIn_signUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginInterFace extends JFrame {
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JButton buttonClick;
    private JPasswordField passwordField;
    private JButton forgotPass;
    private JRadioButton showPass;
    private JButton registerButton;
    private JLabel apakaden;

    public loginInterFace() {

        // Inisialisasi komponen GUI di sini
        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.User user = new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08556545615");
                Login.UserDatabase userDatabase = new Login().new UserDatabase();
                userDatabase.addUser(new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08556545615"));
                Login.Authentication authentication = new Login().new Authentication(userDatabase);

                char[] passwordChars = passwordField.getPassword();
                // Mengubah karakter menjadi String
                String password = new String(passwordChars);

                if (authentication.authenticate(txtUsername.getText(), password)) {
                    JOptionPane.showMessageDialog(buttonClick, "Log In SUKSES!");
                } else {
                    JOptionPane.showMessageDialog(buttonClick, "Log In TIDAK BERHASIL!");
                }

            }
        });
        forgotPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgotPassIF frame = new forgotPassIF();
                frame.interfaceForgotPass();
                setVisible(false);
            }
        });
        showPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (showPass.isSelected()){
                        passwordField.setEchoChar((char)0);
                    }
                    else{
                        passwordField.setEchoChar('\uF09F');
                    }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerIF frame = new registerIF();
                frame.registInterFace();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        loginInterFace frame = new loginInterFace();
        frame.setContentPane(frame.loginPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

