package main;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements CRUD {
    private static ArrayList<Wisata> daftarWisata = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main program = new Main();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Program Perjalanan Wisata ===");
            System.out.println("1. Tambah Perjalanan Wisata");
            System.out.println("2. Lihat Semua Perjalanan Wisata");
            System.out.println("3. Hapus Perjalanan Wisata");
            System.out.println("4. Edit Perjalanan Wisata");
            System.out.println("5. Jumlah Perjalanan Wisata");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    program.tambahWisata(scanner);
                    break;
                case 2:
                    program.lihatSemuaPerjalanan();
                    break;
                case 3:
                    program.hapusWisata(scanner);
                    break;
                case 4:
                    program.editWisata(scanner);
                    break;
                case 5:
                    System.out.println("Jumlah total perjalanan wisata: " + Wisata.jumlahWisata);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    break;
            }
        }
        scanner.close();
    }

    // Implementasi metode CRUD dari interface
    @Override
    public void tambahPerjalanan(Wisata wisata) {
        daftarWisata.add(wisata);
        System.out.println("Perjalanan wisata berhasil ditambahkan.");
    }

    @Override
    public void hapusPerjalanan(String nama) {
        boolean found = false;
        for (Wisata wisata : daftarWisata) {
            if (wisata.getNama().equalsIgnoreCase(nama)) {
                daftarWisata.remove(wisata);
                Wisata.jumlahWisata--;
                System.out.println("Perjalanan wisata berhasil dihapus.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }

    @Override
    public void editPerjalanan(String nama, Wisata wisataBaru) {
        boolean found = false;
        for (Wisata wisata : daftarWisata) {
            if (wisata.getNama().equalsIgnoreCase(nama)) {
                wisata.setNama(wisataBaru.getNama());
                wisata.setLokasi(wisataBaru.getLokasi());
                wisata.setDurasi(wisataBaru.getDurasi());
                System.out.println("Perjalanan wisata berhasil diperbarui.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Wisata dengan nama tersebut tidak ditemukan.");
        }
    }

    @Override
    public void lihatSemuaPerjalanan() {
        if (daftarWisata.isEmpty()) {
            System.out.println("Belum ada perjalanan wisata yang terdaftar.");
        } else {
            System.out.println("\nDaftar Perjalanan Wisata:");
            for (Wisata wisata : daftarWisata) {
                wisata.tampilkanDetailPerjalanan();
                System.out.println("------------------------");
            }
        }
    }

    // Fungsi untuk input
    public void tambahWisata(Scanner scanner) {
        System.out.println("Pilih jenis wisata: ");
        System.out.println("1. Wisata Budaya");
        System.out.println("2. Wisata Alam");
        int jenisWisata = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nama wisata: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan lokasi wisata: ");
        String lokasi = scanner.nextLine();
        System.out.print("Masukkan durasi wisata (dalam jam): ");
        int durasi = scanner.nextInt();
        scanner.nextLine();

        if (jenisWisata == 1) {
            System.out.print("Masukkan budaya khas: ");
            String budayaKhas = scanner.nextLine();
            WisataBudaya wisataBudaya = new WisataBudaya(nama, lokasi, durasi, budayaKhas);
            tambahPerjalanan(wisataBudaya);
        } else if (jenisWisata == 2) {
            System.out.print("Masukkan jenis alam: ");
            String jenisAlam = scanner.nextLine();
            WisataAlam wisataAlam = new WisataAlam(nama, lokasi, durasi, jenisAlam);
            tambahPerjalanan(wisataAlam);
        } else {
            System.out.println("Jenis wisata tidak valid.");
        }
    }

    public void hapusWisata(Scanner scanner) {
        System.out.print("Masukkan nama wisata yang ingin dihapus: ");
        String nama = scanner.nextLine();
        hapusPerjalanan(nama);
    }

    public void editWisata(Scanner scanner) {
        System.out.print("Masukkan nama wisata yang ingin di-edit: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nama wisata baru: ");
        String namaBaru = scanner.nextLine();
        System.out.print("Masukkan lokasi wisata baru: ");
        String lokasiBaru = scanner.nextLine();
        System.out.print("Masukkan durasi wisata baru: ");
        int durasiBaru = scanner.nextInt();
        scanner.nextLine();

        Wisata wisataBaru = new Wisata(namaBaru, lokasiBaru, durasiBaru);
        editPerjalanan(nama, wisataBaru);
    }
}   