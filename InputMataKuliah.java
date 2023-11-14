import java.util.Scanner;

public class InputMataKuliah {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] mataKuliah = new String[9][4];

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.println("Masukkan data mata kuliah ke-" + (i + 1));

            System.out.print("Masukkan Nama Mata Kuliah: ");
            mataKuliah[i][0] = sc.nextLine();

            System.out.print("Masukkan Semester: ");
            mataKuliah[i][1] = sc.nextLine();

            System.out.print("Masukkan SKS Mata Kuliah: ");
            mataKuliah[i][2] = sc.nextLine();

            System.out.print("Masukkan Dosen Pengampu: ");
            mataKuliah[i][3] = sc.nextLine();

            System.out.println();
        }

       
        System.out.println("\nData mata kuliah yang telah diinput:");
        System.out.println();
        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.println("Nama Mata Kuliah: " + mataKuliah[i][0]);
            System.out.println("Semester: " + mataKuliah[i][1]);
            System.out.println("SKS mata kuliah: " + mataKuliah[i][2]);
            System.out.println("Dosen Pengampu: " + mataKuliah[i][3]);
            System.out.println("====================================");
        }
    }
}