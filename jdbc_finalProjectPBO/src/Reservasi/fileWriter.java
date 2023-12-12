package Reservasi;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileWriter {
    public static void writeToFile(String nama, String email, String telepon, String jenisKamar, double hargaKamar, String day, String month, String year, int jumlahKamar, String jumlahMalam) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\gus ryan\\Documents\\NotaReservasi.txt", true);

            // Format the current date in "dd/MM/yyyy" format
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = dateFormat.format(new Date());

            // Get day, month, and year separately
            String[] dateParts = currentDate.split("/");

            // Write reservation information to the file
            fileWriter.write("\n<><>=====<><><><{{<<>>}}><><><>=====<><>\n");
            fileWriter.write("Nama Lengkap: " + nama + "\n");
            fileWriter.write("Email: " + email + "\n");
            fileWriter.write("Nomor Telepon: " + telepon + "\n");
            fileWriter.write("Tipe Kamar: " + jenisKamar + "\n");
            fileWriter.write("Harga Kamar: Rp. " + hargaKamar + "\n");
            fileWriter.write("Jumlah Kamar: " + jumlahKamar + "\n");
            fileWriter.write("Tanggal: " + day + "\n");
            fileWriter.write("Bulan: " + month + "\n");
            fileWriter.write("Tahun: " + year + "\n");
            fileWriter.write("<><>=====<><><><{{<<>>}}><><><>=====<><>\n");

            fileWriter.close();

            System.out.println("Informasi Reservasi telah ditulis ke dalam file (Tes.txt).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
