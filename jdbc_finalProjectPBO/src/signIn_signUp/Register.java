package signIn_signUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas untuk menangani proses registrasi pengguna
public class Register {
    // Kelas untuk menyimpan data pengguna
    class User {
        private List<String> userName = new ArrayList<>();
        private List<String> passWord = new ArrayList<>();
        private List<String> phoneNum = new ArrayList<>();
        private List<String> email = new ArrayList<>();

        // Getter untuk mendapatkan informasi nama pengguna
        public List<String> getuserName() {
            return userName;
        }

        // Getter untuk mendapatkan informasi kata sandi
        public List<String> getpassWord() {
            return passWord;
        }

        // Getter untuk mendapatkan informasi nomor telepon
        public List<String> getphoneNum() {
            return phoneNum;
        }

        // Getter untuk mendapatkan informasi alamat email
        public List<String> getEmail() {
            return email;
        }
    }

    // Kelas untuk menangani proses registrasi pengguna baru
    class RegisterUser {
        private String userNm;
        private String passW;
        private String userPhn;
        private String userEml;
        Scanner scanner = new Scanner(System.in);

        // Getter untuk mendapatkan nama pengguna
        public String getUsername() {
            return userNm;
        }

        // Metode untuk mendapatkan nama pengguna dari pengguna
        public void RegisUser() {
            System.out.print("Masukkan username anda : ");
            this.userNm = scanner.nextLine();
        }

        // Getter untuk mendapatkan kata sandi
        public String getPassword() {
            return passW;
        }

        // Metode untuk mendapatkan kata sandi dari pengguna dan melakukan konfirmasi
        public void RegisPass() {
            boolean konfirmasi = false;
            do {
                System.out.print("Masukkan password anda : ");
                this.passW = scanner.nextLine();
                System.out.print("Masukkan password anda kembali: ");
                String makeSure = scanner.nextLine();

                if (passW.equals(makeSure)) {
                    System.out.println("\nPASSWORD DARI USERNAME " + userNm + " TELAH BERHASIL DIKONFIRMASI\n");
                    konfirmasi = true;
                } else {
                    System.out.println("\nPASSWORD TIDAK BERHASIL DIKONFIRMASI\nMASUKAN ULANG PASSWORD\n");
                }
            } while (!konfirmasi);
        }

        // Getter untuk mendapatkan nomor telepon
        public String getPhoneNum() {
            return userPhn;
        }

        // Metode untuk mendapatkan nomor telepon dari pengguna
        public void RegisPhone() {
            System.out.print("Masukkan nomor handphone anda : ");
            this.userPhn = scanner.nextLine();
        }

        // Getter untuk mendapatkan alamat email
        public String getEmail() {
            return userEml;
        }

        // Metode untuk mendapatkan alamat email dari pengguna
        public void RegisEmail() {
            System.out.print("Masukkan alamat email anda : ");
            this.userEml = scanner.nextLine();
        }
    }

    // Metode utama untuk menjalankan uji coba
    public static void main(String[] args) {
        User pengguna = new Register().new User();
        pengguna.getuserName().add("Joni");
        pengguna.getuserName().add("Goni");
        pengguna.getpassWord().add("Joni88");
        pengguna.getpassWord().add("Goni77");
        pengguna.getphoneNum().add("08134653154");
        pengguna.getphoneNum().add("08564545131");
        pengguna.getEmail().add("Joni.88@gmail.com");
        pengguna.getEmail().add("Goni.77@gmail.com");

        RegisterUser regis = new Register().new RegisterUser();

        regis.RegisUser();
        pengguna.getuserName().add(regis.getUsername());

        regis.RegisPass();
        pengguna.getpassWord().add(regis.getPassword());

        regis.RegisPhone();pengguna.getphoneNum().add(regis.getPhoneNum());

        regis.RegisEmail();pengguna.getEmail().add(regis.getEmail());

        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            System.out.println("Nama pengguna ke " + j + " adalah " + pengguna.getuserName().get(i) + "\nPassword pengguna ke " + j + " adalah " + pengguna.getpassWord().get(i) + "\nEmail pengguna ke " + j + " adalah" + pengguna.getEmail().get(i) + "\nNomor telepon pengguna ke " + j + " adalah " + pengguna.getphoneNum().get(i) + "\n");
        }
    }
}
