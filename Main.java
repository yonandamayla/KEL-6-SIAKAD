import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Scanner input = new Scanner(System.in); //ada 2 scanner karena ada menu master dan pilihan menu
        String [][] userData = new String[][] {
            {"Admin", "Admin123"},
            {"Dosen", "Dosen456"},
            {"MahasiswaYonanda", "yonanda789", "2341760184", "082139631334", "islam", "P", "05/05/2005"},
            {"MahasiswaDhynar", "dhynar789", ""},
            {"MahasiswaAfril", "afril789"},
            {"MahasiswaRama", "rama789"},
        };
        
        System.out.println("==========================\n");
        System.out.println("SELAMAT DATANG DI SIAKAD!");
        System.out.println("\n==========================");
        System.out.println("Silahkan Login Terlebih Dahulu!\n");
        System.out.print("Masukkan Username : ");
        String username = sc.nextLine();
        System.out.print("Masukkan Password : ");
        String password = sc.nextLine();

        boolean isLoggedIn = false;
        boolean isLoggedAdmin = false;
        boolean isLoggedDosen = false;
        boolean isLoggedMahasiswa = false;

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

        if (!isLoggedIn) { //dikasih not supaya program isLoggedIn bernilai trus dan program dapat berjalan
            while (true) {
                if (isLoggedAdmin) {
                    System.out.println("====================\n");
                    System.out.println("INI HALAMAN ADMIN");
                    System.out.println("\n====================");
                    System.out.println("Pilihan Menu : ");
                    System.out.println("1. Input data mahasiswa");
                    System.out.println("2. Input data mata kuliah");
                    System.out.println("3. Cetak KHS dan nilai");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();

                    switch (inputMenu) {
                        case 1:
                            // input data mahasiswa
                            String [][] dataMahasiswa = new String[4][4];

                            for (int i = 0; i < dataMahasiswa.length; i++) {
                                System.out.println("Masukkan data mahasiswa ke- " + (i+1));
                                System.out.print("Masukkan Nama: ");
                                dataMahasiswa[i][0] = sc.nextLine();
                                System.out.print("Masukkan NIM: ");
                                dataMahasiswa[i][1] = sc.nextLine();
                                System.out.println("Jurusan: ");
                                System.out.println("1. Teknologi Informasi");
                                System.out.println("2. Teknik Elektro");
                                System.out.println("3. Teknik Sipil");
                                System.out.print("Jurusan yang dipilih : ");
                                int inputJurusan = sc.nextInt();
                                
                                switch (inputJurusan) {
                                    case 1:
                                        System.out.println("Prodi : ");
                                        System.out.println("1. D4 Teknik Informatika");
                                        System.out.println("2. D4 Sistem Informasi Bisnis");
                                        System.out.println("3. D2 Pengembangan Piranti Lunak Situs");
                                        System.out.print("Prodi yang dipilih : ");
                                        int inputProdi = sc.nextInt();
                                        System.out.println();
                                        break;
                                    
                                        case 2:
                                        System.out.println("Prodi : ");
                                        System.out.println("1. D3 Teknik Telekomunikasi");
                                        System.out.println("2. D3 Teknik Listrik");
                                        System.out.println("3. D3 Teknik Elektronika");
                                        System.out.println("4. D4 Teknik Jaringan Telekomunikasi Digital");
                                        System.out.println("5. Sistem Kelistrikan");
                                        System.out.println("6. D4 Teknik Elektronika");
                                        System.out.print("Prodi yang dipilih : ");
                                        inputProdi = sc.nextInt();
                                        System.out.println();
                                        break;

                                        case 3:
                                        System.out.println("Prodi : ");
                                        System.out.println("1. D3 Teknik Sipil");
                                        System.out.println("2. D3 D3 Teknologi Pertambangan");
                                        System.out.println("3. D3 Teknologi Konstruksi Jalan Jembatan Bangunan");
                                        System.out.println("4. D4 Manajemen Rekayasa Konstruksi");
                                        System.out.println("5. D4 Teknologi Rekayasa Konstruksi Jalan Jembatan");
                                        System.out.print("Prodi yang dipilih : ");
                                        inputProdi = sc.nextInt();
                                        System.out.println();
                                        break;

                                    default:
                                        break;
                                }
                                
                            }
                            for (int i = 0; i < dataMahasiswa.length; i++) {
                            System.out.println("===========================================================");
                            System.out.println("\nBerikut adalah daftar mahasiswa yang berhasil terinput : ");
                            System.out.println("Mahasiswa ke-" + (i + 1) + ":");
                            // System.out.println("Nama : ");
                            // System.out.println("NIM : " + dataMahasiswa[i][1]);
                            // System.out.println("Jurusan : " + dataMahasiswa[i][2]);
                            // System.out.println("Program Studi : "+ dataMahasiswa[i][3]);
                            // }

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
                        }
                        case 2:
                            // input data mata kuliah
                            break;
                        
                        case 3 :
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
                    System.out.println("2. Pelaporan nilai mahasiswa");
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
                            Scanner input01 = new Scanner(System.in);

                            // Menampilkan pilihan pengguna yang data-nya bisa diubah
                            System.out.println("Pilih pengguna untuk memperbarui data:");
                            for (int i = 2; i < userData.length; i++) {
                                System.out.println((i - 1) + ". " + userData[i][0]);
                            }

                            // Meminta input pilihan pengguna dari user
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

                            input01.close();

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
                        String [] matkul = {"CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA"};
                        String [] hari = new  String [7];
                            
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
                        String inputmatkul=  input.nextLine();
                        boolean find = false;
                        for (int i = 0; i < matkul.length; i++) {
                            if ( matkul[i].equals(inputmatkul)) {
                                find = true;
                                hasil = matkul[i] = hari[i];
                                break;   
                            }
                        }

                        if (find) {
                            System.out.println("Matkul yang anda cari ada di hari: " + hasil );
                        }else {
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
