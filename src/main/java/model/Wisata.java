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