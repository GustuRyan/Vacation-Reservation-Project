package signIn_signUp;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    /**
     * User
     */
    class User {
        private String nama;
        private String password;
        private String email;
        private String phone;

        public User(String nama, String password, String email, String phone) {
            this.nama = nama;
            this.password = password;
            this.email = email;
            this.phone = phone;
        }

        public String getNama() {
            return nama;
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

    /**
     * UserDatabase
     */
    class UserDatabase {
        private ArrayList<User> users;

        public UserDatabase() {
            users = new ArrayList<>();
        }

        public void addUser(User user) {
            users.add(user);
        }

        public User getUserByNama(String nama) {
            for (User user : users) {
                if (user.getNama().equals(nama)) {
                    return user;
                }
            }
            return null;
        }
    }

    /**
     * Authentication
     */
    class Authentication {
        private UserDatabase userDatabase;

        public Authentication(UserDatabase userDatabase) {
            this.userDatabase = userDatabase;
        }

        public boolean authenticate(String nama, String password) {
            User user = userDatabase.getUserByNama(nama);
            return user != null && user.getPassword().equals(password);
        }
    }

    class ForgotPass {
        private  String username;
        private String email;
        private String phoneNum;
        private String newPass;
        private String inputUser;
        private boolean confirm = false;
        Scanner scanner = new Scanner(System.in);

        public void reAunthentication(String userName, String email, String phone){
            this.username = userName;
            this.email = email;
            this.phoneNum = phone;

            User user = new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08123456789");
            if(username.equals(user.getNama()) & email.equals((user.getEmail())) & phone.equals(user.getPhone())){
                confirm = true;
            }
        }

        public boolean getConfirm(){
            return confirm;
        }

        public void inputUsername(String userName, String email, String phone) {
            this.email = email;
            this.phoneNum = phone;
            System.out.println("Masukan username dari akun anda");
            inputUser = scanner.nextLine();
            if (userName.equals(inputUser)) {
                inputPhone();
            }
        }

        public void inputPhone() {
            System.out.println("Masukan nomor handphone dari akun anda");
            inputUser = scanner.nextLine();
            if (phoneNum.equals(inputUser)) {
                inputemail();
            }
        }

        public void inputemail() {
            System.out.println("Masukan alamat email dari akun anda");
            inputUser = scanner.nextLine();
            if (email.equals(inputUser)) {
                boolean konfirmasi = false;
                do {
                    System.out.print("Masukkan password anda : ");
                    this.newPass = scanner.nextLine();
                    System.out.print("Masukkan password anda kembali: ");
                    inputUser = scanner.nextLine();

                    if (newPass.equals(inputUser)) {
                        System.out.println("\nPASSWORD TELAH BERHASIL DIKONFIRMASI\n");
                        konfirmasi = true;
                    } else {
                        System.out.println("\nPASSWORD TIDAK BERHASIL DIKONFIRMASI\nMASUKAN ULANG PASSWORD\n");
                    }
                } while (!konfirmasi);
            }
        }
    }

    public class SignIn {
        public static void main(String[] args) {
            User user = new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08123456789");
            UserDatabase userDatabase = new Login().new UserDatabase();
            userDatabase.addUser(new Login().new User("Wipra", "wipra123", "wipra@gmail.com", "08123456789"));
            int i = 1;
            ForgotPass forgot = new Login().new ForgotPass();

            String emailMain = user.getEmail();
            String phoneMain = user.getPhone();

            Authentication authentication = new Login().new Authentication(userDatabase);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Selamat Datang di Aplikasi Manajemen Hotel");
            System.out.println("Username : ");
            String namaInput = scanner.nextLine();
            System.out.println("Password: \n(Apabila lupa password ketik 'iya')");
            String passwordInput = scanner.nextLine();

            if (passwordInput.equals("iya")) {
                forgot.inputUsername(namaInput, emailMain, phoneMain);
            }

            boolean checkPass = false;
            do {
                if (authentication.authenticate(namaInput, passwordInput)) {
                    System.out.println("\nLog-in Berhasil!");
                    checkPass = true;
                } else {
                    System.out
                            .println("Log-in Gagal. Silahkan coba lagi. \n\nMasukan kembali password anda \n(percobaan " + i + " dari 3)");
                    passwordInput = scanner.nextLine();
                    if(i >= 3){
                        System.out.println("\nAnda gagal Log-in karena memasukan password yang salah berulang kali. \nProgram akan otomatis berhenti!");
                        return;
                    }
                    i = i + 1;
                }
            } while (!checkPass && i <= 4);
            scanner.close();
        }
    }
}