# Profil
Nama : Muhammad Rizky Setiawan

NIM : 2309116039

Tema : Sistem Perjalanan Wisata

# Deskripsi
Program ini adalah aplikasi berbasis Java untuk mengelola data perjalanan wisata. Aplikasi ini menyediakan fitur CRUD (Create, Read, Update, Delete) untuk mengatur perjalanan wisata dengan berbagai jenis wisata seperti Wisata Budaya dan Wisata Alam. Selain itu, program juga menampilkan jumlah total perjalanan wisata yang telah diinput oleh pengguna.

# Struktur Package
Program ini memiliki struktur folder dan package yang terorganisir sebagai berikut:

![image](https://github.com/user-attachments/assets/4916cfb3-3673-45b0-9b93-8b881449f8fe)

# Source Code
## Package main
### Main.java

```java
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
```

## Package model
### CRUD.java

```java
package model;

public interface CRUD {
    void tambahPerjalanan(Wisata wisata);
    void hapusPerjalanan(String nama);
    void editPerjalanan(String nama, Wisata wisata);
    void lihatSemuaPerjalanan();
}
```

### Perjalanan.java

```java
package model;

public abstract class Perjalanan {
    protected String nama;
    protected String lokasi;
    protected int durasi;

    public Perjalanan(String nama, String lokasi, int durasi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.durasi = durasi;
    }

    // Abstract method (abstraction)
    public abstract void tampilkanDetailPerjalanan();
}
```

### Wisata.java

```java
package model;

// Encapsulation using getters and setters
public class Wisata extends Perjalanan {
    public static int jumlahWisata = 0;
    
    public Wisata(String nama, String lokasi, int durasi) {
        super(nama, lokasi, durasi);
        jumlahWisata++;
    }

    @Override
    public void tampilkanDetailPerjalanan() {
        System.out.println("Nama Wisata : " + getNama());
        System.out.println("Lokasi      : " + getLokasi());
        System.out.println("Durasi      : " + getDurasi() + " jam");
    }

    // Getters and Setters
    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
}
```

### WisataAlam.java

```java
package model;

// Subclass of Wisata
public final class WisataAlam extends Wisata {
    private String jenisAlam;

    public WisataAlam(String nama, String lokasi, int durasi, String jenisAlam) {
        super(nama, lokasi, durasi);
        this.jenisAlam = jenisAlam;
    }

    @Override
    public void tampilkanDetailPerjalanan() {
        super.tampilkanDetailPerjalanan();
        System.out.println("Jenis Alam  : " + jenisAlam);
    }

    public String getJenisAlam() {
        return jenisAlam;
    }

    public void setJenisAlam(String jenisAlam) {
        this.jenisAlam = jenisAlam;
    }
}
```

### WisataBudaya.java

```java
package model;

// Subclass of Wisata
public final class WisataBudaya extends Wisata {
    private String budayaKhas;

    public WisataBudaya(String nama, String lokasi, int durasi, String budayaKhas) {
        super(nama, lokasi, durasi);
        this.budayaKhas = budayaKhas;
    }

    @Override
    public void tampilkanDetailPerjalanan() {
        super.tampilkanDetailPerjalanan();
        System.out.println("Budaya Khas : " + budayaKhas);
    }

    public String getBudayaKhas() {
        return budayaKhas;
    }

    public void setBudayaKhas(String budayaKhas) {
        this.budayaKhas = budayaKhas;
    }
}
```

# Output Program
### Menu Program

![image](https://github.com/user-attachments/assets/108b9c94-7526-4be7-be8f-164919370e21)

Saat memulai program, yang dimunculkan pertama adalah Menu Utama Program yang terdapat Create, Read, Update, Jumlah Perjalanan Wisata, dan Exit


### Menu Create

![image](https://github.com/user-attachments/assets/09a245f6-1861-462c-9b2d-2825eccfdcb7)

Pada saat pengguna memilih untuk menambah perjalanan wisata, program akan meminta informasi dasar seperti nama wisata, lokasi, dan durasi perjalanan. Pengguna juga diminta memilih apakah perjalanan tersebut termasuk dalam kategori wisata budaya atau wisata alam. Jika pengguna memilih Wisata Budaya, program akan meminta detail tambahan berupa budaya khas dari tempat wisata tersebut. Jika memilih Wisata Alam, pengguna akan diminta untuk memasukkan jenis alam, seperti pegunungan, pantai, atau lainnya. Setelah data dimasukkan, program akan memberikan konfirmasi bahwa perjalanan wisata telah berhasil ditambahkan, dan data akan tersimpan dalam sistem.

### Menu Read

![image](https://github.com/user-attachments/assets/c5865de0-94c8-4e48-aa46-956612e3d9ea)

Ketika pengguna memilih untuk melihat daftar perjalanan wisata, program akan menampilkan semua perjalanan yang telah diinput ke dalam sistem. Setiap perjalanan akan ditampilkan dengan rincian lengkap, termasuk nama, lokasi, durasi, dan atribut spesifik seperti budaya khas untuk wisata budaya, atau jenis alam untuk wisata alam. Pengguna dapat melihat informasi ini secara rinci di terminal, yang memungkinkan mereka memeriksa kembali data yang telah diinput.

### Menu Update

![image](https://github.com/user-attachments/assets/624755f7-39ad-4089-84c5-083b97b84af8)

Fitur ini memungkinkan pengguna untuk memperbarui informasi perjalanan wisata yang telah ada. Setelah memilih wisata yang ingin diedit, pengguna dapat mengubah nama, lokasi, dan durasi perjalanan wisata. Program akan memperbarui informasi yang ada sesuai dengan data yang baru dimasukkan. Proses ini memungkinkan pengguna untuk melakukan penyesuaian atau perbaikan pada data yang sebelumnya telah diinput tanpa harus menghapusnya terlebih dahulu.

### Menu Delete

![image](https://github.com/user-attachments/assets/66392961-e073-40aa-af25-593653940caf)

Dalam fitur ini, pengguna dapat menghapus perjalanan wisata yang telah didaftarkan dengan memasukkan nama perjalanan wisata yang ingin dihapus. Jika nama yang dimasukkan cocok dengan salah satu data yang ada, program akan menghapusnya dari sistem dan memberikan konfirmasi kepada pengguna bahwa perjalanan tersebut telah berhasil dihapus. Jika tidak ditemukan data dengan nama yang dimasukkan, program akan menampilkan pesan error.

### Jumlah Perjalanan Wisata

![image](https://github.com/user-attachments/assets/9d05149b-0846-45f0-94d2-e250dfe69aa9)

Fitur ini memberikan pengguna informasi tentang jumlah total perjalanan wisata yang telah terdaftar di sistem. Program akan menghitung semua entri yang ada dan menampilkan jumlah totalnya di terminal. Ini sangat berguna bagi pengguna untuk melihat seberapa banyak data yang telah mereka kelola dalam program ini.

### Exit

![image](https://github.com/user-attachments/assets/99746251-2d97-4916-819b-c67eab9a093a)

Saat input angka 6 otomatis akan keluar program/memberhentikan program.
