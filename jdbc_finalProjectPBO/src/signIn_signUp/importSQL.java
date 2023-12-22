package signIn_signUp;

import java.sql.*;

public class importSQL {

    // Membuat variabel koneksi global
    private static Connection connection;

    public static void importData() {
        String jdbcURL = "jdbc:mysql://localhost:3306/fppbo?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";

        try {
            // Memastikan driver terdaftar
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Menghubungkan ke database
            connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null) {
                System.out.println("Koneksi ke database berhasil!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi ke database gagal!");
            e.printStackTrace();
        }
    }

    class Checking {
        private String subject;
        private String username;
        private String password;
        private  String email;
        private  String phone;

        public void desired(String subject) {
            this.subject = subject;

            try {
                // Pernyataan SQL untuk memeriksa keberadaan username
                String sql = "SELECT * FROM customer WHERE NamaUser = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, subject);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        this.username = resultSet.getString("NamaUser");
                        this.password = resultSet.getString("PasswordUser");
                        this.email = resultSet.getString("EmailUser");
                        this.phone = resultSet.getString("Telepon");
                        // Username ditemukan dalam database
                        System.out.println("Username sudah ada dalam database.");
                    } else {
                        // Username tidak ditemukan dalam database
                        System.out.println("Username belum ada dalam database.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public String getUsername(){
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }
    }

    class Update {
        public void updatePass(String nama, String password){
            String sql = "UPDATE customer SET PasswordUser = ? WHERE NamaUser = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, nama);

                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Data berhasil diperbarui.");
                } else {
                    System.out.println("Data tidak ditemukan untuk diperbarui.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Insert {
        public void regist(String nama, String password, String email, String telepon){
            String sql = "INSERT INTO customer (NamaUser, PasswordUser, EmailUser, Telepon) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nama);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, telepon);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Data berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan data.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        Checking pointer = new importSQL().new Checking();
        importData();
        pointer.desired("Wipra");
    }
}
