package RentalApp;

public class RentalPSDeluxe extends RentalPS {

    private String fasilitasEksklusif; // Atribut tambahan untuk fasilitas eksklusif

    // Konstruktor
    public RentalPSDeluxe(String jenisPS, String jamsewa, double harga, String fasilitasEksklusif) {
        super(jenisPS, jamsewa, harga); // Memanggil konstruktor superclass
        this.fasilitasEksklusif = fasilitasEksklusif;
    }

    public String getFasilitasEksklusif() {
        return fasilitasEksklusif; // Mengambil fasilitas eksklusif
    }

    @Override
    public String toString() {
        return super.toString() + ", Fasilitas Eksklusif: " + fasilitasEksklusif; // Menggabungkan informasi dari superclass
    }
}
