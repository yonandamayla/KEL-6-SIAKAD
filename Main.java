import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Scanner input = new Scanner(System.in); //ada 2 scanner karena ada menu master dan pilihan menu
        String [][] user = new String[][] {
            {"Admin", "Admin123"},
            {"Dosen", "Dosen456"},
            {"Mahasiswa", "Mahasiswa789"}
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

        for (int i = 0; i < user.length; i++) {
            if (user[0][0].equals(username) && user[0][1].equals(password)) {
                isLoggedAdmin = true;
                break;
            } else if (user[1][0].equals(username) && user[1][1].equals(password)) {
                isLoggedDosen = true;
                break;
            } else if (user[2][0].equals(username) && user[2][1].equals(password)) {
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
                                System.out.print("Masukkan nama : ");
                                dataMahasiswa[i][0] = sc.next();
                                System.out.print("Masukkan NIM: ");
                                dataMahasiswa[i][1] = sc.next();
                                System.out.print("Masukkan Jurusan: ");
                                dataMahasiswa[i][2] = sc.next();
                                System.out.print("Masukkan Program Studi: ");
                                dataMahasiswa[i][3] = sc.next();
                                System.out.println();
                                
                            }
                            for (int i = 0; i < dataMahasiswa.length; i++) {
                            System.out.println("===========================================================");
                            System.out.println("\nBerikut adalah daftar mahasiswa yang berhasil terinput : ");
                            System.out.println("Mahasiswa ke-" + (i + 1) + ":");
                            System.out.println("Nama: " + dataMahasiswa[i][0]);
                            System.out.println("NIM: " + dataMahasiswa[i][1]);
                            System.out.println("Jurusan: " + dataMahasiswa[i][2]);
                            System.out.println("Program Studi: "+ dataMahasiswa[i][3]);
                            
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
