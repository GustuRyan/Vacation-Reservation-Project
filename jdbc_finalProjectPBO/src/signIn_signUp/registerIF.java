package signIn_signUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerIF extends JFrame {
    private JPanel registAccPanel;
    private JLabel registPanel;
    private JTextField regisUsername;
    private JTextField regisEmail;
    private JLabel textField2;
    private JTextField regisPhone;
    private JLabel regisNewPass;
    private JLabel reenterNewPass;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton confirmButton;
    private JRadioButton showPass1;
    private JButton backButton;
    private JLabel RightImage;
    private JLabel TopImage;

    public registerIF() {
        // Panggil metode untuk membuat komponen UI khusus
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showPass1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPass1.isSelected()){
                    passwordField1.setEchoChar((char)0);
                    passwordField2.setEchoChar((char)0);
                }
                else{
                    passwordField1.setEchoChar('\uF09F');
                    passwordField2.setEchoChar('\uF09F');
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });
    }

    public void interfaceRegist() {
        registerIF frame = new registerIF();
        frame.setContentPane(frame.registAccPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
