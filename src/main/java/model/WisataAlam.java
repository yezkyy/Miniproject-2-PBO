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
