package signIn_signUp;

import java.sql.*;

public class importSQL {

    // Membuat variabel koneksi global
    private static Connection connection;

    public static void importData() {
        String jdbcURL = "jdbc:mysql://localhost:3306/fppbo_database?useSSL=false&serverTimezone=UTC";
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

    public class Checking {
        private String subject;
        private String name;
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
                        this.name = resultSet.getString("NamaUser");
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

        public void desiredAdmin (String subject){
            this.subject = subject;

            try {
                // Pernyataan SQL untuk memeriksa keberadaan username
                String sql = "SELECT * FROM admin WHERE NamaAdmin = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, subject);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        this.name = resultSet.getString("NamaAdmin");
                        this.password = resultSet.getString("PasswordAdmin");
                        this.email = resultSet.getString("EmailAdmin");
                        this.phone = resultSet.getString("KodeAdmin");
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
            return name;
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

    public class Product {
        private String nokamar;
        private String img;
        private String namahotel;
        private String tipekamar;
        private String deskripsi;
        private int kapasitas;
        private double harga;
        private String subject;
        private boolean finded;


        public void desired(String subject) {
            this.subject = subject;

            try {
                // Pernyataan SQL untuk memeriksa keberadaan username
                String sql = "SELECT * FROM produk WHERE NoKamar = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, subject);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        this.nokamar = resultSet.getString("NoKamar");
                        this.img = resultSet.getString("img");
                        this.namahotel = resultSet.getString("NamaHotel");
                        this.tipekamar = resultSet.getString("TipeKamar");
                        this.deskripsi = resultSet.getString("Deskripsi");
                        this.kapasitas = resultSet.getInt("Kapasitas");
                        this.harga = resultSet.getDouble("Harga");
                        // Username ditemukan dalam database
                        System.out.println("produk ada dalam database.");
                        this.finded = true;
                    } else {
                        // Username tidak ditemukan dalam database
                        System.out.println("produk tidak ada dalam database.");
                        this.finded = false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public String getNoKamar(){
            return nokamar;
        }

        public String getImg() {
            return img;
        }

        public String getNamahotel() {
            return namahotel;
        }

        public String getTipekamar() {
            return tipekamar;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public int getKapasitas() {
            return kapasitas;
        }

        public double getHarga() {
            return harga;
        }

        public boolean getFinded() {
            return finded;
        }
    }

    public class Update {
        public boolean updated;
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

        public boolean updateProduct(String key, String nokamar, String img, String namahotel, String tipekamar, String deskripsi, int kapasitas, double harga){
            String sql = "UPDATE produk SET NoKamar = ?, img = ?, NamaHotel = ?, TipeKamar = ?, Deskripsi = ?, Kapasitas = ?, Harga = ?  WHERE NoKamar = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nokamar);
                preparedStatement.setString(2, img);
                preparedStatement.setString(3, namahotel);
                preparedStatement.setString(4, tipekamar);
                preparedStatement.setString(5, deskripsi);
                preparedStatement.setInt(6, kapasitas);
                preparedStatement.setDouble(7, harga);
                preparedStatement.setString(8, key);

                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Data berhasil diperbarui.");
                    return updated = true;
                } else {
                    System.out.println("Data tidak ditemukan untuk diperbarui.");
                    return updated = false;
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
