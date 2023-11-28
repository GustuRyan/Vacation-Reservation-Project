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
    private JLabel LeftImage;
    private JLabel RightImage;
    private JLabel TopImage;

    public registerIF() {
        // Panggil metode untuk membuat komponen UI khusus
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void registInterFace() {
        registerIF frame = new registerIF();
        frame.setContentPane(frame.registAccPanel);
        frame.setBounds(400, 200, 480, 480);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
