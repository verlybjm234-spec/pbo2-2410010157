package id.ac.uniska.pbo2.p07;

/** Status peminjaman buku. toString() dipakai sebagai teks di combo box dan tabel. */
public enum StatusBuku {
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String label;

    StatusBuku(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}