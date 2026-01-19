import java.util.*;

public class Donasi<T extends Barang> implements IDonasi {
    private String donasiId;
    private T item;
    private Status status;
    private LogHistory log; // Gunakan LogHistory sesuai nama file kamu

    public Donasi(String id, T item, String... inputTags) {
        this.donasiId = id;
        this.item = item;
        this.status = Status.PENDING;
        this.log = new LogHistory(); // Gunakan LogHistory
    }

    // Method ini wajib ada agar Main.java tidak error
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDonasiId() { return donasiId; }

    @Override
    public void eksekusi() {
        System.out.println("Memproses Donasi: " + donasiId);
        log.cetakWaktu();
    }
}