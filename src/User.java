public class User extends Entitas {
    private String nama;

    public User(String id, String nama) {
        super(id);
        this.nama = nama;
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("ID: " + id + " | Nama: " + nama);
    }

    public String getNama() { return nama; }
}