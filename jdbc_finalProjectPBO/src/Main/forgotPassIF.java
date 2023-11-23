package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class forgotPassIF extends JFrame {

    private JPanel forgotPassPanel;
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

    public boolean firstTime = true;

    public forgotPassIF() {
        // Memeriksa apakah passwordField saat ini terkunci
        boolean isEditable = passwordField1.isEditable();
        boolean isEditable2 = passwordField2.isEditable();
        // Mengganti status kebalikan (mengunci jika terbuka, membuka jika terkunci)
        passwordField1.setEditable(!isEditable);
        passwordField2.setEditable(!isEditable2);
        nextPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.User user = new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08556545615");
                Login.ForgotPass forgot = new Login().new ForgotPass();
                forgot.reAunthentication(inputUsername.getText(), inputEmail.getText(), inputPhone.getText());

                if (forgot.getConfirm()){
                    if(firstTime) {
                        boolean isEditable = passwordField1.isEditable();
                        passwordField1.setEditable(!isEditable);

                        boolean isEditable2 = passwordField2.isEditable();
                        passwordField2.setEditable(!isEditable2);
                        firstTime = false;
                    }
                    JOptionPane.showMessageDialog(nextPanelButton, "Data Diri Terkonfirmasi! \n(tutup jendela ini untuk memasukan password baru.)");
                }
                else {
                    JOptionPane.showMessageDialog(nextPanelButton, "Data Diri Tidak Valid!");
                }
            }
        });
        confirmNewPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField1.getPassword();
                String password = new String(passwordChars);
                char[] password2Chars = passwordField2.getPassword();
                String password2 = new String(passwordChars);

                if (password.equals(password2)){
                    JOptionPane.showMessageDialog(confirmNewPasswordButton, "Password Baru Terkonfirmasi!");
                } else {
                    JOptionPane.showMessageDialog(confirmNewPasswordButton, "Gagal Membuat Password, Kedua Password Berbeda \n(Masukkan ulang password baru!)");
                }
            }
        });

    }
    public static void main(String[] args) {
        forgotPassIF frame = new forgotPassIF();
        frame.setContentPane(frame.forgotPassPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
