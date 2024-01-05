# Aplikasi Front Office Hotel

### About:
Aplikasi Front Office Hotel merupakan rancangan aplikasi untuk pemesanan hotel yang berbasis OOP dengan menggunakan java. Fungsi utama dari aplikasi ini yaitu untuk manajemen kamar dan reservasi (check in, check out) beserta fasilitasnya.

Aplikasi Front Office yang telah dirancang adalah sebuah solusi perangkat lunak yang komprehensif dan terintegrasi, mencakup berbagai tampilan yang memungkinkan manajemen kamar, pengelolaan pesanan tamu, dan proses pembayaran dengan efisien. Tampilan-tampilan seperti Authentication (Login, Register), Manajemen Kamar, Dashboard (Last Orders, List Of Room, dan Menu Check In/Check Out), serta Menu Pembayaran.
.

### Nama anggota kelompok:
- I Gede Ariawan Eka Putra			   	 (1908561085)
- Ida Bagus Putu Ryan Paramasatya Putra  (2208561010)
- Ni Made Wipra Ranum Ratnayu			 (2208561042)
- Bayu Yudistira Ramadhan				 (2208561085)
- Gede Putu Mahasatya Katyayana 		 (2208561116)

### Tujuan Aplikasi:
- Manajemen Kamar
- Reservasi Kamar
- Pengelolaan Pesanan Tamu
- Fasilitas Pembayaran

### Akses User:
- Register
- Login
- Monitor Status Kamar
- Menu Pembayaran

### Software dan Tools yang Digunakan:
- [Java JDK 21](https://www.youtube.com/watch?v=-hxCPXjYWJU)
- [IntelliJ IDEA](https://www.youtube.com/watch?v=XlWtdqYNc60)
- [XAMPP](https://youtu.be/VQpATELDSEI?si=CZQqn9-lp00pjyJI)
- PHPMyAdmin (Dalam XAMPP)
- Apache (Dalam XAMPP)

## Usage
### Membuat Database
STEP 1: Membuka XAMPP dan menyalakan Apache dan MySQL.
![Step 1.png](bin%2FStep%201.png)

STEP 2: Tekan Admin pada MySql untuk menggunakan PHPMyAdmin.
![Step 2.png](bin%2FStep%202.png)

STEP 3: Buatlah sebuah Database dengan nama Frontoffice.

```
CREATE DATABASE Frontoffice;
```
STEP 4: Isi database dengan tabel Admin, Customer, Hiburan, Kamar,dan Pembayaran.
```
CREATE TABLE  Admin (
    KodeAdmin INT(11) PRIMARY KEY,
    NamaAdmin VARCHAR(255),
    PasswordAdmin VARCHAR(255),
    EmailAdmin VARCHAR(255) UNIQUE
);

CREATE TABLE Customer (
    KodeUser INT(11) PRIMARY KEY,
    NamaUser VARCHAR(255),
    PasswordUser VARCHAR(255),
    EmailUser VARCHAR(255) UNIQUE,
    Telepon VARCHAR(20)
);

CREATE TABLE Hiburan (
    KodeHiburan INT(11) PRIMARY KEY,
    NamaHiburan VARCHAR(255),
    Kapasitas INT(11),
    Suasana VARCHAR(255),
    Harga DECIMAL(10,2)
);

CREATE TABLE Kamar (
    NoKamar INT(11) PRIMARY KEY,
    TypeKamar VARCHAR(255),
    NamaLayanan VARCHAR(255),
    Kapasitas INT(11),
    Suasana VARCHAR(255),
    Harga DECIMAL(10,2)
);

CREATE TABLE Pembayaran (
    NoTransaksi INT(11) PRIMARY KEY,
    Nominal DECIMAL(10,2),
    Diskon DECIMAL(5,2),
    TanggalTransaksi DATE,
    KodeHiburan INT(11), FOREIGN KEY (KodeHiburan) REFERENCES Hiburan(KodeHiburan),
    NoKamar INT(11), FOREIGN KEY (NoKamar) REFERENCES Kamar(NoKamar),
    KodeAdmin INT(11), FOREIGN KEY (KodeAdmin) REFERENCES ADMIN(KodeAdmin),
    KodeUser INT(11), FOREIGN KEY (KodeUser) REFERENCES Customer(KodeUser)
);
```
STEP 5: Eksekusi query berikut untuk memeriksa tabel yang sudah dibuat
```
SELECT * FROM Admin;
SELECT * FROM Customer;
SELECT * FROM Hiburan;
SELECT * FROM Kamar;
SELECT * FROM Pembayaran;
```
Catatan: Jika salah satu query di atas gagal, cobalah untuk memperbaikinya terlebih dahulu, lalu lanjutkan ke langkah berikutnya

### Import Repo GitHub ke IntelliJ IDEA
STEP 0: Buka IntelliJ IDEA, [Jika belum install](https://www.jetbrains.com/idea/download/?section=windows)

STEP 1: Pilih File > New > Project from Version Control > Repository URL > Salin Repository URL: https://github.com/GustuRyan/Final-Project-PBO.git > Enter > Clone

STEP 2: Pada bagian pilih interfaceHome dan Run.

## Screenshot Aplikasi
1. Login Page
![Login.png](bin%2FLogin.png)
2. Registration Page
![Registrasi.png](bin%2FRegistrasi.png)
3. Forgot Password
![Forgot.png](bin%2FForgot.png)
4. Home Page Before Login
![Home Page Before.png](bin%2FHome%20Page%20Before.png)
5. Home Page After Login
![Home Page After.png](bin%2FHome%20Page%20After.png)
6. Reservasi Hotel
![Registrasi.png](bin%2FRegistrasi.png)
7. Explore Page
![Explore.png](bin%2FExplore.png)
## Contributing
"Saran dan Peningkatan Program sangat Dipersilahkan"