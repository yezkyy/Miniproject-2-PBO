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
