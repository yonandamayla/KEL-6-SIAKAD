import java.util.Scanner;

public class CetakKHS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data mahasiswa
        String namaMahasiswa, nim, ttl;
        System.out.print("Masukkan Nama Mahasiswa: ");
        namaMahasiswa = input.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        nim = input.nextLine();
        System.out.print("Masukkan Tempat, Tanggal Lahir: ");
        ttl = input.nextLine();

        // Input jumlah mata kuliah
        System.out.print("Masukkan Jumlah Mata Kuliah: ");
        int jumlahMataKuliah = input.nextInt();
        System.out.println("------");

        // Inisialisasi array nilaiMataKuliah
        String[] namaMatkul = new String[jumlahMataKuliah];
        int[] sksMatkul = new int[jumlahMataKuliah];
        int[] jamMatkul = new int[jumlahMataKuliah];
        String[] nilaiMatkulHuruf = new String[jumlahMataKuliah];
        double[] nilaiMatkulAngka = new double[jumlahMataKuliah];

        // Input nilai mata kuliah
        for (int i = 0; i < jumlahMataKuliah; i++) {
            input.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Nama Mata Kuliah ke-" + (i + 1) + ": ");
            namaMatkul[i] = input.nextLine();
            System.out.print("Masukkan SKS Mata Kuliah ke-" + (i + 1) + ": ");
            sksMatkul[i] = input.nextInt();
            System.out.print("Masukkan Jam Mata Kuliah ke-" + (i + 1) + ": ");
            jamMatkul[i] = input.nextInt();
            System.out.print("Masukkan Nilai Mata Kuliah ke-" + (i + 1) + ": ");
            nilaiMatkulHuruf[i] = input.next().toUpperCase(); // Konversi ke huruf besar
            nilaiMatkulAngka[i] = konversiNilaiKeAngka(nilaiMatkulHuruf[i]);
            System.out.println("------");
        }
        System.out.println();

        // Cetak KHS
        cetakKHS(namaMahasiswa, nim, ttl, namaMatkul, sksMatkul, jamMatkul, nilaiMatkulHuruf, nilaiMatkulAngka);

        // Tutup scanner
        input.close();
    }

    // Fungsi untuk mengonversi nilai huruf ke angka
    private static double konversiNilaiKeAngka(String nilaiHuruf) {
        switch (nilaiHuruf) {
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            default:
                return 0.0;
        }
    }

    // Fungsi untuk mencetak KHS
    private static void cetakKHS(String namaMahasiswa, String nim, String ttl, String[] namaMatkul,
                                  int[] sksMatkul, int[] jamMatkul, String[] nilaiMatkulHuruf, double[] nilaiMatkulAngka) {
        System.out.println("==========================");
        System.out.println("Kartu Hasil Studi (KHS)");
        System.out.println("==========================");
        System.out.println("Nama: " + namaMahasiswa);
        System.out.println("NIM: " + nim);
        System.out.println("TTL: " + ttl);
        System.out.println("-----------------------------------------------");
        System.out.println("Mata Kuliah\tSKS\tJam\tNilai\tBobot");
        System.out.println("-----------------------------------------------");

        double totalNilai = 0;
        int totalSKS = 0;

        for (int i = 0; i < namaMatkul.length; i++) {
            System.out.printf("%-15s\t%d\t%d\t%s\t%.1f%n", namaMatkul[i], sksMatkul[i], jamMatkul[i],
                    nilaiMatkulHuruf[i], nilaiMatkulAngka[i]);
            totalNilai += nilaiMatkulAngka[i] * sksMatkul[i];
            totalSKS += sksMatkul[i];
        }

        double ipk = totalNilai / totalSKS;
        System.out.println("-----------------------------------------------");
        System.out.printf("IPK\t%.2f%n", ipk);
    }
}
