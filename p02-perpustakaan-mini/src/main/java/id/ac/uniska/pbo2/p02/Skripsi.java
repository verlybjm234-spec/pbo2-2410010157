package id.ac.uniska.pbo2.p02;

public class Skripsi extends Koleksi {
    private final String penulis;
    private final String programStudi;

    public Skripsi(String kode, String judul, int tahun,
                   String penulis, String programStudi) {
        super(kode, judul, tahun);
        this.penulis = penulis;
        this.programStudi = programStudi;
    }

    @Override
    public int batasHariPinjam() {
        return 0;
    }

    @Override
    public long hitungDenda(int hariTerlambat) {
        return 0;
    }

    @Override
    public String keterangan() {
        return "Skripsi karya " + penulis + ", " + programStudi;
    }
    
    @Override
public boolean pinjam() {
    return false;
}

}