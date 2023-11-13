import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trial {
    public static void main(String[] args) {
        // Memuat driver MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Gagal memuat driver MySQL.");
            e.printStackTrace();
            return;
        }

        String jdbcUrl = "jdbc:mysql://localhost:127.0.0.1/classicmodels";
        String username = "root";
        String password = "Root.127gusryan";

        // ...
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Koneksi ke MySQL berhasil!");

            // Membuat pernyataan SQL INSERT
            String insertQuery = "INSERT INTO customers (customerNumber, customerName, phone) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Mengisi nilai parameter pada pernyataan
            preparedStatement.setString(1, "NilaiKolom1");
            preparedStatement.setString(2, "NilaiKolom2");
            preparedStatement.setString(3, "NilaiKolom3");

            // Menjalankan pernyataan INSERT
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke database.");
            } else {
                System.out.println("Gagal memasukkan data ke database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Gagal terhubung ke MySQL.");
        } finally {
            // Pastikan untuk menutup koneksi saat selesai
            // ...
        }

    }
}
