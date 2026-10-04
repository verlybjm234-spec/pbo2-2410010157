eksperimen PBO2
1.Pesan error: Koleksi is abstract 
cannot be instantiated. Terjadi karena
 Koleksi adalah abstract class, yaitu class
 yang belum lengkap dan hanya berfungsi 
sebagai kerangka untuk subclass-nya
Class abstract tidak boleh dibuat objeknya langsung dengan new 
Objek hanya bisa dibuat dari subclass konkret seperti Buku dan Majalah.

2.Jika @Override ada, kompiler menampilkan 2 error. Salah satunya hitungdenda(int) in Buku does not override or 
implement a method from a supertype, yang merujuk langsung ke method yang salah ketik/typo. Jika @Override dihapus
error itu hilang dan hanya tersisa Buku is not abstract and does not override abstract method hitungDenda(int). 
Jadi tanpa @Override kompiler tidak ngasi tahu letak kesalahannya, dan pesan yang tersisa lebih membingungkan.
@Override berfungsi sebagai pengaman supaya salah ketik nama method langsung ketahuan dan langsung ditunjuk kebarisnya.
Di kasus ini program tetap akan error karena hitungDenda bersifat abstract. padahal kan cuman di ubah nya hurud D aja pak kalo nurut saya 
java kan Karena di Java, huruf besar dan kecil dianggap beda. hitungDenda dan hitungdenda bagi Java adalah dua nama method yang sama sekali berbeda, 
seperti budi dan Budi. Satu huruf saja berubah, namanya sudah dianggap orang lain. Kalau method di induknya bukan abstract, 
tanpa @Override programnya bisa jalan, tapi method yang salah ketik tidak pernah dipakai dan tidak ada peringatan sama sekali.
Itu alasan @Override sangat lah penting. jadi kesimpulan yang bisa saya ambil error utamanya tetap muncul di kedua kasus karena hitungDenda bersifat abstract.
@Override hanya membantu menunjuk letak salah ketiknya secara langsung, sehingga lebih mudah ditemukan.

3.Program berhenti dengan exception java.lang.IllegalArgumentException: Judul wajib tidak kosong.karena hal ini terjadi karena constructor 
di class Koleksi memvalidasi judul dan melempar exception ketika judulnya kosong. yang jelas objek Buku dengan data tidak valid tidak pernah terbentuk,
dan program berhenti sebelum menampilkan keluaran apa pun. Jadi validasi di constructor mencegah data tidak valid masuk ke dalam sistem

4. Aturan yang dilanggar adalah enkapsulasi (information hiding). Atribut status seharusnya private dan hanya diubah lewat method 
resmi seperti pinjam() dan kembalikan(), yang menjaga aturan peminjaman. Ketika dibuat public, kode dari luar bisa mengubah status seenaknya, 
sehingga B002 tercatat TERSEDIA padahal masih dipinjam Siti, dan Budi bisa meminjamnya juga.