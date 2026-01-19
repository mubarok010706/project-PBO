import java.util.*;

public class Barang {
    private String nama;
    private Kategori kategori;
    private Map<String, String> atribut = new HashMap<>();
    private String imagePath; // Tambahan untuk gambar

    public Barang(String nama, Kategori kategori) {
        this.nama = nama;
        this.kategori = kategori;
    }

    public void tambahAtribut(String kunci, String nilai) {
        this.atribut.put(kunci, nilai);
    }

    // Getter dan Setter untuk Gambar
    public void setImagePath(String path) { this.imagePath = path; }
    public String getImagePath() { return imagePath; }
    public String getNama() { return nama; }
    public Kategori getKategori() { return kategori; }
    public Map<String, String> getAtribut() { return atribut; }
}