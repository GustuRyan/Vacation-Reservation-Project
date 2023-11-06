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
            return ("Pada layanan ini bernuansa : " + nuance + "\nDengan kapasitas dari layanan : " + quantity
                    + "\nPada tingkat harga : " + priceLevel);
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

    public static class Test {
        public static void main(String[] args) {

            Entertainment mb = new App().new Entertainment("Modern", 20, "midrange", "balinese", 8.00);
            System.out.println(mb.toString());
        }
    }
}