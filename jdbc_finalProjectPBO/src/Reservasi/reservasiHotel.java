package Reservasi;

import Explore.exploreIF;
import Home.homeLoggedIn;
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
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JPanel reservationPanel;
    private JTextField tanggalTextField;
    private JButton clickMeButton;
    private JTextField bulanTextField;
    private JTextField tahunTextField;
    private JTextField emailTextField;
    private JTextField teleponTextField;
    private JTextField namaTextField;
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
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JTextField lamaBook;
    private JButton usernameButton;

    public reservasiHotel(String user) {
        String username = user;
        usernameButton.setText(username);
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipeKamar = null;
                double hargaKamar = 0;
                int jumlahKamar = 1;
                if (checkBox1.isSelected()){
                    tipeKamar = "SINGLE";
                    hargaKamar = 750000.00;
                    jumlahKamar = (int) jumlahKamar1.getValue();
                } else if (checkBox2.isSelected()) {
                    tipeKamar = "DOUBLE";
                    hargaKamar = 1250000.00;
                    jumlahKamar = (int) jumlahKamar2.getValue();
                } else if (checkBox3.isSelected()) {
                    tipeKamar = "DELUXE";
                    hargaKamar = 2000000.00;
                    jumlahKamar = (int) jumlahKamar3.getValue();
                }

                fileWriter.writeToFile(namaTextField.getText(), emailTextField.getText(), teleponTextField.getText(), tipeKamar, hargaKamar,
                        tanggalTextField.getText(), bulanTextField.getText(), tahunTextField.getText(), jumlahKamar, lamaBook.getText());
                JOptionPane.showMessageDialog(clickMeButton, "Nota Pemesanan sudah berhasil dibuat");
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
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerIF frame = new registerIF();
                frame.interfaceRegist();
                setVisible(false);
            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeLoggedIn frame = new homeLoggedIn(username);
                frame.homeLIF(username);
                setVisible(false);
            }
        });
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exploreIF frame = new exploreIF(username);
                frame.interfaceExplore(username);
                setVisible(false);
            }
        });
    }

    public static void interfaceReservation(String username){
        reservasiHotel frame = new reservasiHotel(username);
        frame.setContentPane(frame.reservationPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents () {
        // TODO: place custom component creation code here
        if (HOMEButton != null) {
            HOMEButton.setBorderPainted(false);
            HOMEButton.setBackground(new Color(39, 69, 122));
        }
    }

}