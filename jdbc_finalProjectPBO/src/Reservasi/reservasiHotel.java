package Reservasi;

import signIn_signUp.loginInterFace;
import signIn_signUp.registerIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class reservasiHotel extends JFrame {
    private JButton HOMEButton;
    private JButton REGISTERButton;
    private JButton LOGINButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JPanel reservationPanel;
    private JTextField textField1;
    private JButton clickMeButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField ddsaTextField;
    private JTextField textField6;
    private JTextField textField7;
    private JButton button1;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button3;
    private JSpinner jumlahKamar2;
    private JTextPane DELUXEHarga2000kTersediaTextPane;
    private JSpinner jumlahKamar1;
    private JSpinner jumlahKamar3;
    private JCheckBox checkBox1;

    public reservasiHotel() {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaLengkap = textField1.getText();
                JOptionPane.showMessageDialog(clickMeButton, "Nama Lengkap : " + namaLengkap);
            }
        });

        jumlahKamar1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                    super.componentResized(e);
                    SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 30, 1);
                    jumlahKamar1.setModel(newModel);
            }
        });

        jumlahKamar2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                super.componentResized(e);
                SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 15, 1);
                jumlahKamar2.setModel(newModel);
            }
        });

        jumlahKamar3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                super.componentResized(e);
                SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 5, 1);
                jumlahKamar3.setModel(newModel);
            }
        });
    }

    public static void interfaceReservation(){
        reservasiHotel frame = new reservasiHotel();
        frame.setContentPane(frame.reservationPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        interfaceReservation();
    }

    private void createUIComponents () {
        // TODO: place custom component creation code here
        if (HOMEButton != null) {
            HOMEButton.setBorderPainted(false);
            HOMEButton.setBackground(new Color(39, 69, 122));
        }
    }

}