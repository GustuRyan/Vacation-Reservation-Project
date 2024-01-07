package Reservasi;

// Kelas yang merepresentasikan frame reservasi hotel
import Explore.exploreIF;
import Home.homeLoggedIn;
import signIn_signUp.registerIF;

// Kelas yang merepresentasikan frame reservasi hotel
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

// Kelas yang mengatur antarmuka reservasi hotel
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

    // Konstruktor dengan parameter username
    public reservasiHotel(String user) {
        String username = user;
        usernameButton.setText(username);

        // Menambahkan ActionListener untuk tombol "Pesan Sekarang"
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan informasi reservasi dari input pengguna
                String tipeKamar = null;
                double hargaKamar = 0;
                int jumlahKamar = 1;
                if (checkBox1.isSelected()) {
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

                // Menulis informasi reservasi ke dalam file
                fileWriter.writeToFile(namaTextField.getText(), emailTextField.getText(), teleponTextField.getText(),
                        tipeKamar, hargaKamar, tanggalTextField.getText(), bulanTextField.getText(), tahunTextField.getText(),
                        jumlahKamar, lamaBook.getText());

                // Menampilkan pesan konfirmasi
                JOptionPane.showMessageDialog(clickMeButton, "Nota Pemesanan sudah berhasil dibuat");
            }
        });

        // Menambahkan ComponentListener untuk mengatur batasan jumlah kamar berdasarkan jenisnya
        jumlahKamar1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                // Mengatur batasan jumlah kamar berdasarkan jenisnya
                SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 30, 1);
                jumlahKamar1.setModel(newModel);
            }
        });

        // Menambahkan ComponentListener untuk mengatur batasan jumlah kamar berdasarkan jenisnya
        jumlahKamar2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                // Mengatur batasan jumlah kamar berdasarkan jenisnya
                SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 15, 1);
                jumlahKamar2.setModel(newModel);
            }
        });

        jumlahKamar3.addComponentListener(new ComponentAdapter() {
            // Menambahkan ComponentListener untuk mengatur batasan jumlah kamar berdasarkan jenisnya
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                // Mengatur batasan jumlah kamar berdasarkan jenisnya
                SpinnerNumberModel newModel = new SpinnerNumberModel(0, 0, 5, 1);
                jumlahKamar3.setModel(newModel);
            }
        });

        // Menambahkan ActionListener untuk tombol "Daftar"
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat frame registerIF dan menampilkan antarmuka registerIF
                registerIF frame = new registerIF();
                frame.interfaceRegist();
                setVisible(false);
            }
        });

        // Menambahkan ActionListener untuk tombol "Beranda"
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            // Membuat frame homeLoggedIn dan menampilkan antarmuka homeLoggedIn
            public void actionPerformed(ActionEvent e) {
                // Membuat frame homeLoggedIn dan menampilkan antarmuka homeLoggedIn
                homeLoggedIn frame = new homeLoggedIn(username);
                // Menampilkan antarmuka homeLoggedIn
                frame.homeLIF(username);
                // Menyembunyikan antarmuka reservasiHotel
                setVisible(false);
            }
        });

        // Menambahkan ActionListener untuk tombol "Jelajahi"
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            // Membuat frame exploreIF dan menampilkan antarmuka exploreIF
            public void actionPerformed(ActionEvent e) {
                // Membuat frame exploreIF dan menampilkan antarmuka exploreIF
                exploreIF frame = new exploreIF(username);
                // Menampilkan antarmuka exploreIF
                frame.interfaceExplore(username);
                // Menyembunyikan antarmuka reservasiHotel
                setVisible(false);
            }
        });
    }

    // Metode statis untuk menampilkan antarmuka reservasi
    public static void interfaceReservation(String username) {
        reservasiHotel frame = new reservasiHotel(username);
        // Menampilkan antarmuka reservasi
        frame.setContentPane(frame.reservationPanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metode untuk membuat komponen antarmuka kustom
    private void createUIComponents() {
        // TODO: place custom component creation code here
        if (HOMEButton != null) {
            HOMEButton.setBorderPainted(false);
            // Mengatur warna latar belakang tombol
            HOMEButton.setBackground(new Color(39, 69, 122));
        }
    }
}
