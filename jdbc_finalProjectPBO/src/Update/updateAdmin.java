package Update;

import signIn_signUp.importSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateAdmin extends JFrame {
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton usernameButton;
    private JButton REGISTERButton;
    private JTextField textNoKamar;
    private JTextField textKapasitas;
    private JTextField textHarga;
    private JTextField textImgPath;
    private JTextField textDeskripsi;
    private JTextField textTipeKamar;
    private JTextField textNamaHotel;
    private JTextField textSearch;
    private JButton cariButton;
    private JButton updateButton;
    private JLabel nokamar;
    private JLabel imgpath;
    private JLabel namahotel;
    private JLabel tipekamar;
    private JLabel deskripsi;
    private JLabel kapasitas;
    private JLabel harga;

    public updateAdmin(String username){
        usernameButton.setText(username);
        cariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importSQL.importData();
                importSQL.Product check = new importSQL().new Product();
                check.desired(textSearch.getText());
                if(check.getFinded()){
                    nokamar.setText(check.getNoKamar());
                    imgpath.setText(check.getImg());
                    namahotel.setText(check.getNamahotel());
                    tipekamar.setText(check.getTipekamar());
                    deskripsi.setText(check.getDeskripsi());
                    String kpts = Integer.toString(check.getKapasitas());
                    kapasitas.setText(kpts);
                    String hrg = Double.toString(check.getHarga());
                    harga.setText(hrg);
                }
                else {
                    JOptionPane.showMessageDialog(cariButton, "Tidak Ditemukan\n(Harus Memasukan No Kamar)");
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importSQL.importData();
                importSQL.Product check = new importSQL().new Product();
                check.desired(textSearch.getText());

                String nokamar = textNoKamar.getText();
                String img = textImgPath.getText();
                String namahotel = textNamaHotel.getText();
                String tipekamar = textTipeKamar.getText();
                String deskripsi = textDeskripsi.getText();
                int kapasitas = Integer.parseInt(textKapasitas.getText());
                double harga = Double.parseDouble(textHarga.getText());

                if(textNoKamar.getText() == null){
                    nokamar = check.getNoKamar();
                }
                if(textImgPath.getText() == null){
                    img = check.getImg();
                }
                if(textNamaHotel.getText() == null){
                    namahotel = check.getNamahotel();
                }
                if(textTipeKamar.getText() == null){
                    tipekamar = check.getTipekamar();
                }
                if(textDeskripsi.getText() == null){
                    deskripsi = check.getDeskripsi();
                }
                if(textKapasitas.getText() == null){
                    kapasitas = check.getKapasitas();
                }
                if(textHarga.getText() == null){
                    harga = check.getHarga();
                }

                importSQL.Update update = new importSQL().new Update();
                update.updateProduct(check.getNoKamar(), nokamar, img, namahotel, tipekamar, deskripsi, kapasitas, harga);
            }
        });
    }

    public static void updateLIF(String username){
        updateAdmin frame = new updateAdmin(username);
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        updateLIF("Gus Ryan");
    }
}
