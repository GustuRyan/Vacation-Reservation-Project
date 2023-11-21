import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Trial {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "Root.127gusryan";

        try {
            // Memastikan driver terdaftar
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Menghubungkan ke database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null) {
                System.out.println("Koneksi ke database berhasil!");
                // Lakukan operasi database di sini

                // Tutup koneksi setelah selesai
                connection.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi ke database gagal!");
            e.printStackTrace();
        }
    }
}
