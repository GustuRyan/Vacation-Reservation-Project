package signIn_signUp;

import Home.homeLoggedIn;
import Home.interfaceHome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Kelas yang mengatur antarmuka login
public class loginInterFace extends JFrame {
    private JPanel loginPanel;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private JRadioButton showPass;
    private JButton buttonClick;
    private JButton registerButton;
    private JButton forgotPass;
    private JButton kembaliButton;

    // Konstruktor untuk menginisialisasi antarmuka login
    public loginInterFace() {
        // Menambahkan ActionListener untuk tombol "Log In"
        buttonClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Melakukan impor data dan pemeriksaan otentikasi
                importSQL.importData();
                importSQL.Checking check = new importSQL().new Checking();
                check.desired(txtUsername.getText());
                Login.Authentication authentication = new Login().new Authentication();

                char[] passwordChars = passwordField.getPassword();
                // Mengubah karakter menjadi String
                String password = new String(passwordChars);

                // Memeriksa otentikasi dan memberikan feedback
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

        // Menambahkan ActionListener untuk tombol "Lupa Password"
        forgotPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgotPassIF frame = new forgotPassIF();
                frame.interfaceForgotPass();
                setVisible(false);
            }
        });

        // Menambahkan ActionListener untuk tombol "Tampilkan Password"
        showPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPass.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('\uF09F');
                }
            }
        });

        // Menambahkan ActionListener untuk tombol "Daftar"
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerIF frame = new registerIF();
                frame.interfaceRegist();
                setVisible(false);
            }
        });

        // Menambahkan ActionListener untuk tombol "Kembali"
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfaceHome frame = new interfaceHome();
                frame.homeIF();
                setVisible(false);
            }
        });
    }

    // Metode statis untuk menampilkan antarmuka login
    public static void interfaceLogin() {
        loginInterFace frame = new loginInterFace();
        frame.setContentPane(frame.loginPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metode main untuk menjalankan antarmuka login
    public static void main(String[] args) {
        interfaceLogin();
    }
}
