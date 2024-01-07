package signIn_signUp;

import java.util.ArrayList;

// Kelas utama aplikasi yang berisi beberapa kelas untuk mengelola layanan, hiburan, kamar hotel, dan pelanggan
public class App {
    // Kelas untuk merepresentasikan layanan umum
    class Service {
        // Atribut-atribut layanan
        public String svcName;
        public String nuance;
        public int quantity;
        public String priceLevel;

        // Konstruktor untuk inisialisasi layanan
        public Service(String svcName, String nuance, int quantity, String priceLevel) {
            this.svcName = svcName;
            this.nuance = nuance;
            this.quantity = quantity;
            this.priceLevel = priceLevel;
        }

        // Mengurangi jumlah layanan
        public void reduceCount(int decrement) {
            quantity -= decrement;
        }

        // Menambah jumlah layanan
        public void addsCount(int increment) {
            quantity += increment;
        }

        // Representasi string dari layanan
        public String toString() {
            return ("Nama layanan : " + svcName + "\nPada layanan ini bernuansa : " + nuance + "\nDengan kapasitas dari layanan : " + quantity + "\nPada tingkat harga : " + priceLevel);
        }
    }

    // Kelas untuk merepresentasikan layanan hiburan
    class Entertainment extends Service {
        // Atribut tambahan untuk layanan hiburan
        public String theme;
        public double time;
        public int i;

        // Konstruktor untuk inisialisasi layanan hiburan
        public Entertainment(String svcName, String nuance, int quantity, String priceLevel, String culture, double defaultTime) {
            super(svcName, nuance, quantity, priceLevel);
            theme = culture;
            time = defaultTime;
        }

        // Mengatur waktu pertunjukan
        public void setTime(double newTime) {
            time = newTime;
        }

        // Representasi string dari layanan hiburan
        @Override
        public String toString() {
            return (super.toString() + "\nTema dari hiburan ini : " + theme + "\nDengan waktu pertunjukan : " + time);
        }
    }

    // Kelas untuk merepresentasikan kamar hotel
    class Hotelrooms extends Service {
        // Atribut tambahan untuk kamar hotel
        public String type;
        public String facilities;
        public int roomNumber;
        public int floorNumber;

        // Konstruktor untuk inisialisasi kamar hotel
        public Hotelrooms(String svcName, String nuance, int quantity, String priceLevel, String type, String facilities) {
            super(svcName, nuance, quantity, priceLevel);
            this.type = type;
            this.facilities = facilities;
        }

        // Menampilkan detail kamar hotel
        public void RoomDetails(int roomNumber, int floorNumber, int bedQuan) {
            this.roomNumber = roomNumber;
            this.floorNumber = floorNumber;
            this.quantity = bedQuan;

            System.out.println("\nHOTELROOMS DETAILS : " + "\n=====================" + "\nNomor kamar : " + roomNumber
                    + "\nKamar berada pada lantai : " + floorNumber + "\nJumlah tempat tidur : " + quantity);
        }

        // Representasi string dari kamar hotel
        @Override
        public String toString() {
            return (super.toString() + "\nTipe dari kamar hotel ini : " + type + "\nDengan fasilitas yang ditawarkan : "
                    + facilities);
        }
    }

    // Kelas untuk merepresentasikan pelanggan
    class Customers {
        // Atribut pelanggan
        private String cstmName;
        private int ages;
        private String status;

        // Getter dan setter untuk atribut pelanggan
        public String getName() {
            return cstmName;
        }

        public void setName(String Name) {
            this.cstmName = Name;
        }

        public int getAges() {
            return ages;
        }

        public void setAges(int ages) {
            this.ages = ages;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    // Metode untuk mencetak data (dummy data disini)
    public static String[] printData() {
        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            String result = "[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n"
                    + "TEST" + "\n[[<><><>()<>()<><><><<{{}}>><><><>()<>()<><><>]]\n\n";
            resultList.add(result);
        }
        // Mengonversi ArrayList menjadi array
        String[] arrayResult = resultList.toArray(new String[0]);

        return arrayResult;
    }

    // Kelas untuk uji coba
    public static class Test {
        // Metode utama untuk menjalankan uji coba
        public static void main(String[] args) {
            // Membuat objek pelanggan dan mengatur atributnya
            Customers person = new App().new Customers();
            person.setName ("Putra");
            person.setAges(21);
            person.setStatus("Mahasiswa");

            // Menampilkan informasi pelanggan
            System.out.println("Name : " + person.getName() + "\nUmur : " + person.getAges() + "\nStatus : " + person.getStatus());

            // Menampilkan informasi layanan hiburan
            System.out.println("\nLAYANAN HIBURAN : ");

            Entertainment mb = new App().new Entertainment("Tari Kecak", "Modern", 20, "midrange", "balinese", 8.00);
            System.out.println(mb.toString());

            // Menampilkan informasi kamar hotel
            System.out.println("\nLAYANAN KAMAR HOTEL : ");

            Hotelrooms mn = new App().new Hotelrooms("Suiteroom", "Contemporary", 10, "expensive", "Suite", "Private bathroom");
            System.out.println(mn.toString());
            mn.RoomDetails(101, 2, 5);

        }
    }
}
