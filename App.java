public class App {
    class Service {
        public String svcName;
        public String nuance;
        public int quantity;
        public String priceLevel;

        public Service(String svcName, String nuance, int quantity, String priceLevel) {
            this.svcName = svcName;
            this.nuance = nuance;
            this.quantity = quantity;
            this.priceLevel = priceLevel;
        }

        public void reduceCount(int decrement) {
            quantity -= decrement;
        }

        public void addsCount(int increment) {
            quantity += increment;
        }

        public String toString() {
            return ("Nama layanan : " + svcName + "\nPada layanan ini bernuansa : " + nuance + "\nDengan kapasitas dari layanan : " + quantity + "\nPada tingkat harga : " + priceLevel);
        }
    }

    class Entertainment extends Service {
        public String theme;
        public double time;

        public Entertainment(String svcName, String nuance, int quantity, String priceLevel, String culture, double defaultTime) {
            super(svcName, nuance, quantity, priceLevel);
            theme = culture;
            time = defaultTime;
        }

        public void setTime(double newTime) {
            time = newTime;
        }

        @Override
        public String toString() {
            return (super.toString() + "\nTema dari hiburan ini : " + theme + "\nDengan waktu pertunjukan : " + time);
        }
    }

    class Hotelrooms extends Service {
        public String type;
        public String facilities;
        public int roomNumber;
        public int floorNumber;

        public Hotelrooms(String svcName, String nuance, int quantity, String priceLevel, String type, String facilities) {
            super(svcName, nuance, quantity, priceLevel);
            this.type = type;
            this.facilities = facilities;
        }

        public void RoomDetails(int roomNumber, int floorNumber, int bedQuan) {
            this.roomNumber = roomNumber;
            this.floorNumber = floorNumber;
            this.quantity = bedQuan;

            System.out.println("\nHOTELROOMS DETAILS : " + "\n=====================" + "\nNomor kamar : " + roomNumber
                    + "\nKamar berada pada lantai : " + floorNumber + "\nJumlah tempat tidur : " + quantity);
        }

        @Override
        public String toString() {
            return (super.toString() + "\nTipe dari kamar hotel ini : " + type + "\nDengan fasilitas yang ditawarkan : "
                    + facilities);
        }
    }

    class Customers {
        private String cstmName;
        private int ages;
        private String status;

        public String getName() {
            return cstmName;
        }

        public void setName(String cstmName) {
            this.cstmName = cstmName;
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

    public static class Test {
        public static void main(String[] args) {
            Customers person = new App().new Customers();
            person.setName ("Putra");
            person.setAges(21);
            person.setStatus("Mahasiswa");

            System.out.println("Name : " + person.getName() + "\nUmur : " + person.getAges() + "\nStatus : " + person.getStatus());

            System.out.println("\nLAYANAN HIBURAN : ");

            Entertainment mb = new App().new Entertainment("Tari Kecak", "Modern", 20, "midrange", "balinese", 8.00);
            System.out.println(mb.toString());

            System.out.println("\nLAYANAN KAMAR HOTEL : ");

            Hotelrooms mn = new App().new Hotelrooms("Suiteroom", "Contemporary", 10, "expensive", "Suite", "Private bathroom");
            System.out.println(mn.toString());
            mn.RoomDetails(101, 2, 5);

        }
    }
}