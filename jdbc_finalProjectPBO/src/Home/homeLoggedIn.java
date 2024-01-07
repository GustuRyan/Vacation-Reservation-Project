package Home;

import Explore.exploreIF;
import Reservasi.reservasiHotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Kelas yang mewakili antarmuka beranda untuk pengguna yang sudah masuk
public class homeLoggedIn extends JFrame {
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton usernameButton;
    private JButton REGISTERButton;
    private JPanel leftCardPanel;
    private JButton selengkapnyaButton;
    private JButton selengkapnyaButton1;

    // Konstruktor dengan parameter username
    public homeLoggedIn(String user){
        // Mengambil username dari parameter dan menampilkan di tombol username
        String username = user;
        usernameButton.setText(username);

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

        // Menambahkan listener untuk tombol EXPLORE
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame exploreIF dan menampilkan antarmuka exploreIF
                exploreIF frame = new exploreIF(username);
                frame.interfaceExplore(username);
                setVisible(false);
            }
        });

        // Membuat listener umum untuk beberapa tombol selengkapnya
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame exploreIF dan menampilkan antarmuka exploreIF
                exploreIF frame = new exploreIF(username);
                frame.interfaceExplore(username);
                setVisible(false);
            }
        };

        // Menambahkan listener ke tombol-tombol selengkapnya
        selengkapnyaButton.addActionListener(listener);
        selengkapnyaButton1.addActionListener(listener);
    }

    // Metode statis untuk menampilkan antarmuka beranda pengguna yang sudah masuk
    public static void homeLIF(String username){
        homeLoggedIn frame = new homeLoggedIn(username);
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
