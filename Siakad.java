import java.util.Scanner;

public class Siakad {
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_RESET = "\u001B[0m";

    static Scanner sc = new Scanner(System.in);
    static String[][] userData = new String[5][6];
    static boolean isLoggedIn = true;
    static String[] jurusan = new String[3];
    static String[][] prodi = new String[3][6];
    static boolean isLoggedAdmin = false;
    static boolean isLoggedDosen = false;
    static boolean isLoggedMahasiswa = false;

    public static void main(String[] args) {
        login();
        menuAdmin();
    }

    static void userData() {
        // userData[0][0] = "Admin"; // username
        // userData[0][1] = "Admin123"; // password

        userData[1][0] = "Dosen";
        userData[1][1] = "Dosen456";

        userData[2][0] = "MahasiswaYonanda"; // username
        userData[2][1] = "yonanda789"; // password
        userData[2][2] = "2341760184"; // NIM
        userData[2][3] = "082139631334"; // no telepon
        userData[2][4] = "Islam"; // agama
        userData[2][5] = "P"; // jenis kelamin
        userData[2][6] = "05/05/2005"; // tanggal

        userData[3][0] = "MahasiswaDhynar";
        userData[3][1] = "dhynar789";
        userData[3][2] = "2341760109";
        userData[3][3] = "081238285591";
        userData[3][4] = "Islam";
        userData[3][5] = "P";
        userData[3][6] = "09/09/2004";

        userData[4][0] = "MahasiswaAfril";
        userData[4][1] = "afril789";
        userData[4][2] = "2341760067";
        userData[4][3] = "082245773455";
        userData[4][4] = "Islam";
        userData[4][5] = "L";
        userData[4][6] = "05/04/2005";

        userData[5][0] = "MahasiswaRama";
        userData[5][1] = "rama789";
        userData[5][2] = "2341760125";
        userData[5][3] = "085648275713";
        userData[5][4] = "Islam";
        userData[5][5] = "L";
        userData[5][6] = "11/11/2004";
    }

    static String login() {
        userData[0][0] = "Admin"; // username
        userData[0][1] = "Admin123"; // password
        String username;
        String password;
        int i;
        String session = null;

        do {
            // boolean isLoggedAdmin = false;
            // boolean isLoggedDosen = false;
            // boolean isLoggedMahasiswa = false;
            System.out.println(ANSI_GREEN + "======================================");
            System.out.println(ANSI_GREEN + "|      SELAMAT DATANG DI SIAKAD!     |");
            System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
            System.out.println("Silahkan Login Terlebih Dahulu!");
            System.out.print("Username      : ");
            username = sc.nextLine();
            System.out.print("Password      : ");
            password = sc.nextLine();
    
            for (i = 0; i < userData.length; i++) {
                if (userData[0][0].equals(username) && userData[0][1].equals(password)) {
                    isLoggedAdmin = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[1][0].equals(username) && userData[1][1].equals(password)) {
                    isLoggedDosen = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[2][0].equals(username) && userData[i][1].equals(password)) {
                    isLoggedMahasiswa = true;
                    isLoggedIn = true;
                    break;
                }
            }
        } while (isLoggedIn == false);
            return session;
        }


    static void menuAdmin() {
        int inputMenu;

        if (isLoggedIn) {
            while (true) {
                if (isLoggedAdmin) {
                    System.out.println(ANSI_YELLOW + "======================================");
                    System.out.println(ANSI_YELLOW + "|            HALAMAN ADMIN            |");
                    System.out.println(ANSI_YELLOW + "======================================" + ANSI_RESET);
                    System.out.println("Pilihan Menu : ");
                       System.out.println("|1| Input data mahasiswa");
                    System.out.println("|2| Input data mata kuliah");
                    System.out.println("|3| Input KHS dan nilai");
                    System.out.println("|4| Pelaporan nilai mahasiswa");
                    System.out.println("|5| Keluar dari halaman admin\n");
                    System.out.print("Menu yang anda pilih : ");
                    inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            inputDataMhs();
                            break;
                        case 2:
                            inputMatkul();
                            break;
                        case 3:
                            inputKHS();
                            break;
                        case 4:
                            pelaporanNilai();
                            break;
                        case 5:
                            logOutAdmin();
                            break;

                        default:
                            System.out.println("Menu yang anda pilih tidak tersedia");
                            System.out.println("Silahkan memasukkan pilihan menu kembali");
                            break;
                    }
                }
            }
        }
    }

    static void inputDataMhs() {
        int i = 0;
        int j;
        String[][] dataMahasiswa = new String[4][4];
        jurusan[0] = "Teknologi Informasi";
        jurusan[1] = "Teknik Elektro";
        jurusan[2] = "Teknik Sipil";

        prodi[0][0] = "D4 Teknik Informatika";
        prodi[0][1] = "D4 Sistem Informasi Bisnis";
        prodi[0][2] = "D2 Pengembangan Piranti Lunak Situs";

        prodi[1][0] = "D3 Teknik Telekomunikasi";
        prodi[1][1] = "D3 Teknik Listrik";
        prodi[1][2] = "D3 Teknik Elektronika";
        prodi[1][3] = "D4 Teknik Jaringan Telekomunikasi Digital";
        prodi[1][4] = "D4 Sistem Kelistrikan";
        prodi[1][5] = "D4 Teknik Elektronika";

        prodi[2][0] = "D3 Teknik Sipil";
        prodi[2][1] = "D3 Teknologi Pertambangan";
        prodi[2][2] = "D3 Teknologi Konstruksi Jalan Jembatan Bangunan";
        prodi[2][3] = "D4 Manajemen Rekayasa Konstruksi";
        prodi[2][4] = "D4 Teknologi Rekayasa Konstruksi Jalan Jembatan";

        String inputData;

        do {
            System.out.println("Masukkan data mahasiswa ke- " + (i + 1));
            System.out.print("Nama      : ");
            dataMahasiswa[i][0] = sc.nextLine();
            System.out.print("NIM       : ");
            dataMahasiswa[i][1] = sc.nextLine();

            System.out.println("Jurusan   : ");
            for (j = 0; j < jurusan.length; j++) {
                System.out.println((j + 1) + ". " + jurusan[j]);
            }
            System.out.print("Jurusan yang dipilih : ");
            int inputJurusan = sc.nextInt();
            dataMahasiswa[i][2] = jurusan[--inputJurusan];
            sc.nextLine();

            System.out.println("Prodi     : ");
            for (j = 0; j < prodi[inputJurusan].length; j++) {
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
        System.out.println("\nDaftar mahasiswa yang berhasil terinput:");
        System.out.println(
                "======================================================================================================");
        System.out.printf("| %-4s | %-20s | %-12s | %-20s | %-30s |%n",
                "No", "Nama", "NIM", "Jurusan", "Program Studi");
        System.out.println(
                "======================================================================================================");

        for (j = 0; j < i; j++) {
            if (dataMahasiswa[j][0] != null && !dataMahasiswa[j][0].isEmpty() &&
                    dataMahasiswa[j][1] != null && !dataMahasiswa[j][1].isEmpty() &&
                    dataMahasiswa[j][2] != null && !dataMahasiswa[j][2].isEmpty() &&
                    dataMahasiswa[j][3] != null && !dataMahasiswa[j][3].isEmpty()) {
                System.out.printf("| %-4d | %-20s | %-12s | %-20s | %-30s |%n",
                        (j + 1), dataMahasiswa[j][0], dataMahasiswa[j][1],
                        dataMahasiswa[j][2], dataMahasiswa[j][3]);
            }
        }
        System.out.println(
                "======================================================================================================");
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
        }
    }

    static void inputMatkul() {
        boolean inginInputLagi = true;
        int jumlahMataKuliah = 9;
        String[][] mataKuliah = new String[jumlahMataKuliah][4];

        while (inginInputLagi) {
            for (int k = 0; k < mataKuliah.length; k++) {
                System.out.println("Masukkan data mata kuliah ke-" + (k + 1));
                System.out.print("Masukkan Nama Mata Kuliah : ");
                String namaMataKuliah = sc.nextLine();
                if (namaMataKuliah.isEmpty()) {
                    break;
                }
                mataKuliah[k][0] = namaMataKuliah;
                System.out.print("Masukkan Semester         : ");
                mataKuliah[k][1] = sc.nextLine();
                System.out.print("Masukkan SKS Mata Kuliah  : ");
                mataKuliah[k][2] = sc.nextLine();
                System.out.print("Masukkan Dosen Pengampu   : ");
                mataKuliah[k][3] = sc.nextLine();
                System.out.println();

                if (k == jumlahMataKuliah - 1) {
                    System.out.println("Jumlah mata kuliah sudah mencapai batas maksimum (9).");
                    inginInputLagi = false;
                    break;
                }

                System.out.print("Apakah ingin menginput mata kuliah lagi? (y/n): ");
                String jawaban = sc.nextLine();
                if (!jawaban.equalsIgnoreCase("y")) {
                    inginInputLagi = false;
                    break;
                }
            }
        }

        System.out.println("\nData mata kuliah yang telah diinput:");
        System.out.println("================================================================");
        System.out.println("| No | Nama Mata Kuliah      | Semester | SKS | Dosen Pengampu |");
        System.out.println("================================================================");
        boolean adaData = false;
        for (int l = 0; l < mataKuliah.length; l++) {
            if (mataKuliah[l][0] != null) {
                adaData = true;
                System.out.printf("| %-2d | %-21s | %-8s | %-3s | %-14s |%n", l + 1,
                        mataKuliah[l][0], (mataKuliah[l][1] != null ? mataKuliah[l][1] : "-"),
                        (mataKuliah[l][2] != null ? mataKuliah[l][2] : "-"),
                        (mataKuliah[l][3] != null ? mataKuliah[l][3] : "-"));
            } else {
                break;
            }
        }
        System.out.println("================================================================");

        if (!adaData) {
            System.out.println("Belum ada data mata kuliah yang diinput.");
        }
    }

    static void inputKHS() {
        Scanner scanner = new Scanner(System.in);
        boolean inputLagi = true;

        // Input data mahasiswa
        String namaMahasiswa;
        String nim;
        String ttl;

        System.out.print("Masukkan Nama Mahasiswa: ");
        namaMahasiswa = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        nim = scanner.nextLine();
        System.out.print("Masukkan Tempat, Tanggal Lahir: ");
        ttl = scanner.nextLine();

        // Input jumlah mata kuliah
        System.out.print("Masukkan Jumlah Mata Kuliah: ");
        int jumlahMatkul = scanner.nextInt();
        System.out.println("------");

        // Inisialisasi array nilaiMataKuliah
        String[] namaMatkul = new String[jumlahMatkul];
        int[] sksMatkul = new int[jumlahMatkul];
        int[] jamMatkul = new int[jumlahMatkul];
        String[] nilaiMatkulHuruf = new String[jumlahMatkul];
        double[] nilaiMatkulAngka = new double[jumlahMatkul];

        do {

            // Input nilai mata kuliah
            for (int k = 0; k < jumlahMatkul; k++) {
                scanner.nextLine(); // Membersihkan buffer
                System.out.print("Masukkan Nama Mata Kuliah ke-" + (k + 1) + ": ");
                namaMatkul[k] = scanner.nextLine();
                System.out.print("Masukkan SKS Mata Kuliah ke-" + (k + 1) + ": ");
                sksMatkul[k] = scanner.nextInt();
                System.out.print("Masukkan Jam Mata Kuliah ke-" + (k + 1) + ": ");
                jamMatkul[k] = scanner.nextInt();
                System.out.print("Masukkan Nilai Mata Kuliah ke-" + (k + 1) + ": ");
                nilaiMatkulHuruf[k] = scanner.next().toUpperCase(); // Konversi ke huruf besar
                nilaiMatkulAngka[k] = 0.0;

                // Loop untuk konversi nilai huruf ke angka
                if (nilaiMatkulHuruf[k].equals("A")) {
                    nilaiMatkulAngka[k] = 4.0;
                } else if (nilaiMatkulHuruf[k].equals("B+")) {
                    nilaiMatkulAngka[k] = 3.5;
                } else if (nilaiMatkulHuruf[k].equals("B")) {
                    nilaiMatkulAngka[k] = 3.0;
                } else if (nilaiMatkulHuruf[k].equals("C+")) {
                    nilaiMatkulAngka[k] = 2.5;
                } else if (nilaiMatkulHuruf[k].equals("C")) {
                    nilaiMatkulAngka[k] = 2.0;
                } else {
                    nilaiMatkulAngka[k] = 0.0;
                }

                System.out.println("------");
            }
            System.out.println();
            // Cetak KHS
            System.out.println("==========================");
            System.out.println("Kartu Hasil Studi (KHS)");
            System.out.println("==========================");
            System.out.println("Nama: " + namaMahasiswa);
            System.out.println("NIM: " + nim);
            System.out.println("TTL: " + ttl);
            System.out.println("--------------------------------------");
            System.out.println("Mata Kuliah\tSKS\tJam\tNilai");
            System.out.println("--------------------------------------");

            double totalNilai = 0;
            int totalSKS = 0;

            for (int k = 0; k < namaMatkul.length; k++) {
                System.out.printf("%-15s\t%d\t%d\t%s%n", namaMatkul[k], sksMatkul[k], jamMatkul[k],
                        nilaiMatkulHuruf[k]);
                totalNilai += nilaiMatkulAngka[k] * sksMatkul[k];
                totalSKS += sksMatkul[k];
            }

            double ipk = totalNilai / totalSKS;
            System.out.println("--------------------------------------");
            System.out.printf("IPK\t%.2f%n", ipk);

            System.out.println();

            System.out.print("Apakah Anda ingin menginput KHS lain? (y/n): ");
            String pilihan = scanner.next();
            inputLagi = pilihan.equalsIgnoreCase("y");

        } while (inputLagi);
        scanner.close();
    }

    static void pelaporanNilai() {

    }

    static void logOutAdmin() {
        isLoggedAdmin = false;
        isLoggedIn = false;
        System.out.print("Anda telah keluar dari halaman Admin");


    }

}