# KatalogBuku (p07-mini-proyek)

Mini proyek Praktikum PBO 2 Pertemuan 7: aplikasi katalog buku dengan Java Swing, FlatLaf, dan Maven.

- Nama: (Ahmad verly)
- NPM: 2410010157

## Cara menjalankan

1. Buka folder `p07-mini-proyek` di Apache NetBeans.
2. Klik kanan proyek, pilih **Build** (Maven mengunduh FlatLaf 3.5.4).
3. Jalankan `KatalogBuku.java` dengan **Run File** (Shift+F6), atau tekan **F6** jika `exec.mainClass` sudah menunjuk ke `id.ac.uniska.pbo2.p07.KatalogBuku`.

## Struktur kelas

| File | Jenis | Fungsi |
|---|---|---|
| `StatusBuku.java` | Enum | Status buku: Tersedia atau Dipinjam. `toString()` dipakai sebagai teks di combo box dan tabel. |
| `Buku.java` | Record | Data satu buku: kode, judul, penulis, tahun, status. |
| `BukuTableModel.java` | Class (`AbstractTableModel`) | Menghubungkan daftar buku dengan `JTable`: `tambah`, `ubah`, `hapus`, `jumlahTersedia`. |
| `DialogBuku.java` | JDialog Form | Dialog modal untuk tambah dan ubah buku, lengkap dengan validasi. |
| `KatalogBuku.java` | JFrame Form | Jendela utama: tabel, menu, tombol, pencarian, dan label status. |

Tampilan (tombol, tabel, menu, isian) disusun di tab Design dan disimpan di file `.form`. Kode yang ditulis sendiri hanya kelas model, isi event handler, dan method bantu.

## Fitur

| No | Fitur | Keterangan |
|---|---|---|
| 1 | Tabel buku | Kolom Kode, Judul, Penulis, Tahun, Status memakai `AbstractTableModel`. |
| 2 | Data contoh | Lima buku dimuat saat aplikasi dibuka (`isiContoh()`). |
| 3 | Tambah dan ubah | Lewat `DialogBuku` (modal). Kode dan judul wajib diisi, tahun berupa angka 1900 sampai tahun sekarang. |
| 4 | Hapus | Dengan konfirmasi, memakai `convertRowIndexToModel`. |
| 5 | Menu | Menu File dan Buku dengan mnemonic serta accelerator Ctrl+N (tambah), Ctrl+E (ubah), Ctrl+D (hapus). |
| 6 | Pencarian | Menyaring berdasarkan kode, judul, atau penulis, tidak peduli huruf besar atau kecil. |
| 7 | Status | Label jumlah buku yang ditampilkan dan jumlah buku yang tersedia. |
| 8 | Tampilan | FlatLaf, tombol Ubah dan Hapus aktif hanya jika ada baris yang dipilih, jarak rapi. |

## Peta event

### Jendela utama (`KatalogBuku`)

| Komponen | Event | Method handler | Yang dilakukan |
|---|---|---|---|
| `tambahButton` | Action: actionPerformed | `tambahButtonActionPerformed` | Memanggil `tambah()` |
| `tambahItem` (Ctrl+N) | Action: actionPerformed | `tambahItemActionPerformed` | Memanggil `tambah()` |
| `ubahButton` | Action: actionPerformed | `ubahButtonActionPerformed` | Memanggil `ubah()` |
| `ubahItem` (Ctrl+E) | Action: actionPerformed | `ubahItemActionPerformed` | Memanggil `ubah()` |
| `hapusButton` | Action: actionPerformed | `hapusButtonActionPerformed` | Memanggil `hapus()` |
| `hapusItem` (Ctrl+D) | Action: actionPerformed | `hapusItemActionPerformed` | Memanggil `hapus()` |
| `cariField` | Key: keyReleased | `cariFieldKeyReleased` | Memanggil `saring()` setiap tombol dilepas |
| `bukuTable` | Mouse: mouseClicked | `bukuTableMouseClicked` | Klik dua kali pada baris memanggil `ubah()` |
| `keluarItem` | Action: actionPerformed | `keluarItemActionPerformed` | Menutup jendela (`dispose()`) |
| `bukuTable` (pemilihan baris) | `ListSelectionListener` | dipasang di konstruktor | Memanggil `perbaruiTombol()` |

`ListSelectionListener` tidak tersedia di menu Events, sehingga dipasang lewat kode di konstruktor.

### Dialog (`DialogBuku`)

| Komponen | Event | Method handler | Yang dilakukan |
|---|---|---|---|
| `simpanButton` | Action: actionPerformed | `simpanButtonActionPerformed` | Memanggil `simpan()`: memeriksa isian, lalu menyimpan ke `hasil` dan menutup dialog |
| `batalButton` | Action: actionPerformed | `batalButtonActionPerformed` | Menutup dialog tanpa menyimpan (`hasil` tetap `null`) |

## Alur data

1. Tombol atau menu Tambah memanggil `tambah()`, yang membuat `DialogBuku` dan menunggu sampai ditutup lewat `tampilkan()`.
2. `tampilkan()` mengembalikan `Buku` jika pengguna menekan Simpan, atau `null` jika Batal.
3. Jika hasilnya bukan `null`, `BukuTableModel.tambah()` atau `ubah()` mengubah daftar dan memberi tahu tabel lewat `fireTableRows...`.
4. Pencarian memakai `TableRowSorter` dengan `RowFilter`, sehingga nomor baris di tabel berbeda dengan nomor baris di model. Karena itu `barisTerpilih()` memakai `convertRowIndexToModel`.
