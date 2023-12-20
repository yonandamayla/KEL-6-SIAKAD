import java.util.Arrays;
import java.util.Scanner;

public class Siakad {
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_RESET = "\u001B[0m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_BLUE = "\u001B[34m";

    static Scanner sc = new Scanner(System.in);
    static String[][] userData = {
            { "Admin", "Admin123" },
            { "Dosen", "Dosen456" },
            { "MahasiswaYonanda", "yonanda789", "Yonanda Mayla Rusdiaty", "2341760184", "082139631334", "Islam", "P",
                    "05/05/2005" },
            { "MahasiswaDhynar", "dhynar789", "Queenadhynar Azarine Dwipa A.", "2341760109", "081238285591", "Islam",
                    "P", "09/09/2004" },
            { "MahasiswaAfril", "afril789", "Afril Maulana Rizky", "2341760067", "082245773455", "Islam", "L",
                    "05/04/2005" },
            { "MahasiswaRama", "rama789", "Ramadan Maulana", "2341760125", "085648275713", "Islam", "L", "11/11/2004" }
    };

    static boolean isLoggedIn = false;
    static boolean isLoggedAdmin = false;
    static boolean isLoggedDosen = false;
    static boolean isLoggedMahasiswa = false;
    static boolean wantsToLogout = false;
    static String inputAgain;
    static int jumlahMataKuliah = 9;
    static String[] matkul = { "CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA" };
    static int jumlahMahasiswa = 4;
    static int[][][] inputNilai = new int[jumlahMahasiswa][matkul.length][2];
    static String[] namaMahasiswa = new String[jumlahMahasiswa];
    static int[] sksMatkul = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    static int pelaporanNilai;
    static int indexUser;
    static String username;
    static String password;
    double nilaiMatkulAngka;

    public static void main(String[] args) {
        while (true) {
            login();
            if (isLoggedAdmin) {
                menuAdmin();
            } else if (isLoggedDosen) {
                menuDosen();
            } else if (isLoggedMahasiswa) {
                menuMahasiswa();
            }
        }
    }

    static String login() {
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
            username = sc.next();
            System.out.print("Password      : ");
            password = sc.next();

            for (i = 0; i < userData.length; i++) {
                if (userData[0][0].equals(username) && userData[0][1].equals(password)) {
                    isLoggedAdmin = true;
                    isLoggedIn = true;
                    wantsToLogout = false;
                    break;
                } else if (userData[1][0].equals(username) && userData[1][1].equals(password)) {
                    isLoggedDosen = true;
                    isLoggedIn = true;
                    wantsToLogout = false;
                    break;
                }
            }
            for (i = 2; i < userData.length; i++) {
                if (userData[i][0].equals(username) && userData[i][1].equals(password)) {
                    isLoggedAdmin = false;
                    isLoggedDosen = false;
                    isLoggedMahasiswa = true;
                    isLoggedIn = true;
                    wantsToLogout = false;
                    session = "mahasiswa";
                    indexUser = i;
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
                    System.out.println("|4| Keluar dari halaman admin");
                    System.out.println("|5| Keluar dari program\n");
                    System.out.print("Menu yang anda pilih (1-5): ");
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
                            pelaporanNilai();
                            break;
                        case 4:
                            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Admin");
                            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
                            wantsToLogout = true;
                            isLoggedAdmin = false;
                            break;
                        case 5:
                            System.out.println(ANSI_RED + "Anda telah keluar dari program" + ANSI_RESET);
                            System.exit(0);
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
        String[][] dataMahasiswa = new String[4][8];
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
            System.out.print("Nama                          : ");
            dataMahasiswa[i][0] = sc.nextLine();
            System.out.print("NIM                           : ");
            dataMahasiswa[i][1] = sc.nextLine();
            System.out.println("Jurusan                     : ");
            for (int j = 0; j < jurusan.length; j++) {
                System.out.println((j + 1) + ". " + jurusan[j]);
            }
            System.out.print("Jurusan yang dipilih          : ");
            int inputJurusan = sc.nextInt();
            dataMahasiswa[i][2] = jurusan[--inputJurusan];
            sc.nextLine();
            System.out.println("Prodi                       : ");
            for (int j = 0; j < prodi[inputJurusan].length; j++) {
                System.out.println((j + 1) + ". " + prodi[inputJurusan][j]);
            }
            System.out.print("Prodi yang dipilih            : ");
            int inputProdi = sc.nextInt();
            dataMahasiswa[i][3] = prodi[inputJurusan][--inputProdi];
            sc.nextLine();
            System.out.print("Nomor Telepon                 : ");
            dataMahasiswa[i][4] = sc.nextLine();
            System.out.print("Agama                         : ");
            dataMahasiswa[i][5] = sc.nextLine();
            System.out.print("Jenis Kelamin (L/P)           : ");
            dataMahasiswa[i][6] = sc.nextLine();
            System.out.print("Tanggal Lahir (dd/mm/yy)      : ");
            dataMahasiswa[i][7] = sc.nextLine();
            i++;
            System.out.print("Apakah anda ingin melanjutkan input data mahasiswa lain? (y/t) : ");
            inputData = sc.nextLine();

        } while (inputData.equalsIgnoreCase("y"));

        // Bubble sort based on names (dataMahasiswa[i][0]) / mengurutkan data mahasiswa
        // berdasarkan abjad nama
        for (int k = 0; k < i - 1; k++) {
            for (int j = 0; j < i - k - 1; j++) {
                if (dataMahasiswa[j][0].compareTo(dataMahasiswa[j + 1][0]) > 0) {
                    // Swap
                    String[] temp = dataMahasiswa[j];
                    dataMahasiswa[j] = dataMahasiswa[j + 1];
                    dataMahasiswa[j + 1] = temp;
                }
            }
        }

        System.out.println("Daftar mahasiswa yang berhasil terinput:");
        System.out.println(ANSI_BLUE
                + "======================================================================================================================================================================================================");
        System.out.printf(ANSI_BLUE + "| %-4s | %-37s | %-12s | %-20s | %-48s | %-13s | %-10s | %-13s | %-13s |\n",
                "No", "Nama", "NIM", "Jurusan", "Program Studi", "Nomor Telepon", "Agama", "Jenis Kelamin",
                "Tanggal Lahir");
        System.out.println(ANSI_BLUE
                + "======================================================================================================================================================================================================");

        for (int j = 0; j < i; j++) {
            if (dataMahasiswa[j][0] != null && !dataMahasiswa[j][0].isEmpty() &&
                    dataMahasiswa[j][1] != null && !dataMahasiswa[j][1].isEmpty() &&
                    dataMahasiswa[j][2] != null && !dataMahasiswa[j][2].isEmpty() &&
                    dataMahasiswa[j][3] != null && !dataMahasiswa[j][3].isEmpty() &&
                    dataMahasiswa[j][4] != null && !dataMahasiswa[j][4].isEmpty() &&
                    dataMahasiswa[j][5] != null && !dataMahasiswa[j][5].isEmpty() &&
                    dataMahasiswa[j][6] != null && !dataMahasiswa[j][6].isEmpty() &&
                    dataMahasiswa[j][7] != null && !dataMahasiswa[j][7].isEmpty()) {
                System.out.printf(ANSI_BLUE + "| %-4d | %-37s | %-12s | %-20s | %-48s | %-13s | %-10s | %-13s | %-13s |\n",
                        (j + 1), dataMahasiswa[j][0], dataMahasiswa[j][1],
                        dataMahasiswa[j][2], dataMahasiswa[j][3], dataMahasiswa[j][4], dataMahasiswa[j][5],
                        dataMahasiswa[j][6], dataMahasiswa[j][7]);
            }
            System.out.println(
                    ANSI_BLUE + "======================================================================================================================================================================================================"
                            + ANSI_RESET);
        }

        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Admin");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedAdmin = false;
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
                "==========================================================================================="
                        + ANSI_RESET);

        if (!adaData) {
            System.out.println("Belum ada data mata kuliah yang diinput.");
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Admin");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedAdmin = false;
        }
    }

    static void pelaporanNilai() {
        double totalNilai = 0;
        int totalSKS = 0;
        while (true) {
            for (int i = 0; i < matkul.length; i++) {
                if (inputNilai[0][i][0] == 0) { // berfungsi untuk check apakah data nilai sudah diinputkan pada
                                                // matkul[i]
                    continue;
                }
                System.out.println();
                System.out.println("Mata Kuliah: " + matkul[i]);
                System.out.println(ANSI_BLUE +
                        "===========================================================================================");
                System.out.println(
                        "Nama Mahasiswa     \t\t\t| Nilai UTS | Nilai UAS | Rata-rata | Nilai Huruf |");
                System.out.println(
                        "==========================================================================================="
                                + ANSI_RESET);
                for (int j = 0, k = 0; j < userData.length && k < jumlahMahasiswa; j++) {
                    if (userData[j].length != 8) { // berfungsi untuk check apakah userData[j] merupakan data mahasiswa
                        continue;
                    }
                    double rataRata = hitungRataRata(inputNilai[k][i]);
                    String nilaiHuruf = konversiNilaiHuruf(rataRata);
                    double nilaiMatkulAngka = konversiNilaiAngka(nilaiHuruf, rataRata);
                    double IPK = hitungIPK(rataRata);
                    totalNilai += nilaiMatkulAngka * sksMatkul[i];
                    totalSKS += sksMatkul[i];
                    System.out.printf(ANSI_BLUE + "%-39s | %-9d | %-9d | %-9.3f | %-11s |\n", userData[j][2],
                            inputNilai[k][i][0], inputNilai[k][i][1], rataRata, nilaiHuruf);
                    k++;
                }
                System.out.println(
                        "==========================================================================================="
                                + ANSI_RESET);
                System.out.println();
                System.out.println("IPK");
                System.out.println("Daftar Nilai:");
                System.out.println("Mata Kuliah: " + matkul[i]);
                System.out.println(ANSI_BLUE +
                        "===============================================");
                System.out.println(
                        "Nama Mahasiswa     \t\t\t| IPK |");
                System.out.println(
                        "==============================================="
                                + ANSI_RESET);
                for (int j = 0, k = 0; j < userData.length && k < jumlahMahasiswa; j++) {
                    if (userData[j].length != 8) { // berfungsi untuk check apakah userData[j] merupakan data mahasiswa
                        continue;
                    }
                    // totalSKS += sksMatkul[i];
                    double rataRata = (inputNilai[k][i][0] + inputNilai[k][i][1]) / 2.0;
                    double IPK = hitungIPK(rataRata);
                    System.out.printf(ANSI_BLUE + "%-39s | %-3s |\n", userData[j][2], IPK);
                    k++;
                }
                System.out.println(
                        "==============================================="
                                + ANSI_RESET);
            }
            System.out.println(ANSI_GREEN + "Nilai berhasil Dipublish" + ANSI_RESET);
            System.out.println();
            System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
            inputAgain = sc.nextLine();
            if (inputAgain.equalsIgnoreCase("t")) {
                System.out.println(ANSI_RED + "Anda telah keluar dari halaman Admin");
                System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
                wantsToLogout = true;
                isLoggedAdmin = false;
                break;
            } else {
                wantsToLogout = false;
                isLoggedAdmin = true;
                break;
            }
        }
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
                System.out.println("|2| Keluar dari halaman dosen");
                System.out.println("|3| Keluar dari program\n");
                System.out.print("Menu yang anda pilih (1-3): ");
                inputMenu = sc.nextInt();
                sc.nextLine();

                switch (inputMenu) {
                    case 1:
                        inputNilaiMahasiswa();
                        break;
                    case 2:
                        System.out.println(ANSI_RED + "Anda telah keluar dari halaman Dosen");
                        System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
                        wantsToLogout = false;
                        isLoggedDosen = false;
                        break;
                    case 3:
                        System.out.println(ANSI_RED + "Anda telah keluar dari program" + ANSI_RESET);
                        System.exit(0);
                        break;

                    default:
                        System.out.println(ANSI_RED + "Menu yang anda pilih tidak tersedia");
                        System.out.println("Silahkan memasukkan pilihan menu kembali" + ANSI_RESET);
                        break;
                }
            }
        }
    }

    static void inputNilaiMahasiswa() {
        Scanner input = new Scanner(System.in);
        do {
            int matkulIndex = -1;
            System.out.println("====================================================");
            System.out.print("Masukkan matkul yang akan diinputkan nilainya : ");
            String inputMatkul = input.next();
            for (int i = 0, j = 0; i < matkul.length; i++) {
                if (matkul[i].equalsIgnoreCase(inputMatkul)) {
                    matkulIndex = i;
                    break;
                }
            }
            if (matkulIndex != -1) {
                System.out.println("Matkul yang ingin diinputkan nilai ditemukan: " + inputMatkul);
                System.out.println("=====================================================");
                for (int i = 0, j = 0; i < inputNilai.length && j < userData.length; j++) {
                    if (userData[j].length != 8) {
                        continue;
                    }
                    System.out.println("Menginput nilai untuk mahasiswa ke-" + (i + 1));
                    input.nextLine();
                    System.out.println("Nama mahasiswa: " + userData[j][2]);
                    System.out.print("Nilai UTS: ");
                    inputNilai[i][matkulIndex][0] = input.nextInt();
                    System.out.print("Nilai UAS: ");
                    inputNilai[i][matkulIndex][1] = input.nextInt();
                    int totalNilai = inputNilai[i][matkulIndex][0] + inputNilai[i][matkulIndex][1];
                    System.out.println();
                    i++;
                }

                System.out.println(
                        "==========================================================================================");
                System.out.println("Mata Kuliah : " + inputMatkul + "\t\t\t\t\t\t\t\t\t  |");
                System.out.println(
                        "Nama Mahasiswa     \t\t\t| Nilai UTS | Nilai UAS | Rata-rata | Nilai Huruf |");
                System.out.println(
                        "==========================================================================================");
                for (int i = 0; i < inputNilai.length; i++) {
                    double rataRata = hitungRataRata(inputNilai[i][matkulIndex]);
                    String nilaiHuruf = konversiNilaiHuruf(rataRata);

                    System.out.printf("%-39s | %-9d | %-9d | %-9.2f | %-11s |\n", userData[i + 2][2],
                            inputNilai[i][matkulIndex][0], inputNilai[i][matkulIndex][1], rataRata, nilaiHuruf);
                }
                System.out.println(
                        "==========================================================================================");
            } else {
                System.out.println("Matkul tidak ditemukan");
                break;
            }
            input.nextLine();
            System.out.print("Apakah Anda ingin menginput nilai untuk mata kuliah lain? (y/t): ");
            inputAgain = input.nextLine();

        } while (inputAgain.equalsIgnoreCase("y"));
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Dosen");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedDosen = false;
        }
    }

    static double hitungRataRata(int[] listNilai) {
        double total = 0;
        for (int i : listNilai) {
            total += i;
        }
        return total / ((double) listNilai.length);
    }

    static double hitungIPK(double rataRata) {
        if (rataRata >= 85) {
            return 4.0;
        } else if (rataRata >= 80) {
            return 3.0;
        } else if (rataRata >= 60) {
            return 2.0;
        } else if (rataRata >= 50) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    static String konversiNilaiHuruf(double rataRata) {
        if (rataRata >= 85) {
            return "A";
        } else if (rataRata >= 80) {
            return "B";
        } else if (rataRata >= 60) {
            return "C";
        } else if (rataRata >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    static double konversiNilaiAngka(String nilaiMatkulHuruf, double rataRata) {
        if (rataRata >= 85) {
            return 4.0;
        } else if (rataRata >= 80) {
            return 3.0;
        } else if (rataRata >= 60) {
            return 2.0;
        } else if (rataRata >= 50) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    static void menuMahasiswa() {
        int inputMenu;
        if (isLoggedIn) {
            while (!wantsToLogout) {
                if (isLoggedMahasiswa) {
                    System.out.println(ANSI_GREEN + "======================================");
                    System.out.println(ANSI_GREEN + "|          HALAMAN MAHASISWA         |");
                    System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
                    System.out.println("Pilihan Menu : ");
                    System.out.println("|1| Update data mahasiswa");
                    System.out.println("|2| Cetak KHS dan Nilai");
                    System.out.println("|3| Searching Matkul");
                    System.out.println("|4| Keluar dari halaman mahasiswa");
                    System.out.println("|5| Keluar dari program\n");
                    System.out.print("Menu yang anda pilih (1-5): ");
                    inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            updateDataMhs();
                            break;
                        case 2:
                            cetakKHS(username, password);
                            break;
                        case 3:
                            searchingMatkul();
                            break;
                        case 4:
                            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Mahasiswa");
                            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
                            wantsToLogout = true;
                            isLoggedMahasiswa = false;
                            break;
                        case 5:
                            System.out.println(ANSI_RED + "Anda telah keluar dari program" + ANSI_RESET);
                            System.exit(0);
                            break;

                        default:
                            System.out.println(ANSI_RED + "Menu yang anda pilih tidak tersedia");
                            System.out.println("Silahkan memasukkan pilihan menu kembali" + ANSI_RESET);
                            break;
                    }
                }
            }
        }
    }

    static void updateDataMhs() {
        int indeksMahasiswa = indexUser;
        do {
            // mengecek apakah indeks mahasiswa ditemukan
            if (indeksMahasiswa < 2) {
                System.out.println("Data mahasiswa tidak ditemukan");
                return;
            }

            // Memperbarui data pengguna
            if (indeksMahasiswa >= 2 && userData[indeksMahasiswa].length == 8) {
                System.out.println(
                        ANSI_BLUE + "\nData yang tersedia untuk pengguna " + userData[indeksMahasiswa][2] + " :");
                System.out.println(
                        "=======================================================================================================================================");
                System.out.printf("| %-16s | %-13s | %-22s | %-12s | %-12s | %-10s | %-8s | %-14s|\n",
                        "Username", "Password", "Nama Lengkap", "NIM", "No Telepon", "Agama", "Jenis Kelamin",
                        "Tanggal Lahir");
                System.out.println(
                        "=======================================================================================================================================");
                System.out.printf("| %-16s | %-13s | %-22s | %-12s | %-12s | %-10s | %-13s | %-14s|\n",
                        userData[indeksMahasiswa][0], userData[indeksMahasiswa][1], userData[indeksMahasiswa][2],
                        userData[indeksMahasiswa][3], userData[indeksMahasiswa][4], userData[indeksMahasiswa][5],
                        userData[indeksMahasiswa][6], userData[indeksMahasiswa][7]);
                System.out.println(
                        "======================================================================================================================================="
                                + ANSI_RESET);
                System.out.println("Keterangan : ");
                System.out.println("0. Username");
                System.out.println("1. Password");
                System.out.println("2. Nama Lengkap");
                System.out.println("3. NIM");
                System.out.println("4. No Telepon");
                System.out.println("5. Agama");
                System.out.println("6. Jenis Kelamin");
                System.out.println("7. Tanggal Lahir");
                System.out.print("Masukkan data yang ingin diubah (angka) : ");
                int dataChoice = sc.nextInt();
                if (dataChoice >= 0 && dataChoice <= userData[indeksMahasiswa].length) {
                    sc.nextLine();
                    System.out.print("Masukkan data baru : ");
                    String newData = sc.next();
                    userData[indeksMahasiswa][dataChoice] = newData;
                } else {
                    System.out.println("Pilihan tidak valid");
                }

                System.out.println(ANSI_BLUE + "\nData Pengguna Baru " + userData[indeksMahasiswa][2] + ":");
                System.out.println(
                        "=======================================================================================================================================");
                System.out.printf("| %-16s | %-13s | %-22s | %-12s | %-12s | %-10s | %-8s | %-14s|\n", "Username",
                        "Password", "Nama Lengkap", "NIM", "No Telepon", "Agama", "Jenis Kelamin", "Tanggal Lahir");
                System.out.println(
                        "=======================================================================================================================================");
                for (int i = 2; i < userData[indeksMahasiswa].length; i++) {
                    System.out.printf("| %-16s | %-13s | %-22s | %-12s | %-12s | %-10s | %-13s | %-14s|\n",
                            userData[indeksMahasiswa][0], userData[indeksMahasiswa][1], userData[indeksMahasiswa][2],
                            userData[indeksMahasiswa][3], userData[indeksMahasiswa][4], userData[indeksMahasiswa][5],
                            userData[indeksMahasiswa][6], userData[indeksMahasiswa][7]);
                    break;
                }
                System.out.println(
                        "======================================================================================================================================="
                                + ANSI_RESET);
            }
            System.out.println();
            System.out.print("Apakah anda ingin mengupdate data yang lain? (y/t) = ");
            inputAgain = sc.next();
        } while (inputAgain.equalsIgnoreCase("y"));
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.next();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Mahasiswa");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedMahasiswa = false;
        }
    }

    static void cetakKHS(String username, String password) {
        int indeksMahasiswa = indexUser;

        // mengecek apakah indeks mahasiswa ditemukan
        if (indeksMahasiswa < 2) {
            System.out.println("Data mahasiswa tidak ditemukan");
            return;
        }

        if (indeksMahasiswa >= 2 && userData[indeksMahasiswa].length == 8) {
            System.out.println(
                    ANSI_BLUE
                            + "========================================================================================");
            System.out.println(
                    "|                                   Kartu Hasil Studi (KHS)                             |");
            System.out.println(
                    "========================================================================================");
            System.out.println("Nama            : " +
                    userData[indeksMahasiswa][2]);
            System.out.println("NIM             : " + userData[indeksMahasiswa][3]);
            System.out.println("Jenis Kelamin   : "
                    + (userData[indeksMahasiswa][6].equalsIgnoreCase("L") ? "Laki-laki" : "Perempuan"));
            System.out.println("Tanggal Lahir   : " + userData[indeksMahasiswa][7]);
            System.out.println(
                    "========================================================================================");

            // Cetak header untuk tabel KHS
            System.out.printf("%-30s | %-9s | %-9s | %-8s | %-10s | %-3s |\n",
                    "Mata Kuliah", "Nilai UTS", "Nilai UAS", "Rata-rata", "Nilai Huruf", "SKS");
            System.out.println(
                    "========================================================================================");

            for (int i = 0; i < matkul.length; i++) {
                double rataRata = hitungRataRata(inputNilai[indeksMahasiswa - 2][i]);
                String nilaiHuruf = konversiNilaiHuruf(rataRata);

                // Cetak detail mata kuliah untuk KHS
                System.out.printf("%-30s | %-9d | %-9d | %-9.2f | %-11s | %-3d |\n",
                        matkul[i],
                        inputNilai[indeksMahasiswa - 2][i][0], inputNilai[indeksMahasiswa - 2][i][1],
                        rataRata,
                        nilaiHuruf,
                        sksMatkul[i]);
            }

            // Hitung dan cetak IPK
            double totalNilai = 0;
            int totalSKS = 0;
            for (int i = 0, k = 0; i < matkul.length && k < jumlahMahasiswa; i++) {
                if (inputNilai[indeksMahasiswa - 2][i][0] != 0) {
                    double rataRata = hitungRataRata(inputNilai[k][i]);
                    String nilaiHuruf = konversiNilaiHuruf(rataRata);
                    double nilaiMatkulAngka = konversiNilaiAngka(nilaiHuruf, rataRata);
                    double IPK = hitungIPK(rataRata);
                    totalNilai += nilaiMatkulAngka * sksMatkul[i];
                    totalSKS += sksMatkul[i];
                }
            }

            double ipk = totalSKS > 0 ? totalNilai / totalSKS : 0;

            System.out
                    .println("=======================================================================================");
            System.out.printf("Total SKS: %d\n", totalSKS);
            System.out.printf("IPK: %.3f\n", ipk);
            System.out
                    .println("======================================================================================="
                            + ANSI_RESET);
        } else {
            System.out.println("Data mahasiswa tidak ditemukan");
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.nextLine();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Dosen");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedDosen = false;
        }
    }

    static void searchingMatkul() {
        String[] matkul = { "CTPS", "KTI", "AGAMA", "PRAKDASPRO", "BING", "MTKDAS", "DASPRO", "BINDO", "PAMB" };
        String[] hari = { "Senin", "Senin", "Selasa", "Selasa", "Rabu", "Rabu", "Kamis", "Jum'at", "Jum'at" };
        String[] dosen = { "Mamluatul Hani'ah, S.Kom., M.Kom.", "Ariadi Retno Tri Hayati Ririd, S.Kom., M.Kom.",
                "Astrifidha Rahma Amalia, S.Pd., M.Pd.", "Triana Fatmawati, S.T., M.T.",
                "Faiz Ushbah Mubarok, S.Pd., M.Pd.", "Annisa Puspa Kirana, S.Kom., M.Kom.",
                "Triana Fatmawati, S.T., M.T.", "Zulmy Faqihuddin Putera, S.Pd., M.Pd.",
                "Hendra Pradibta, S.E., M.Sc." };
        boolean inginCariLagi = true;
        while (inginCariLagi) {
            System.out.println(ANSI_BLUE + "===============================================================");
            System.out.printf("%-15s | %-15s%n", "Mata Kuliah", "Dosen Pengampu");
            System.out.println("===============================================================");
            for (int i = 0; i < matkul.length; i++) {
                System.out.printf("%-15s | %-15s%n", matkul[i], dosen[i]);
            }
            System.out.println("===============================================================" + ANSI_RESET);
            System.out.print("Masukkan matkul yang ingin dicari : ");
            String inputMatkul = sc.next();
            String hasilHari = " ";
            String hasilDosen = " ";
            boolean find = false;
            for (int i = 0; i < matkul.length; i++) {
                if (matkul[i].equalsIgnoreCase(inputMatkul)) {
                    find = true;
                    hasilHari = hari[i];
                    hasilDosen = dosen[i];
                    break;
                }
            }
            if (find) {
                System.out.println("Matkul yang anda cari ada di hari: " + hasilHari);
                System.out.println("Dosen Pengampu: " + hasilDosen);
            } else {
                System.out.println("Matkul tidak ditemukan");
            }
            System.out.print("Ingin mencari matkul lagi? (y/t): ");
            String jawaban = sc.next();

            if (jawaban.equalsIgnoreCase("t")) {
                inginCariLagi = false;
            }
        }
        System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
        inputAgain = sc.next();
        if (inputAgain.equalsIgnoreCase("t")) {
            System.out.println(ANSI_RED + "Anda telah keluar dari halaman Mahasiswa");
            System.out.println("Silahkan masukkan username dan password kembali\n" + ANSI_RESET);
            wantsToLogout = true;
            isLoggedMahasiswa = false;
        }
    }
}