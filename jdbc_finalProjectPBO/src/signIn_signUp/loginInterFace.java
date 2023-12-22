package signIn_signUp;

import Home.homeLoggedIn;
import Home.interfaceHome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginInterFace extends JFrame {
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JRadioButton showPass;
    private JButton buttonClick;
    private JButton registerButton;
    private JButton forgotPass;
    private JButton kembaliButton;

    public loginInterFace() {

        // Inisialisasi komponen GUI di sini
        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importSQL.importData();
                importSQL.Checking check = new importSQL().new Checking();
                check.desired(txtUsername.getText());
                Login.Authentication authentication = new Login().new Authentication();

                char[] passwordChars = passwordField.getPassword();
                // Mengubah karakter menjadi String
                String password = new String(passwordChars);
                if (authentication.authenticate(check.getUsername(), txtUsername.getText(), check.getPassword(), password)) {
                    JOptionPane.showMessageDialog(buttonClick, "Log In SUKSES!");
                    homeLoggedIn frame = new homeLoggedIn(txtUsername.getText());
                    frame.homeLIF(txtUsername.getText());
                    setVisible(false);
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
                frame.interfaceRegist();
                setVisible(false);
            }
        });
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceHome frame = new interfaceHome();
                frame.homeIF();
                setVisible(false);
            }
        });
    }

    public static void interfaceLogin(){
        loginInterFace frame = new loginInterFace();
        frame.setContentPane(frame.loginPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        interfaceLogin();
    }
}

