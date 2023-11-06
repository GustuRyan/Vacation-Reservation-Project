public class App {
    class Service {
        public String nuance;
        public int quantity;
        public String priceLevel;

        public Service(String nuance, int quantity, String priceLevel) {
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
            return ("Pada layanan ini bernuansa : " + nuance + "\nDengan kapasitas dari layanan : " + quantity + "\nPada tingkat harga : " + priceLevel);
        }
    }

    class Entertainment extends Service {
        public String theme;
        public double time;

        public Entertainment(String nuance, int quantity, String priceLevel, String culture, double defaultTime) {
            super(nuance, quantity, priceLevel);
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

        public Hotelrooms(String nuance, int quantity, String priceLevel, String type, String facilities) {
            super(nuance, quantity, priceLevel);
            this.type = type;
            this.facilities = facilities;
        }

        public void RoomDetails(int roomNumber, int floorNumber, int bedQuan) {
            this.roomNumber = roomNumber;
            this.floorNumber = floorNumber;
            this.quantity = bedQuan;

            System.out.println("\nHOTELROOMS DETAILS : " + "\n=====================" + "\nNomor kamar : " + roomNumber + "\nKamar berada pada lantai : " + floorNumber + "\nJumlah tempat tidur : " + quantity);
        }

        @Override
        public String toString() {
            return (super.toString() + "\nTipe dari kamar hotel ini : " + type + "\nDengan fasilitas yang ditawarkan : " + facilities);
        }
    }

    public static class Test {
        public static void main(String[] args) {
            Entertainment mb = new App().new Entertainment("Modern", 20, "midrange", "balinese", 8.00);
            System.out.println(mb.toString());

            System.out.println("\n");

            Hotelrooms mn = new App().new Hotelrooms("Contemporary", 10, "expensive", "Suite", "Private bathroom");
            System.out.println(mn.toString());
            mn.RoomDetails(101, 2, 5);
            
        }
    }
}