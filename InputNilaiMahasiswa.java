import java.util.Scanner;

public class InputNilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Jumlah mahasiswa
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();

        // Array untuk nilai mahasiswa
        int[][] nilaiMahasiswa = new int[jumlahMahasiswa][];

        // Memasukkan nilai untuk setiap mahasiswa dan mata kuliah
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMatkul = input.nextInt();
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            nilaiMahasiswa[i] = new int[jumlahMatkul];
            for (int j = 0; j < jumlahMatkul; j++) {
                System.out.print("Masukkan nilai mata kuliah ke-" + (j + 1) + " : ");
                nilaiMahasiswa[i][j] = input.nextInt();
            }
        }
        input.close();
        
        // Menampilkan nilai mahasiswa
        System.out.println("\nNilai Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.print("Mahasiswa " + (i + 1) + ": ");
            int totalNilai = 0;
            for (int j = 0; j < nilaiMahasiswa[i].length; j++) {
                System.out.print(nilaiMahasiswa[i][j] + " ");
                totalNilai = totalNilai + nilaiMahasiswa[i][j];
            }
            double rataNilai = (double) totalNilai / jumlahMatkul;
            System.out.println("\nRata-rata : " + rataNilai);
            System.out.println();
        }
    }
}
