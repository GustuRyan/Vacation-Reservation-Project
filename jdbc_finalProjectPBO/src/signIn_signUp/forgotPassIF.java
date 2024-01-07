package signIn_signUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Kelas untuk antarmuka lupa password
public class forgotPassIF extends JFrame {

    JPanel forgotPassPanel;
    private JLabel forgotPanel;
    private JTextField inputUsername;
    private JTextField inputEmail;
    private JTextField inputPhone;
    private JButton nextPanelButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton confirmNewPasswordButton;
    private JLabel textField2;
    private JLabel inputNewPass;
    private JLabel reenterNewPass;
    private JRadioButton showPass1;
    private JButton backButton;

    // Variabel untuk melacak apakah ini pertama kali membuka jendela
    public boolean firstTime = true;

    // Konstruktor untuk menginisialisasi antarmuka lupa password
    public forgotPassIF() {
        // Memeriksa apakah passwordField saat ini terkunci
        boolean isEditable = passwordField1.isEditable();
        boolean isEditable2 = passwordField2.isEditable();
        // Mengganti status kebalikan (mengunci jika terbuka, membuka jika terkunci)
        passwordField1.setEditable(!isEditable);
        passwordField2.setEditable(!isEditable2);

        // Menambahkan ActionListener untuk tombol "Lanjut"
        nextPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Melakukan impor data dan melakukan pemeriksaan data
                importSQL.importData();
                importSQL.Checking check = new importSQL().new Checking();
                check.desired(inputUsername.getText());
                Login.ForgotPass forgot = new Login().new ForgotPass();
                forgot.reAunthentication(inputUsername.getText(), check.getUsername(), inputEmail.getText(), check.getEmail(), inputPhone.getText(), check.getPhone());

                // Memeriksa konfirmasi data dan memberikan feedback
                if (forgot.getConfirm()) {
                    if (firstTime) {
                        boolean isEditable = passwordField1.isEditable();
                        passwordField1.setEditable(!isEditable);

                        boolean isEditable2 = passwordField2.isEditable();
                        passwordField2.setEditable(!isEditable2);
                        firstTime = false;
                    }
                    JOptionPane.showMessageDialog(nextPanelButton, "Data Diri Terkonfirmasi! \n(tutup jendela ini untuk memasukan password baru.)");
                } else {
                    JOptionPane.showMessageDialog(nextPanelButton, "Data Diri Tidak Valid!");
                }
            }
        });

        // Menambahkan ActionListener untuk tombol "Konfirmasi Password Baru"
        confirmNewPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Melakukan pemeriksaan dan pembaruan password
                importSQL.Checking check = new importSQL().new Checking();
                check.desired(inputUsername.getText());

                char[] passwordChars = passwordField1.getPassword();
                String password = new String(passwordChars);
                char[] password2Chars = passwordField2.getPassword();
                String password2 = new String(passwordChars);

                // Memeriksa kecocokan password dan memberikan feedback
                if (password.equals(password2)) {
                    importSQL.Update update = new importSQL().new Update();
                    update.updatePass(check.getUsername(), password);
                    JOptionPane.showMessageDialog(confirmNewPasswordButton, "Password Baru Terkonfirmasi!");
                } else {
                    JOptionPane.showMessageDialog(confirmNewPasswordButton, "Gagal Membuat Password, Kedua Password Berbeda \n(Masukkan ulang password baru!)");
                }
            }
        });

        // Menambahkan ActionListener untuk tombol "Tampilkan Password"
        showPass1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPass1.isSelected()) {
                    passwordField1.setEchoChar((char) 0);
                    passwordField2.setEchoChar((char) 0);
                } else {
                    passwordField1.setEchoChar('\uF09F');
                    passwordField2.setEchoChar('\uF09F');
                }
            }
        });

        // Menambahkan ActionListener untuk tombol "Kembali"
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });
    }

    // Metode untuk menampilkan antarmuka lupa password
    public void interfaceForgotPass() {
        forgotPassIF frame = new forgotPassIF();
        frame.setContentPane(frame.forgotPassPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
