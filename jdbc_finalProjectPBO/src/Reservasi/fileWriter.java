package Reservasi;

//  Kelas yang merepresentasikan frame reservasi hotel
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Kelas untuk menulis informasi reservasi ke dalam file
public class fileWriter {
    // Metode untuk menulis informasi reservasi ke dalam file
    public static void writeToFile(String nama, String email, String telepon, String jenisKamar,
                                   double hargaKamar, String day, String month, String year,
                                   int jumlahKamar, String jumlahMalam) {
        try {
            // Membuat objek FileWriter untuk menulis ke file teks
            FileWriter fileWriter = new FileWriter("C:\\Users\\gus ryan\\Documents\\NotaReservasi.txt", true);

            // Format tanggal saat ini dalam format "dd/MM/yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            // Mendapatkan tanggal saat ini
            String currentDate = dateFormat.format(new Date());

            // Mendapatkan tanggal, bulan, dan tahun secara terpisah
            String[] dateParts = currentDate.split("/");

            // Menulis informasi reservasi ke dalam file
            fileWriter.write("\n<><>=====<><><><{{<<>>}}><><><>=====<><>\n");
            fileWriter.write("Nama Lengkap: " + nama + "\n"); // Menulis nama
            fileWriter.write("Email: " + email + "\n"); // Menulis email
            fileWriter.write("Nomor Telepon: " + telepon + "\n"); // Menulis nomor telepon
            fileWriter.write("Tipe Kamar: " + jenisKamar + "\n"); // Menulis tipe kamar
            fileWriter.write("Harga Kamar: Rp. " + hargaKamar + "\n"); // Menulis harga kamar
            fileWriter.write("Jumlah Kamar: " + jumlahKamar + "\n"); // Menulis jumlah kamar
            fileWriter.write("Tanggal: " + day + "\n"); // Menulis tanggal
            fileWriter.write("Bulan: " + month + "\n"); // Menulis bulan
            fileWriter.write("Tahun: " + year + "\n"); // Menulis tahun
            fileWriter.write("<><>=====<><><><{{<<>>}}><><><>=====<><>\n");

            // Menutup file
            fileWriter.close();
            
            // Menampilkan pesan bahwa informasi reservasi telah ditulis ke dalam file
            System.out.println("Informasi Reservasi telah ditulis ke dalam file (NotaReservasi.txt).");
        } catch (IOException e) {
            // Menampilkan pesan kesalahan jika terjadi kesalahan saat menulis ke file
            e.printStackTrace();
        }
    }
}
