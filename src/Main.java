import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Mengatur tema agar tampilan modern sesuai sistem operasi
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Menjalankan jendela GUI
        SwingUtilities.invokeLater(() -> {
            DonasiGUI gui = new DonasiGUI();
            gui.setVisible(true);
        });
    }
}