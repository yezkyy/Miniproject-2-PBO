package model;

public interface CRUD {
    void tambahPerjalanan(Wisata wisata);
    void hapusPerjalanan(String nama);
    void editPerjalanan(String nama, Wisata wisata);
    void lihatSemuaPerjalanan();
}
