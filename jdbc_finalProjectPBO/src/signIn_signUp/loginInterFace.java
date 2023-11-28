package signIn_signUp;

import Reservasi.reservasiHotel;

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

    public loginInterFace() {

        // Inisialisasi komponen GUI di sini
        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.User user = new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08123456789");
                Login.UserDatabase userDatabase = new Login().new UserDatabase();
                userDatabase.addUser(new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08123456789"));
                Login.Authentication authentication = new Login().new Authentication(userDatabase);

                char[] passwordChars = passwordField.getPassword();
                // Mengubah karakter menjadi String
                String password = new String(passwordChars);

                if (authentication.authenticate(txtUsername.getText(), password)) {
                    JOptionPane.showMessageDialog(buttonClick, "Log In SUKSES!");
                    reservasiHotel frame = new reservasiHotel();
                    frame.interfaceReservation();
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

