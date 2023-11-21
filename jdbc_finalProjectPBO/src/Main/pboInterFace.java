package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pboInterFace extends JFrame {
    private JPanel panelMain;
    private JTextField txtUsername;
    private JButton buttonClick;
    private JPasswordField passwordField;

    public pboInterFace() {
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
    }

    public static void main(String[] args) {
        pboInterFace frame = new pboInterFace();
        frame.setContentPane(frame.panelMain);
        frame.setBounds(600, 200, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

