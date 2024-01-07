package Home;

import signIn_signUp.loginInterFace;
import signIn_signUp.registerIF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Kelas untuk menangani antarmuka utama (home) aplikasi
public class interfaceHome extends JFrame {
    private JPanel homePanel;
    private JButton HOMEButton;         // Tombol untuk menuju halaman utama
    private JButton EXPLOREButton;      // Tombol untuk menjelajahi aplikasi
    private JButton RESERVATIONButton;  // Tombol untuk membuat reservasi
    private JButton LOGINButton;        // Tombol untuk membuka halaman login
    private JButton REGISTERButton;     // Tombol untuk membuka halaman registrasi
    private JPanel leftCardPanel;
    private JButton selengkapnyaButton; // Tombol "Selengkapnya" 1
    private JButton selengkapnyaButton1; // Tombol "Selengkapnya" 2

    // Konstruktor untuk menginisialisasi antarmuka home
    public interfaceHome() {
        // Menambahkan action listener pada tombol login
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });

        // Menambahkan action listener pada tombol reservation
        RESERVATIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });

        // Menambahkan action listener pada tombol explore
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
                loginInterFace frame = new loginInterFace();
                frame.interfaceLogin();
                setVisible(false);
            }
        });

        // Menambahkan action listener pada tombol register
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerIF frame = new registerIF();
                frame.interfaceRegist();
                setVisible(false);
            }
        });

        // Membuat listener umum untuk beberapa tombol selengkapnya
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RESERVATIONButton, "Log In Terlebih Dahulu!");
            }
        };

        // Menambahkan listener ke tombol-tombol selengkapnya
        selengkapnyaButton.addActionListener(listener);
        selengkapnyaButton1.addActionListener(listener);
    }

    // Metode statis untuk menampilkan antarmuka home
    public static void homeIF() {
        interfaceHome frame = new interfaceHome();
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metode main untuk menjalankan aplikasi
    public static void main(String[] args) {
        homeIF();
    }
}
