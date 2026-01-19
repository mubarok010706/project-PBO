public class Donatur extends User {
    public Donatur(String id, String nama) {
        super(id, nama);
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("[Profil Donatur] " + getNama());
    }

    // Asosiasi: Berinteraksi dengan objek Donasi
    public void serahkanDonasi(Donasi<?> donasi) {
        System.out.println("Donatur " + getNama() + " menyerahkan Donasi ID: " + donasi.getDonasiId());
    }
}