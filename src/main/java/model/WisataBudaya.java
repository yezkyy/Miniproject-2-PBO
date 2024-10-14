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
