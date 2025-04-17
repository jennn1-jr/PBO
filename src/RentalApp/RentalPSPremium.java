package RentalApp;

public class RentalPSPremium extends RentalPS {
    private final String bonus; // Atribut tambahan untuk rental premium

    // Konstruktor
    public RentalPSPremium(String JenisPS, String jamsewa, double Harga, String bonus) {
        super(JenisPS, jamsewa, Harga); // Memanggil konstruktor superclass
        this.bonus = bonus;
    }

    // Metode getter untuk bonus
    public String getBonus() {
        return bonus;
    }

    // Override metode toString untuk menampilkan informasi tambahan
    @Override
    public String toString() {
        return super.toString() + ", Bonus: " + bonus; // Menggabungkan informasi dari superclass
    }
}