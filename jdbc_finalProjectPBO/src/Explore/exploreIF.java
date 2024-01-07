package Explore;

import Home.homeLoggedIn;
import Reservasi.reservasiHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Kelas yang mewakili antarmuka eksplorasi
public class exploreIF extends JFrame {
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton usernameButton;
    private JButton REGISTERButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton cariButton;
    private JTextField textField1;
    private JButton pesan1;
    private JButton pesan2;
    private JButton pesan3;
    private JButton pesan4;
    private JButton pesan5;
    private JButton pesan6;

    // Konstruktor dengan parameter username
    public exploreIF(String user){
        // Mengambil username dari parameter dan menampilkan di tombol username
        String username = user;
        usernameButton.setText(username);

        // Menambahkan listener untuk tombol HOME
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame homeLoggedIn dan menampilkan antarmuka homeLoggedIn
                homeLoggedIn frame = new homeLoggedIn(username);
                frame.homeLIF(username);
                setVisible(false);
            }
        });

        // Menambahkan listener untuk tombol RESERVATION
        RESERVATIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame reservasiHotel dan menampilkan antarmuka reservasiHotel
                reservasiHotel frame = new reservasiHotel(username);
                frame.interfaceReservation(username);
                setVisible(false);
            }
        });

        // Membuat listener umum untuk beberapa tombol pesan
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame reservasiHotel dan menampilkan antarmuka reservasiHotel
                reservasiHotel frame = new reservasiHotel(username);
                frame.interfaceReservation(username);
                setVisible(false);
            }
        };

        // Menambahkan listener ke tombol-tombol pesan
        pesan1.addActionListener(listener);
        pesan2.addActionListener(listener);
        pesan3.addActionListener(listener);
        pesan6.addActionListener(listener);
        pesan5.addActionListener(listener);
        pesan4.addActionListener(listener);
    }

    // Metode statis untuk menampilkan antarmuka eksplorasi
    public static void interfaceExplore(String username){
        exploreIF frame = new exploreIF(username);
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
