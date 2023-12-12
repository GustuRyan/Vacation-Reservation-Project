package signIn_signUp;

import java.util.Scanner;

public class Login {

    class Authentication {
        public boolean authenticate(String namaauth, String nama, String passauth, String password) {
            if (namaauth.equals(nama) && passauth.equals(password)){
                return true;
            };
            return false;
        }
    }

    class ForgotPass {
        private String username;
        private String email;
        private String phoneNum;
        private String newPass;
        private String inputUser;
        private boolean confirm = false;
        Scanner scanner = new Scanner(System.in);

        public void reAunthentication(String userName, String namaauth, String email, String emailauth, String phone, String phoneauth) {
            this.username = userName;
            this.email = email;
            this.phoneNum = phone;

            if (username.equals(namaauth) && email.equals(emailauth) && phone.equals(phoneauth)) {
                confirm = true;
            }
        }

        public boolean getConfirm() {
            return confirm;
        }

        public static void main(String[] args) {

        }
    }
}