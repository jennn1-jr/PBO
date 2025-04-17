package RentalApp;

import java.util.ArrayList;


public class RentalPS {
    private String JenisPS; // Atribut private
    private String jamsewa;  // Atribut private
    private double Harga; // Atribut private
    protected String additionalInfo; // Atribut protected

    // Konstruktor
    public RentalPS(String JenisPS, String jamsewa, double Harga) {
        this.JenisPS = JenisPS;
        this.jamsewa = jamsewa;
        this.Harga = Harga;
        this.additionalInfo = additionalInfo; // Inisialisasi atribut protected
    }

    // Metode getter untuk JENISPS
    public String getjenisPS() {
        return JenisPS;
    }

    // Metode setter untuk JENISPS
    public void setJenisPS(String JenisPS) {
        this.JenisPS = JenisPS;
    }

    // Metode getter untuk jam sewa
    public String getjamsewa() {
        return jamsewa;
    }

    // Metode setter untuk jam sewa
    public void setjamsewa(String jamsewa) {
        if (jamsewa.matches("[0-9]+") && jamsewa.length() > 2) {
            this.jamsewa = jamsewa;
        } else {
            System.out.println(">>> jamsewa harus angka <<<");
        }
    }

    // Metode getter untuk harga
    public double getHarga() {
        return Harga;
    }

    // Metode setter untuk harga
    public void setHarga(double Harga) {
        if (Harga >= 500 && Harga <= 35000) { 
            this.Harga = Harga;
        } else {
            System.out.println(">>> harga harus antara 500 dan 35000 <<<");
        }
    }

    // Metode getter untuk additionalInfo
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    // Metode setter untuk additionalInfo
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    // Metode untuk mencari RentalPS berdasarkan jam sewa
    public static RentalPS cariRentalPS(ArrayList<RentalPS> daftar, String jamsewa) {
        for (RentalPS m : daftar) {
            if (m.getjamsewa().equals(jamsewa)) {
                return m; // Mengembalikan objek RentalPS jika ditemukan
            }
        }
        System.out.println("\nRental PS dengan jam sewa " + jamsewa + " tidak ditemukan.");
        return null; // Mengembalikan null jika tidak ditemukan
    }

    @Override
    public String toString() {
        return "Jenis PS: " + JenisPS + ", jamsewa: " + jamsewa + ", Harga: " + Harga + ", Info Tambahan: " + additionalInfo;
    }
}