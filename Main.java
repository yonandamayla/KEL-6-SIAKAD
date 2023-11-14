import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in); // ada 2 scanner karena ada menu master dan pilihan menu

        String[][] userData = new String[][] {
                { "Admin", "Admin123" },
                { "Dosen", "Dosen456" },
                { "MahasiswaYonanda", "yonanda789", "2341760184", "082139631334", "Islam", "P", "05/05/2005" },
                { "MahasiswaDhynar", "dhynar789", "2341760109", "081238285591", "Islam", "P", "09/09/2004" },
                { "MahasiswaAfril", "afril789", "2341760067", "082245773455", "Islam", "L", "05/04/2005" },
                { "MahasiswaRama", "rama789", "2341760125", "085648275713", "Islam", "L", "11/11/2004" } };

        String[][] dataMahasiswa = new String[4][4];
        String[] jurusan = { "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil" };
        String[][] prodi = {
                { "D4 Teknik Informatika", "D4 Sistem Informasi Bisnis", "D2 Pengembangan Piranti Lunak Situs" },
                { "D3 Teknik Telekomunikasi", "D3 Teknik Listrik", "D3 Teknik Elektronika","D4 Teknik Jaringan Telekomunikasi Digital", "D4 Sistem Kelistrikan", "D4 Teknik Elektronika" },
                { "D3 Teknik Sipil", "D3 Teknologi Pertambangan", "D3 Teknologi Konstruksi Jalan Jembatan Bangunan", "D4 Manajemen Rekayasa Konstruksi", "D4 Teknologi Rekayasa Konstruksi Jalan Jembatan" } };

        String inputData;
        String inputAgain;

        boolean isLoggedIn = false;
        boolean isLoggedAdmin = false;
        boolean isLoggedDosen = false;
        boolean isLoggedMahasiswa = false;

        String[] matkul = { "CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA" };
        String[] hari = new String[7];
        

        String username, password;

        hari[0] = "Senin";
        hari[1] = "Selasa";
        hari[2] = "Rabu";
        hari[3] = "Kamis";
        hari[4] = "Jum'at";
        hari[5] = "Sabtu";
        hari[6] = "Minggu";
        String hasil = " ";

        boolean find = false;

        while (isLoggedIn == false) {
            System.out.println();
            
            System.out.println("----------------------------\n");
            System.out.println(" SELAMAT DATANG DI SIAKAD!    ");
            System.out.println("\n----------------------------\n");
            System.out.println("Login Gagal! Periksa kembali username dan password anda\n");
            System.out.print("Username : ");
            username = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();

            for (int i = 0; i < userData.length; i++) {
                if (userData[0][0].equals(username) && userData[0][1].equals(password)) {
                    isLoggedAdmin = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[1][0].equals(username) && userData[1][1].equals(password)) {
                    isLoggedDosen = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[i][0].equals(username) && userData[i][1].equals(password)) {
                    isLoggedMahasiswa = true;
                    isLoggedIn = true;
                    break;
                }

            }
        }
        if (isLoggedIn) { // dikasih not supaya program isLoggedIn bernilai trus dan program dapat
                          // berjalan
        if (!isLoggedIn) { // dikasih not supaya program isLoggedIn bernilai trus dan program dapat
                           // berjalan
            while (true) {
                if (isLoggedAdmin) {
                    System.out.println("====================\n");
                    System.out.println("   HALAMAN ADMIN    ");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Input data mahasiswa");
                    System.out.println("2. Input data mata kuliah");
                    System.out.println("3. Cetak KHS dan nilai");
                    System.out.println("4. Pelaporan nilai mahasiswa\n");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            // input data mahasiswa
                            int i = 0;
                            do {
                                System.out.println("Masukkan data mahasiswa ke- " + (i + 1));
                                System.out.print("Nama      : ");
                                dataMahasiswa[i][0] = sc.nextLine();
                                System.out.print("NIM       : ");
                                dataMahasiswa[i][1] = sc.nextLine();

                                System.out.println("Jurusan   : ");
                                for (int j = 0; j < jurusan.length; j++) {
                                    System.out.println((j + 1) + ". " + jurusan[j]);
                                }
                                System.out.print("Jurusan yang dipilih : ");
                                int inputJurusan = sc.nextInt();
                                dataMahasiswa[i][2] = jurusan[--inputJurusan];
                                sc.nextLine();

                                System.out.println("Prodi     : ");
                                for (int j = 0; j < prodi[inputJurusan].length; j++) {
                                    System.out.println((j + 1) + ". " + prodi[inputJurusan][j]);
                                }
                                System.out.print("Prodi yang dipilih : ");
                                int inputProdi = sc.nextInt();
                                dataMahasiswa[i][3] = prodi[inputJurusan][--inputProdi];
                                sc.nextLine();
                                i++;
                                System.out.print("Apakah anda ingin melanjutkan input data mahasiswa lain? (y/t) : ");
                                inputData = sc.nextLine();

                            } while (inputData.equalsIgnoreCase("y"));
                            for (int j = 0; j < dataMahasiswa.length; j++) {
                                System.out.println("===========================================================");
                                System.out.println("\nBerikut adalah daftar mahasiswa yang berhasil terinput : ");
                                System.out.println("Mahasiswa ke-" + (j + 1) + ":");
                                System.out.println("Nama        : " + dataMahasiswa[j][0]);
                                System.out.println("NIM         : " + dataMahasiswa[j][1]);
                                System.out.println("Jurusan     : " + dataMahasiswa[j][2]);
                                System.out.println("Prodi       : " + dataMahasiswa[j][3]);
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
                                        System.out.println("Kembali ke halaman login\n");
                                        // disini nantinya akan memasukkan username dan pw kembali untuk mengakses
                                        // halaman user lain
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

                        case 4:
                            // pelaporan nilai mahasiswa
                            break;

                        default:
                            break;
                    }

                } else if (isLoggedDosen) {
                    System.out.println("====================\n");
                    System.out.println("INI HALAMAN DOSEN");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Input nilai mahasiswa\n");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();

                    switch (inputMenu) {
                        case 1:
                            // input nilai mahasiswa
                            do {
                                String[] find_2 = new String[1];
                                System.out.print("Masukkan matkul yang akan diinputkan nilainya : ");
                                String inpmatkul = input.nextLine();
                                boolean find_3 = false;
                                for (int i = 0; i < matkul.length; i++) {
                                    if (matkul[i].equalsIgnoreCase(inpmatkul)) {
                                        find_3 = true;
                                        find_2[0] = matkul[i];
                                        break;
                                    }
                                }

                                if (find_3) {
                                    System.out.println("Matkul yang ingin diinput nilai ditemukan: " + find_2[0]);
                                    System.out.println("===============================================");
                                    int[][] inputNilai = new int[2][2];
                                    String[] namaMahasiswa = new String[4];
                                    for (int i = 0; i < inputNilai.length; i++) {
                                        System.out.println("Menginput nilai untuk mahasiswa ke-" + (i + 1));
                                        System.out.print("Nama mahasiswa: ");
                                        namaMahasiswa[i] = input.nextLine();
                                        System.out.print("Nilai UTS: ");
                                        inputNilai[i][0] = input.nextInt();
                                        System.out.print("Nilai UAS: ");
                                        inputNilai[i][1] = input.nextInt();
                                        input.nextLine();
                                    }

                                    System.out.println(
                                            "============================================================================");

                                    // Menampilkan hasil input dan rata-rata nilai
                                    System.out.println(find_2[0]);
                                    System.out.println("Nama Mahasiswa     \t\t\t| Nilai UTS | Nilai UAS | Rata-rata");
                                    System.out.println(
                                            "----------------------------------------------------------------------------");
                                    for (int i = 0; i < inputNilai.length; i++) {
                                        double rataRata = (inputNilai[i][0] + inputNilai[i][1]) / 2.0;
                                        System.out.printf("%-39s | %-9d | %-9d | %-8.2f\n", namaMahasiswa[i],
                                                inputNilai[i][0], inputNilai[i][1], rataRata);
                                    }
                                    System.out.println();

                                } else {
                                    System.out.println("Matkul tidak ditemukan");
                                }

                                System.out.print("Apakah Anda ingin menginput nilai untuk mata kuliah lain? (y/n): ");
                                inputAgain = input.nextLine();
                                
                            } while (inputAgain.equalsIgnoreCase("y"));
                            
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
                    System.out.println("3. Searching Matkul\n");
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
                            // ini searching matkul
                            System.out.println("Matkul anda adalah sebagai berikut : ");
                            for (int i = 0; i < matkul.length; i++) {
                                System.out.println(matkul[i]);
                            }

                            System.out.print("Masukkan matkul yang ingin dicari : ");
                            String inputmatkul = input.next();
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
        System.out.println(""); 
        }
    } 
}
}
