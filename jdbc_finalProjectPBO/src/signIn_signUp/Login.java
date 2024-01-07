package signIn_signUp;

import java.util.Scanner;

// Kelas untuk menangani proses login
public class Login {

    // Kelas untuk otentikasi pengguna
    class Authentication {
        // Metode untuk memeriksa apakah informasi otentikasi sesuai
        public boolean authenticate(String namaauth, String nama, String passauth, String password) {
            // Membandingkan username dan password
            if (namaauth.equals(nama) && passauth.equals(password)){
                return true;
            };
            return false;
        }
    }

    // Kelas untuk mengelola proses lupa password
    class ForgotPass {
        private String username;
        private String email;
        private String phoneNum;
        private String newPass;
        private String inputUser;
        private boolean confirm = false;
        Scanner scanner = new Scanner(System.in);

        // Metode untuk melakukan re-authentication dengan informasi yang diberikan
        public void reAunthentication(String userName, String namaauth, String email, String emailauth, String phone, String phoneauth) {
            this.username = userName;
            this.email = email;
            this.phoneNum = phone;

            // Memeriksa apakah informasi yang diberikan sesuai dengan data di database
            if (username.equals(namaauth) && email.equals(emailauth) && phone.equals(phoneauth)) {
                confirm = true;
            }
        }

        // Getter untuk mendapatkan status konfirmasi
        public boolean getConfirm() {
            return confirm;
        }

        // Metode utama (tidak diimplementasikan di sini)
        public static void main(String[] args) {

        }
    }
}