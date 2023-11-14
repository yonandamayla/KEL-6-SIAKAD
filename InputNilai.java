import java.util.Scanner;

public class InputNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matkul = {"CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA"};

        boolean inputLagi = true;

        do {
            String[] find = new String[1];

            System.out.print("Masukkan matkul yang ingin Diinput nilai: ");
            String inpmatkul = scanner.nextLine();

            boolean findd = false;
            for (int i = 0; i < matkul.length; i++) {
                if (matkul[i].equalsIgnoreCase(inpmatkul)) {
                    findd = true;
                    find[0] = matkul[i];
                    break;
                }
            }

            if (findd) {
                System.out.println("Matkul yang ingin diinput nilai ditemukan: " + find[0]);
                System.out.println("===============================================");

                int[][] inputNilai = new int[2][2];
                String[] namaMahasiswa = new String[4];

                for (int i = 0; i < inputNilai.length; i++) {
                    System.out.println("Menginput nilai untuk mahasiswa ke-" + (i + 1));

                    System.out.print("Masukkan nama mahasiswa: ");
                    namaMahasiswa[i] = scanner.nextLine();

                    System.out.print("Masukkan Nilai UTS: ");
                    inputNilai[i][0] = scanner.nextInt();

                    System.out.print("Masukkan Nilai UAS: ");
                    inputNilai[i][1] = scanner.nextInt();

                    scanner.nextLine();
                }
                System.out.println("============================================================================");

                // Menampilkan hasil input dan rata-rata nilai
                System.out.println(find[0]);
                System.out.println("Nama Mahasiswa     \t\t\t| Nilai UTS | Nilai UAS | Rata-rata");
                System.out.println("----------------------------------------------------------------------------");
                for (int i = 0; i < inputNilai.length; i++) {
                    double rataRata = (inputNilai[i][0] + inputNilai[i][1]) / 2.0;
                    System.out.printf("%-39s | %-9d | %-9d | %-8.2f\n", namaMahasiswa[i], inputNilai[i][0], inputNilai[i][1], rataRata);
                }
                System.out.println();

            } else {
                System.out.println("Matkul tidak ditemukan");
            }

            System.out.print("Apakah Anda ingin menginput nilai untuk mata kuliah lain? (y/n): ");
            String pilihan = scanner.nextLine();
            inputLagi = pilihan.equalsIgnoreCase("y");

        } while (inputLagi);

        scanner.close();
    }
}
