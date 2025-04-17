package App;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import RentalApp.RentalPS;
import RentalApp.RentalPSPremium;
import RentalApp.RentalPSDeluxe;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<RentalPS> listRentalPS = new ArrayList<>();

        // Menambahkan objek RentalPS, RentalPSPremium, dan RentalPSDeluxe ke dalam ArrayList
        initializeRentals(listRentalPS);

        boolean running = true;
        while (running) {
            tampilkanMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    tampilkanDaftarSebelumSorting(listRentalPS);
                    break;
                case 2:
                    tampilkanDaftarSetelahSorting(listRentalPS);
                    break;
                case 3:
                    ubahHargaRentalPS(scanner, listRentalPS);
                    break;
                case 4:
                    cariRentalPS(scanner, listRentalPS);
                    break;
                case 5:
                    tampilkanDaftarSetelahSortingJamSewa(listRentalPS);
                    break;
                case 6:
                    hapusRentalPS(scanner, listRentalPS);
                    break;
                case 7:
                    running = false;
                    System.out.println("TERIMA KASIH TELAH BERKUNJUNG.");
                    System.out.println("Credits: Jenar Aditiya B (24111814093)");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private static void initializeRentals(ArrayList<RentalPS> listRentalPS) {
        RentalPS rental1 = new RentalPS("PS 5", "5jam", 25000);
        rental1.setAdditionalInfo("Sedang disewa");
        listRentalPS.add(rental1);

        RentalPS rental2 = new RentalPS("PS 5", "3jam", 15000);
        rental2.setAdditionalInfo("Tidak disewa");
        listRentalPS.add(rental2);

        RentalPSPremium rentalPremium1 = new RentalPSPremium("PS 5", "6jam", 30000, "Bonus game gratis");
        rentalPremium1.setAdditionalInfo("Tidak disewa");
        listRentalPS.add(rentalPremium1);

        RentalPSDeluxe rentalDeluxe1 = new RentalPSDeluxe("PS 5", "8jam", 40000, "Akses VIP dan game eksklusif");
        rentalDeluxe1.setAdditionalInfo("Sedang disewa");
        listRentalPS.add(rentalDeluxe1);

        RentalPS rental5 = new RentalPS("PS 5", "1jam", 5000);
        rental5.setAdditionalInfo("Tidak disewa");
        listRentalPS.add(rental5);

        RentalPS rental6 = new RentalPS("PS 5", "7jam", 35000);
        rental6.setAdditionalInfo("Sedang disewa");
        listRentalPS.add(rental6);

        RentalPS rental7 = new RentalPS("PS 5", "2jam", 10000);
        rental7.setAdditionalInfo("Tidak disewa");
        listRentalPS.add(rental7);
    }

    // MENAMPILKAN TAMPILAN MENU UTAMA
    private static void tampilkanMenu() {
        System.out.println("+===================================================================+");
        System.out.println("=                      WELCOME TO RENTAL PS                         =");
        System.out.println("=                  By : Jenar Aditiya Bagaskara                     =");
        System.out.println("+===================================================================+");
        System.out.println("+===================================================================+");
        System.out.println("=                           MENU RENTAL                             =");
        System.out.println("+===================================================================+");
        System.out.println("1. Tampilkan daftar RentalPS sebelum sorting");
        System.out.println("2. Tampilkan daftar RentalPS setelah sorting (harga terendah)");
        System.out.println("3. Ubah harga RentalPS");
        System.out.println("4. Cari RentalPS berdasarkan jam sewa");
        System.out.println("5. Tampilkan daftar RentalPS setelah sorting berdasarkan jam sewa");
        System.out.println("6. Hapus RentalPS berdasarkan jam sewa");
        System.out.println("7. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private static void tampilkanDaftarSebelumSorting(ArrayList<RentalPS> listRentalPS) {
        System.out.println("Daftar RentalPS Sebelum Sorting:");
        for (RentalPS m : listRentalPS) {
            System.out.println(m);
        }
    }

    private static void tampilkanDaftarSetelahSorting(ArrayList<RentalPS> listRentalPS) {
        listRentalPS.sort(Comparator.comparingDouble(RentalPS::getHarga));
        System.out.println("\nDaftar RentalPS Setelah Sorting (harga Terendah):");
        for (RentalPS m : listRentalPS) {
            System.out.println(m);
        }
    }

    private static void ubahHargaRentalPS(Scanner scanner, ArrayList<RentalPS> listRentalPS) {
        System.out.print("Masukkan jam sewa yang ingin diubah: ");
        String jamsewaEdit = scanner.nextLine();
        RentalPS rentalPSEdit = RentalPS.cariRentalPS(listRentalPS, jamsewaEdit);
        if (rentalPSEdit != null) {
            System.out.print("Masukkan harga baru: ");
            double hargaBaru = scanner.nextDouble();
            rentalPSEdit.setHarga(hargaBaru);
            System.out.println("\nSetelah mengubah harga " + rentalPSEdit.getjenisPS() + ": ");
            System.out.println(rentalPSEdit);
        } else {
            System.out.println("RentalPS dengan jam sewa " + jamsewaEdit + " tidak ditemukan.");
        }
    }

    private static void cariRentalPS(Scanner scanner, ArrayList<RentalPS> listRentalPS) {
        System.out.print("Masukkan jam sewa yang dicari: ");
        String jamsewaDicari = scanner.nextLine();
        RentalPS rentalPSDitemukan = RentalPS.cariRentalPS(listRentalPS, jamsewaDicari);
        if (rentalPSDitemukan != null) {
            System.out.println("\nRentalPS dengan jam sewa " + jamsewaDicari + " ditemukan:");
            System.out.println(rentalPSDitemukan);
        } else {
            System.out.println("Rental PS dengan jam sewa " + jamsewaDicari + " tidak ditemukan.");
        }
    }

    private static void tampilkanDaftarSetelahSortingJamSewa(ArrayList<RentalPS> listRentalPS) {
        bubbleSortByJamSewa(listRentalPS);
        System.out.println("\nDaftar RentalPS Setelah Sorting (Berdasarkan jam sewa):");
        for (RentalPS m : listRentalPS) {
            System.out.println(m);
        }
    }

    private static void hapusRentalPS(Scanner scanner, ArrayList<RentalPS> listRentalPS) {
        System.out.print("Masukkan jam sewa yang ingin dihapus: ");
        String jamsewaHapus = scanner.nextLine();
        RentalPS rentalToRemove = RentalPS.cariRentalPS(listRentalPS, jamsewaHapus);
        if (rentalToRemove != null) {
            listRentalPS.remove(rentalToRemove);
            System.out.println("Rental PS dengan jam sewa " + jamsewaHapus + " telah dihapus.");
        } else {
            System.out.println("Rental PS dengan jam sewa " + jamsewaHapus + " tidak ditemukan.");
        }
    }

    public static void bubbleSortByJamSewa(ArrayList<RentalPS> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getjamsewa().compareTo(list.get(j + 1).getjamsewa()) > 0) {
                    RentalPS temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}