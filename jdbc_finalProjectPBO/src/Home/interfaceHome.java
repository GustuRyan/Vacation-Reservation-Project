package Home;

import signIn_signUp.loginInterFace;
import signIn_signUp.registerIF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaceHome  extends  JFrame  {
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton LOGINButton;
    private JButton REGISTERButton;
    private JPanel leftCardPanel;
    private JButton selengkapnyaButton;
    private JButton selengkapnyaButton1;

    public interfaceHome(){

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });
        RESERVATIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerIF frame = new registerIF();
                frame.interfaceRegist();
                setVisible(false);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
            }
        };
        selengkapnyaButton.addActionListener(listener);
        selengkapnyaButton1.addActionListener(listener);
    }

    public static void homeIF(){
        interfaceHome frame = new interfaceHome();
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        homeIF();
    }
}
