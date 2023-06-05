# App.java
    Pada 'App.java' terdapat untuk menjalankan aplikasi.
    
# secondcharm
    Terdiri dari beberapa package yaitu:
    1. dao
    2. Models
    3. Scenes
    4. Utils

## 1. dao
    BottomCell        : menampilkan tabel yang berisi daftar produk bawahan.
    BottomDao         : berisan kode yang menghubungkan tabel dengan database.
    TopCell           : menampilkan tabel yang berisi daftar produk atasan.
    TopDao            : berisan kode yang menghubungkan tabel dengan database.

## 2. Models
    Bottom            : class yang memiliki atribut untuk data produk bawahan.
    Clothing          : parent class dari class Bottom dan Top yang menyimpan atribut inti produk.
    Top               : class yang memiliki atribut untuk data produk atasan.

## 3.Scenes
    BuyScene          : menampilkan scene saat user akan membeli produk.
    HomeScene         : menampilkan halaman utama sebelum masuk ke aplikasi.
    LoginScene        : halaman untuk melakukan login.
    MyScene           : abstract class yang menyimpan atribut stage dan method show() untuk dipakai 
                        scene lain.
    ProductScene      : halaman yang menampilkan daftar produk.
    SignUpScene       : halaman untuk melakukan sign up.

## 4. Utils
    DataBaseConfig    : barisan kode yang menghubungkan ke database produk.
    UserConfig        : barisan kode yang menghubungkan ke database user.
    
# resources
    Terdiri dari 2 package yaitu:
    1. images
    2. styles

## 1. images
    Terdiri dari package product dan beberapa gambar yang digunakan sebagai logo serta background aplikasi.
    
  ### product
    Terdiri dari berbagai gambar produk untuk atasan dan bawahan yang menjadi sumber gambar untuk database.
    
## 2. styles
    BuyScene-style    : css untuk style scene pembelian.
    LoginScene-style  : css untuk style scene login dan sign up.
    Scene1-style      : css untuk style HomeScene.
    Scene2-style      : css untuk style ProductScene.
