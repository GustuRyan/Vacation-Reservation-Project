package signIn_signUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {
    class User {
        private List<String> userName = new ArrayList<>();
        private List<String> passWord = new ArrayList<>();
        private List<String> phoneNum = new ArrayList<>();
        private List<String> email = new ArrayList<>();

        public List<String> getuserName() {
            return userName;
        }

        public List<String> getpassWord() {
            return passWord;
        }

        public List<String> getphoneNum() {
            return phoneNum;
        }

        public List<String> getEmail() {
            return email;
        }
    }

    class RegisterUser {
        private String userNm;
        private String passW;
        private String userPhn;
        private String userEml;
        Scanner scanner = new Scanner(System.in);

        public String getUsername() {
            return userNm;
        }

        public void RegisUser() {
            System.out.print("Masukkan username anda : ");
            this.userNm = scanner.nextLine();
        }

        public String getPassword() {
            return passW;
        }

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

        public String getPhoneNum() {
            return userPhn;
        }

        public void RegisPhone() {
            System.out.print("Masukkan nomor handphone anda : ");
            this.userPhn = scanner.nextLine();
        }

        public String getEmail() {
            return userEml;
        }

        public void RegisEmail() {
            System.out.print("Masukkan alamat email anda : ");
            this.userEml = scanner.nextLine();
        }
    }

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
