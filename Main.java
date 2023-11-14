import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in); // ada 2 scanner karena ada menu master dan pilihan menu
        String[][] userData = new String[][] {
                { "Admin", "Admin123" },
                { "Dosen", "Dosen456" },
                { "MahasiswaYonanda", "yonanda789", "2341760184", "082139631334", "islam", "P", "05/05/2005" },
                { "MahasiswaDhynar", "dhynar789", "" },
                { "MahasiswaAfril", "afril789" },
                { "MahasiswaRama", "rama789" } };

        String[][] dataMahasiswa = new String[4][4];
        String[] jurusan = { "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil" };
        String[][] prodi = {
                { "D4 Teknik Informatika", "D4 Sistem Informasi Bisnis", "D2 Pengembangan Piranti Lunak Situs" },
                { "D3 Teknik Telekomunikasi", "D3 Teknik Listrik", "D3 Teknik Elektronika",
                        "D4 Teknik Jaringan Telekomunikasi Digital", "D4 Sistem Kelistrikan", "D4 Teknik Elektronika" },
                { "D3 Teknik Sipil", "D3 Teknologi Pertambangan", "D3 Teknologi Konstruksi Jalan Jembatan Bangunan",
                        "D4 Manajemen Rekayasa Konstruksi", "D4 Teknologi Rekayasa Konstruksi Jalan Jembatan" } };
        String coba;

        boolean isLoggedIn = false;
        boolean isLoggedAdmin = false;
        boolean isLoggedDosen = false;
        boolean isLoggedMahasiswa = false;

        System.out.println("==========================\n");
        System.out.println("SELAMAT DATANG DI SIAKAD!");
        System.out.println("\n==========================");
        System.out.println("Silahkan Login Terlebih Dahulu!\n");
        System.out.print("Masukkan Username : ");
        String username = sc.nextLine();
        System.out.print("Masukkan Password : ");
        String password = sc.nextLine();

        for (int i = 0; i < userData.length; i++) {
            if (userData[0][0].equals(username) && userData[0][1].equals(password)) {
                isLoggedAdmin = true;
                break;
            } else if (userData[1][0].equals(username) && userData[1][1].equals(password)) {
                isLoggedDosen = true;
                break;
            } else if (userData[2][0].equals(username) && userData[2][1].equals(password)) {
                isLoggedMahasiswa = true;
                break;
            }
        }
        System.out.println("HALO");
        if (!isLoggedIn) { // dikasih not supaya program isLoggedIn bernilai trus dan program dapat
                           // berjalan
            while (true) {
                if (isLoggedAdmin) {
                    System.out.println("====================\n");
                    System.out.println("INI HALAMAN ADMIN");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Input data mahasiswa");
                    System.out.println("2. Input data mata kuliah");
                    System.out.println("3. Cetak KHS dan nilai");
                    System.out.println("4. Pelaporan nilai mahasiswa");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            // input data mahasiswa
                            int i = 0;
                            do {
                                System.out.println("Masukkan data mahasiswa ke- " + (i + 1));
                                System.out.print("Masukkan Nama: ");
                                dataMahasiswa[i][0] = sc.nextLine();
                                System.out.print("Masukkan NIM: ");
                                dataMahasiswa[i][1] = sc.nextLine();
                                System.out.println("Jurusan: ");
                                for (int j = 0; j < jurusan.length; j++) {
                                    System.out.println((j + 1) + ". " + jurusan[j]);
                                }
                                System.out.print("Jurusan yang dipilih : ");
                                int inputJurusan = sc.nextInt();
                                dataMahasiswa[i][2] = jurusan[--inputJurusan];
                                sc.nextLine();
                                System.out.println("Prodi: ");
                                for (int j = 0; j < prodi[inputJurusan].length; j++) {
                                    System.out.println((j + 1) + ". " + prodi[inputJurusan][j]);
                                }
                                System.out.print("Prodi yang dipilih : ");
                                int inputProdi = sc.nextInt();
                                dataMahasiswa[i][3] = prodi[inputJurusan][--inputProdi];
                                sc.nextLine();
                                i++;
                                System.out.print("Ingin lanjut (y/n) : ");
                                coba = sc.nextLine();
                            } while (coba.equalsIgnoreCase("y"));
                            for (int j = 0; j < dataMahasiswa.length; j++) {
                                System.out.println("===========================================================");
                                System.out.println("\nBerikut adalah daftar mahasiswa yang berhasil terinput : ");
                                System.out.println("Mahasiswa ke-" + (j + 1) + ":");
                                System.out.println("Nama : " + dataMahasiswa[j][0]);
                                System.out.println("NIM : " + dataMahasiswa[j][1]);
                                System.out.println("Jurusan : " + dataMahasiswa[j][2]);
                                System.out.println("Program Studi : " + dataMahasiswa[j][3]);
                            }
                            System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                            char ulang = sc.next().charAt(0);
                            if (ulang == 't') {
                                System.out.println("1. Exit");
                                System.out.println("2. Login kembali");
                                System.out.print("Masukkan pilihan anda : ");
                                int inpMenu = sc.nextInt();

                                switch (inpMenu) {
                                    case 1:
                                        System.out.println("Anda telah logout dari halaman admin");
                                        System.exit(0);
                                        break;
                                    case 2:
                                        System.out.println("Kembali ke halaman login");
                                        break;

                                    default:
                                        break;
                                }
                                break;
                            }
                        case 2:
                            // input data mata kuliah
                            break;

                        case 3:
                            // cetak khs dan nilai
                            break;

                        default:
                            break;
                    }

                } else if (isLoggedDosen) {
                    System.out.println("====================\n");
                    System.out.println("INI HALAMAN DOSEN");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Input nilai mahasiswa");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();

                    switch (inputMenu) {
                        case 1:
                            // input nilai mahasiswa
                            break;
                        case 2:
                            // pelaporan nilai mahasiswa
                            break;

                        default:
                            break;
                    }

                } else if (isLoggedMahasiswa) {
                    System.out.println("====================\n");
                    System.out.println("INI HALAMAN MAHASISWA");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Update data mahasiswa");
                    System.out.println("2. Cetak KHS dan Nilai");
                    System.out.println("3. Searching Matkul");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();

                    switch (inputMenu) {
                        case 1:
                            // ini update data
                            // Menampilkan pilihan pengguna yang data-nya bisa diubah
                            System.out.println("Pilih pengguna mahasiswa untuk memperbarui data:");
                            for (int i = 2; i < userData.length; i++) {
                                System.out.println((i - 1) + " " + userData[i][0]);
                            }

                            // // Meminta input pilihan pengguna dari user
                            System.out.print("Masukkan angka pilihan: ");
                            int pilihan = input.nextInt();

                            // Memperbarui data pengguna
                            if (pilihan > 0 && pilihan <= userData.length) {
                                String[] selectedUser = userData[pilihan + 1];
                                System.out.println("Data yang tersedia untuk pengguna " + selectedUser[0] + ":");

                                for (int j = 1; j < selectedUser.length; j++) {
                                    System.out.println(j + ". " + selectedUser[j]);
                                }

                                System.out.print("Masukkan angka data yang ingin diubah: ");
                                int dataChoice = input.nextInt();

                                if (dataChoice > 0 && dataChoice < selectedUser.length) {
                                    System.out.print("Masukkan data baru: ");
                                    String newData = input.next();
                                    selectedUser[dataChoice] = newData;
                                }
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }

                            // Menampilkan data pengguna yang baru setelah diperbarui
                            System.out.println("\nData Pengguna Baru:");
                            for (String[] user : userData) {
                                for (String data : user) {
                                    System.out.print(data + " ");
                                }
                                System.out.println();
                            }
                            break;

                        case 2:
                            // ini cetak khs dan nilai
                            break;

                        case 3:
                            String[] matkul = { "CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING",
                                    "BINDO", "AGAMA" };
                            String[] hari = new String[7];

                            hari[0] = "Senin";
                            hari[1] = "Selasa";
                            hari[2] = "Rabu";
                            hari[3] = "Kamis";
                            hari[4] = "Jum'at";
                            hari[5] = "Sabtu";
                            hari[6] = "Minggu";
                            String hasil = " ";

                            System.out.println("Matkul anda adalah sebagai berikut : ");
                            for (int i = 0; i < matkul.length; i++) {
                                System.out.println(matkul[i]);
                            }

                            System.out.print("Masukkan matkul yang ingin dicari : ");
                            String inputmatkul = input.next();
                            boolean find = false;
                            for (int i = 0; i < matkul.length; i++) {
                                if (matkul[i].equals(inputmatkul)) {
                                    find = true;
                                    hasil = matkul[i] = hari[i];
                                    break;
                                }
                            }

                            if (find) {
                                System.out.println("Matkul yang anda cari ada di hari: " + hasil);
                            } else {
                                System.out.println("Matkul tidak ditemukan");
                            }
                            break;

                        default:
                    }

                    System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                    char ulang = sc.next().charAt(0);
                    sc.nextLine();
                    if (ulang == 't') {
                        System.out.println("Anda telah log out");
                        break;
                    }
                }
            }
        } else {
            System.out.println("Login Gagal! Periksa kembali username dan password anda");
        }
        sc.close();
        input.close();
    }
}
