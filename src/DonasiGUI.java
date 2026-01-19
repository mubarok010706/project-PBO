import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class DonasiGUI extends JFrame {
    private JTextField txtNamaDonatur, txtNamaBarang, txtKategori, txtTags;
    private JTable tableDonasi;
    private DefaultTableModel tableModel;

    public DonasiGUI() {
        // Pengaturan Dasar Window
        setTitle("Sistem Aplikasi Donasi Barang Layak Pakai");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- PANEL INPUT (Kiri) ---
        JPanel panelInput = new JPanel(new GridLayout(12, 1, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Nama Donatur:"));
        txtNamaDonatur = new JTextField();
        panelInput.add(txtNamaDonatur);

        panelInput.add(new JLabel("Kategori Barang:"));
        txtKategori = new JTextField();
        panelInput.add(txtKategori);

        panelInput.add(new JLabel("Nama Barang:"));
        txtNamaBarang = new JTextField();
        panelInput.add(txtNamaBarang);

        panelInput.add(new JLabel("Ukuran:"));
        txtTags = new JTextField();
        panelInput.add(txtTags);

        JButton btnTambahAtribut = new JButton("Tambah Detail Spesifik");
        btnTambahAtribut.setBackground(Color.LIGHT_GRAY);
        panelInput.add(btnTambahAtribut);

        JButton btnSimpan = new JButton("Kirim Donasi");
        btnSimpan.setBackground(new Color(46, 204, 113));
        btnSimpan.setForeground(Color.BLACK);
        panelInput.add(btnSimpan);

        add(panelInput, BorderLayout.WEST);

        // --- PANEL TABEL (Tengah) ---
        String[] kolom = {"ID", "Donatur", "Barang (Kategori)", "Detail", "Tags", "Status"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableDonasi = new JTable(tableModel);
        add(new JScrollPane(tableDonasi), BorderLayout.CENTER);

        // --- LOGIKA DINAMIS ---
        // Penampung atribut sementara (HashMap simulasi)
        Barang barangTemp = new Barang("", new Kategori(""));

        // Event Tambah Atribut (Dinamis via Pop-up)
        btnTambahAtribut.addActionListener(e -> {
            String kunci = JOptionPane.showInputDialog("Nama Atribut (contoh: Ukuran/Merk):");
            if (kunci != null && !kunci.isEmpty()) {
                String nilai = JOptionPane.showInputDialog("Nilai Atribut " + kunci + ":");
                barangTemp.tambahAtribut(kunci, nilai);
                JOptionPane.showMessageDialog(this, "Atribut " + kunci + " berhasil ditambahkan!");
            }
        });

        // Event Kirim Donasi
        btnSimpan.addActionListener(e -> {
            try {
                // Inisialisasi Objek dari Input GUI
                Kategori kat = new Kategori(txtKategori.getText());
                Barang barang = new Barang(txtNamaBarang.getText(), kat);

                // Copy atribut dari barangTemp ke barang asli
                barangTemp.getAtribut().forEach(barang::tambahAtribut);

                String[] tagsArray = txtTags.getText().split(",");
                Donasi<Barang> donasi = new Donasi<>("DON-" + (int)(Math.random()*100), barang, tagsArray);
                donasi.setStatus(Status.TERVERIFIKASI);

                // Update Tabel secara Dinamis
                Object[] rowData = {
                        donasi.getDonasiId(),
                        txtNamaDonatur.getText(),
                        barang.getNama() + " (" + kat.getNamaKategori() + ")",
                        barang.getAtribut().toString(),
                        txtTags.getText(),
                        "VERIFIED"
                };
                tableModel.addRow(rowData);

                // Reset Form
                txtNamaBarang.setText("");
                txtKategori.setText("");
                txtTags.setText("");
                barangTemp.getAtribut().clear();

                JOptionPane.showMessageDialog(this, "Donasi Berhasil Dikirim!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DonasiGUI().setVisible(true);
        });
    }
}