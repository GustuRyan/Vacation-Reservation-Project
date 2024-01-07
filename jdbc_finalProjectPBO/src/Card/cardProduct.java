package Card;

import javax.swing.*;
import java.awt.*;

// Kelas yang merepresentasikan frame produk kartu
public class cardProduct extends JFrame {
    public JPanel product;   // Panel untuk menampung konten produk
    private JButton button1;  // Tombol untuk suatu tindakan

    // Konstruktor
    public cardProduct(){
        setLayout(new BorderLayout());  // Mengatur tata letak ke BorderLayout
    }

    // Getter untuk panel produk
    public JPanel getProductPanel() {
        return product;
    }

    // Metode statis untuk menampilkan frame produk kartu
    public static void showCard (){
        cardProduct frame = new cardProduct();  // Membuat instansi frame cardProduct
        frame.setContentPane(frame.product);   // Mengatur content pane ke panel produk
        frame.pack();   // Menyesuaikan ukuran frame dengan kontennya
        frame.setVisible(true);   // Membuat frame terlihat
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Mengatur operasi penutupan default
    }
}
