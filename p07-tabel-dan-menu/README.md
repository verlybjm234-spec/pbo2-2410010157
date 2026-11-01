1. Tidak, tampilan tabel di layar tidak akan langsung berubah (refresh) meskipun data 
sebenarnya sudah berhasil ditambahkan ke dalam memori list data
2.Nama yang muncul di dialog konfirmasi adalah nama baris pertama yang ada di dalam tabel (paling atas),
bukan Ahmad Fauzi yang sedang Anda pilih
3.Jendela utama (parent) bisa diklik dan menjadi aktif kembali, dan dialog form input kontak akan berada
di belakang jendela utama (tertutup oleh jendela utama)
4.Karena tombol Edit (Ctrl+E) dan Delete (Ctrl+D) dirancang untuk memproses data yang spesifik. Jika tidak ada baris yang diklik/dipilih (getSelectedRow() < 0), sistem
tidak tahu data mana yang harus diubah atau dihapus, sehingga tombol tersebut dinonaktifkan (disabled) 
secara otomatis oleh fungsi logika seperti perbaruiTombol()
5.Baris kode yang mengatur tombol pintas (accelerator) pada komponen hapusItem berubah dari yang sebelumnya menggunakan KeyStroke.getKeyStroke
(java.awt.event.KeyEvent.VK_D, java.awt.event.ActionEvent.CTRL_MASK) menjadi hanya KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0)
6.Muncul pesan error NullPointerException pada saat aplikasi dijalankan