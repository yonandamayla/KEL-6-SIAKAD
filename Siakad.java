import java.util.Scanner;

public class Siakad {
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_RESET = "\u001B[0m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_BLUE = "\u001B[34m";

    static Scanner sc = new Scanner(System.in);
    static String[][] userData = new String[6][7];
    static boolean isLoggedIn = false;
    static boolean isLoggedAdmin = false;
    static boolean isLoggedDosen = false;
    static boolean isLoggedMahasiswa = false;
    static boolean wantsToLogout = false;
    static String inputAgain;

    public static void main(String[] args) {
        login();
        if (isLoggedAdmin) {
            menuAdmin();
        } else if (isLoggedDosen) {
            menuDosen();
        } else if (isLoggedMahasiswa) {
            menuMahasiswa();
        }
    }

    static String login() {
        userData[0][0] = "Admin"; // username
        userData[0][1] = "Admin123"; // password
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

        String username;
        String password;
        int i;
        String session = null;

        do {
            System.out.println(ANSI_YELLOW + "======================================");
            System.out.println(ANSI_YELLOW + "|      SELAMAT DATANG DI SIAKAD!     |");
            System.out.println(ANSI_YELLOW + "======================================" + ANSI_RESET);
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
                } else if (userData[i][0].equals(username) && userData[i][1].equals(password)) {
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
            while (!wantsToLogout) {
                if (isLoggedAdmin) {
                    System.out.println(ANSI_GREEN + "======================================");
                    System.out.println(ANSI_GREEN + "|            HALAMAN ADMIN            |");
                    System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
                    System.out.println("Pilihan Menu : ");
                    System.out.println("|1| Input data mahasiswa");
                    System.out.println("|2| Input data mata kuliah");
                    System.out.println("|3| Pelaporan nilai mahasiswa");
                    System.out.println("|4| Keluar dari halaman admin\n");
                    System.out.print("Menu yang anda pilih (1-4): ");
                    inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            inputDataMahasiswa();
                            break;
                        case 2:
                            inputMatkul(); 
                            break;
                        case 3:
                        // pelaporanNilai();
                        //     break;
                        case 4:
                            wantsToLogout = true;
                            System.out.print(ANSI_RED + "Anda telah keluar dari halaman Admin" + ANSI_RESET);
                            break;

                        default:
                            System.out.println(ANSI_RED + "Menu yang anda pilih tidak tersedia");
                            System.out.println("Silahkan masukkan pilihan menu dengan benar" + ANSI_RESET);
                            System.out.println();
                            break;
                    }
                }
            }
        }
    }

    static void inputDataMahasiswa() {
        int i = 0;
        String[][] dataMahasiswa = new String[4][4];
        String[] jurusan = { "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil" };
        String[][] prodi = {
                { "D4 Teknik Informatika", "D4 Sistem Informasi Bisnis", "D2 Pengembangan Piranti Lunak Situs" },
                { "D3 Teknik Telekomunikasi", "D3 Teknik Listrik", "D3 Teknik Elektronika",
                        "D4 Teknik Jaringan Telekomunikasi Digital", "D4 Sistem Kelistrikan", "D4 Teknik Elektronika" },
                { "D3 Teknik Sipil", "D3 Teknologi Pertambangan", "D3 Teknologi Konstruksi Jalan Jembatan Bangunan",
                        "D4 Manajemen Rekayasa Konstruksi", "D4 Teknologi Rekayasa Konstruksi Jalan Jembatan" } };
        String inputData;
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
        System.out.println(ANSI_BLUE + "\nDaftar mahasiswa yang berhasil terinput:");
        System.out.println(
                "========================================================================================================================");
        System.out.printf("| %-4s | %-20s | %-12s | %-20s | %-48s |%n",
                "No", "Nama", "NIM", "Jurusan", "Program Studi");
        System.out.println(
                "========================================================================================================================"  +ANSI_RESET);

        for (int j = 0; j < i; j++) {
            if (dataMahasiswa[j][0] != null && !dataMahasiswa[j][0].isEmpty() &&
                    dataMahasiswa[j][1] != null && !dataMahasiswa[j][1].isEmpty() &&
                    dataMahasiswa[j][2] != null && !dataMahasiswa[j][2].isEmpty() &&
                    dataMahasiswa[j][3] != null && !dataMahasiswa[j][3].isEmpty()) {
                System.out.printf("| %-4d | %-20s | %-12s | %-20s | %-48s |%n",
                        (j + 1), dataMahasiswa[j][0], dataMahasiswa[j][1],
                        dataMahasiswa[j][2], dataMahasiswa[j][3]);
            }
            System.out.println(
                    ANSI_BLUE + "========================================================================================================================" + ANSI_RESET);
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah log out" + ANSI_RESET);
            wantsToLogout = true;
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
                System.out.print("Apakah anda ingin menginputkan mata kuliah lagi? (y/t): ");
                String jawaban = sc.nextLine();
                if (!jawaban.equalsIgnoreCase("y")) {
                    inginInputLagi = false;
                    break;
                }
            }
        }

        System.out.println(ANSI_BLUE + "\nData mata kuliah yang telah diinput");
        System.out.println(
                "===========================================================================================");
        System.out.println(
                "| No |         Nama Mata Kuliah        |  Semester | SKS |          Dosen Pengampu        |");
        System.out.println(
                "===========================================================================================");
        boolean adaData = false;
        for (int l = 0; l < mataKuliah.length; l++) {
            if (mataKuliah[l][0] != null) {
                adaData = true;
                System.out.printf("| %-2d | %-31s | %-9s | %-3s | %-30s |%n", l + 1,
                        mataKuliah[l][0], (mataKuliah[l][1] != null ? mataKuliah[l][1] : "-"),
                        (mataKuliah[l][2] != null ? mataKuliah[l][2] : "-"),
                        (mataKuliah[l][3] != null ? mataKuliah[l][3] : "-"));
            } else {
                break;
            }
        }
        System.out.println(
                "===========================================================================================" + ANSI_RESET);

        if (!adaData) {
            System.out.println("Belum ada data mata kuliah yang diinput.");
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah log out" + ANSI_RESET);
            wantsToLogout = true;
        }
    }

    static void pelaporanNilai(String namaMahasiswa, String nim, String ttl, String namaMatkul, int sksMatkul,int jamMatkul, String nilaiMatkulHuruf, double nilaiMatkulAngka) {
    
    }

    static void menuDosen() {
        int inputMenu;
        if (isLoggedIn) {
            while (isLoggedDosen) {
                System.out.println(ANSI_GREEN + "======================================");
                System.out.println(ANSI_GREEN + "|            HALAMAN DOSEN            |");
                System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
                System.out.println("Pilihan Menu : ");
                System.out.println("|1| Input nilai mahasiswa");
                System.out.println("|2| Keluar dari halaman dosen\n");
                System.out.print("Menu yang anda pilih (1-2): ");
                inputMenu = sc.nextInt();
                sc.nextLine();

                switch (inputMenu) {
                    case 1:
                        inputNilaiMhs();
                        break;
                    case 2:
                        isLoggedDosen = false;
                        System.out.print("Anda telah keluar dari halaman dosen");
                        break;

                    default:
                        System.out.println(ANSI_RED + "Menu yang anda pilih tidak tersedia");
                        System.out.println("Silahkan memasukkan pilihan menu kembali" + ANSI_RESET);
                        break;
                }
            }
        }
    }

    static void inputNilaiMhs() {
        Scanner scanner = new Scanner(System.in);
        boolean inputLagi = true;
        do {
            // Input data mahasiswa
            System.out.print("Masukkan Nama Mahasiswa: ");
            String namaMahasiswa = scanner.next();
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = scanner.next();
            System.out.print("Masukkan Tempat, Tanggal Lahir: ");
            String ttl = scanner.next();

            // Input jumlah mata kuliah
            System.out.print("Masukkan Jumlah Mata Kuliah: ");
            int jmlMataKuliah = scanner.nextInt();
            System.out.println("====================================");

            // Input nilai mata kuliah
            for (int k = 0; k < jmlMataKuliah; k++) {
                scanner.nextLine();
                System.out.print("\nMasukkan Nama Mata Kuliah ke-" + (k + 1) + ": ");
                String namaMatkul = scanner.nextLine();
                System.out.print("Masukkan SKS Mata Kuliah ke-" + (k + 1) + ": ");
                int sksMatkul = scanner.nextInt();
                System.out.print("Masukkan Jam Mata Kuliah ke-" + (k + 1) + ": ");
                int jamMatkul = scanner.nextInt();
                System.out.print("Masukkan Nilai Mata Kuliah ke-" + (k + 1) + ": ");
                String nilaiMatkulHuruf= scanner.next().toUpperCase();
                double nilaiMatkulAngka;
                switch (nilaiMatkulHuruf) {
                    case "A":
                        nilaiMatkulAngka = 4.0;
                        break;
                    case "B+":
                        nilaiMatkulAngka = 3.5;
                        break;
                    case "B":
                        nilaiMatkulAngka = 3.0;
                        break;
                    case "C+":
                        nilaiMatkulAngka = 2.5;
                        break;
                    case "C":
                        nilaiMatkulAngka = 2.0;
                        break;
                    default:
                        nilaiMatkulAngka = 0.0;
                }
                pelaporanNilai(namaMahasiswa, nim, ttl, namaMatkul, sksMatkul, jamMatkul, nilaiMatkulHuruf, nilaiMatkulAngka);
            }
            
        } while (inputLagi);
        scanner.close();
    }

    static char konversiNilaiHuruf(double rataRata) {
        if (rataRata >= 85) {
            return 'A';
        } else if (rataRata >= 70) {
            return 'B';
        } else if (rataRata >= 55) {
            return 'C';
        } else if (rataRata >= 40) {
            return 'D';
        } else {
            return 'E';
        }

    }

    static void menuMahasiswa() {
        int inputMenu;
        if (isLoggedIn) {
            if (isLoggedMahasiswa) {
                System.out.println(ANSI_GREEN + "======================================");
                System.out.println(ANSI_GREEN + "|          HALAMAN MAHASISWA         |");
                System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
                System.out.println("Pilihan Menu : ");
                System.out.println("|1| Update data mahasiswa");
                System.out.println("|2| Cetak KHS dan Nilai");
                System.out.println("|3| Searching Matkul");
                System.out.println("|4| Keluar dari halaman mahasiswa");
                System.out.print("Menu yang anda pilih (1-4): ");
                inputMenu = sc.nextInt();
                sc.nextLine();

                switch (inputMenu) {
                    case 1:
                        updateDataMhs();
                        break;
                    case 2:
                        cetakKHS();
                        break;
                    case 3:
                        searchingMatkul();
                        break;
                    case 4:
                        isLoggedMahasiswa = false;
                        System.out.print("Anda telah keluar dari halaman Admin");
                        break;

                    default:
                        System.out.println(ANSI_RED + "Menu yang anda pilih tidak tersedia");
                        System.out.println("Silahkan memasukkan pilihan menu kembali" + ANSI_RESET);
                        break;
                }
            }
        }
    }

    static void updateDataMhs() {
        System.out.println("Pilih pengguna mahasiswa untuk memperbarui data:");
        for (int i = 2; i < userData.length; i++) { 
            System.out.println((i - 1) + " " + userData[i][0]);
        }
        System.out.print("Masukkan angka pilihan: ");
        int pilihan = sc.nextInt();
        // Memperbarui data pengguna
        String[] selectedUser;
        if (pilihan > 0 && pilihan <= userData.length) {
            selectedUser = userData[pilihan + 1];

            System.out.println(ANSI_BLUE + "\nData yang tersedia untuk pengguna " + selectedUser[0] + ":");
            System.out.println(
                    "===================================================================================================================================");
            System.out.printf("| %-18s | %-18s | %-18s | %-15s | %-10s | %-15s | %-15s | \n",
                    "Username", "Password","NIM", "No Telepon", "Agama", "Jenis Kelamin",
                    "Tanggal Lahir");
            System.out.println(
                    "===================================================================================================================================");
            System.out.printf("| %-18s | %-18s | %-18s | %-15s | %-10s | %-15s | %-15s | \n",
                    selectedUser[0], selectedUser[1], selectedUser[2], selectedUser[3],
                    selectedUser[4], selectedUser[5], selectedUser[6]);
            System.out.println(
                    "===================================================================================================================================" + ANSI_RESET);

                    System.out.println("Keterangan : ");
                    System.out.println("0. Username");
                    System.out.println("1. Password");
                    System.out.println("3. No Telepon");
                    System.out.println("4. Agama");
                    System.out.println("6. Tanggal Lahir");
            System.out.print("Masukkan data yang ingin diubah: ");

            int dataChoice = sc.nextInt();

            if (dataChoice > 0 && dataChoice < selectedUser.length) {
                sc.nextLine();
                System.out.print("Masukkan data baru : ");
                String newData = sc.next();
                selectedUser[dataChoice] = newData;
            } else {
                System.out.println("Pilihan tidak valid");
            }

            // menampilkan data pengguna
            System.out.println(ANSI_BLUE + "\nData Pengguna Baru:");
            System.out.println(
                    "===================================================================================================================================");
            System.out.printf("| %-18s | %-18s | %-18s | %-15s | %-10s | %-15s | %-15s | \n" , "Username",
                    "Password", "NIM", "No Telepon", "Agama", "Jenis Kelamin", "Tanggal Lahir");
            System.out.println(
                    "===================================================================================================================================");
            for (int i = 0; i < userData.length; i++) {
                System.out.printf("| %-18s | %-18s | %-18s | %-15s | %-10s | %-15s | %-15s | \n",
                        userData[i][0], userData[i][1], userData[i][2], userData[i][3], userData[i][4], userData[i][5],
                        userData[i][6]);
            }
            System.out.println(
                    "===================================================================================================================================" + ANSI_RESET);
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.next();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah log out" + ANSI_RESET);
            wantsToLogout = true;
        }
    }

    static void cetakKHS() {
        // Cetak KHS
            // double totalNilai = 0;
            // int totalSKS = 0;
            // System.out.println("====================================================");
            // System.out.println("|             Kartu Hasil Studi (KHS)              |");
            // System.out.println("====================================================");
            // System.out.println("Nama    : " + namaMahasiswa);
            // System.out.println("NIM     : " + nim);
            // System.out.println("TTL     : " + ttl);
            // System.out.println("=======================================");
            // System.out.printf("| %-15s | %-3s | %-3s | %-5s |%n", "Mata Kuliah", "SKS", "Jam",
            //         "Nilai");
            // System.out.println("=======================================");
            // for (int k = 0; k < namaMatkul.length; k++) {
            //     System.out.printf("| %-15s | %-3d | %-3d | %-5s |%n", namaMatkul[k], sksMatkul[k],
            //             jamMatkul[k],
            //             nilaiMatkulHuruf[k]);
            //     totalNilai += nilaiMatkulAngka[k] * sksMatkul[k];
            //     totalSKS += sksMatkul[k];
            //     System.out.println("=======================================");
            // }
            // double ipk = totalNilai / totalSKS;
            // System.out.println("IPK  " + ipk);
            // System.out.println();
            // System.out.print("Apakah Anda ingin menginput KHS lain? (y/t): ");
            // String pilihan = scanner.next();
            // inputLagi = pilihan.equalsIgnoreCase("y");
            // System.out.println(
            //         "========================================================================================================================");
            // System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
            // inputAgain = sc.nextLine();
            // if (inputAgain.equalsIgnoreCase("t")) {
            //     System.out.println("Anda telah log out");
            //     break;
            // }

    }
    static void searchingMatkul() {
        String[] matkul = { "CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA" };
        String[] hari = new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jum'at", "Sabtu", "Minggu" };
        boolean inginCariLagi = true;
        while (inginCariLagi) {
            System.out.println("Matkul anda adalah sebagai berikut : ");
            for (int i = 0; i < matkul.length; i++) {
                System.out.println(matkul[i]);
            }
            System.out.print("Masukkan matkul yang ingin dicari : ");
            String inputMatkul = sc.next();
            String hasil = " ";
            boolean find = false;
            for (int i = 0; i < matkul.length; i++) {
                if (matkul[i].equals(inputMatkul)) {
                    find = true;
                    hasil = hari[i];
                    break;
                }
            }
            if (find) {
                System.out.println("Matkul yang anda cari ada di hari: " + hasil);
            } else {
                System.out.println(ANSI_RED + "Matkul tidak ditemukan" + ANSI_RESET);
            }
        }
    }
}
