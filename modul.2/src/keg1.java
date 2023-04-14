import java.util.ArrayList;
import java.util.Scanner;

public class keg1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Inisiasi List Of Array Nama Hewan
        ArrayList<String> hewan = new ArrayList<>();
        hewan.add("Angsa");
        hewan.add("Bebek");
        hewan.add("Cicak");
        hewan.add("Domba");
        hewan.add("Elang");
        hewan.add("Gajah");

        boolean isLanjutkan = true;
        //Digunakan agar dapat melakukan Looping, saat boolean berada di posisi true looping akan terus berjalan dan
        //saat boolean berada di posisi false looping akan berhenti

        while (isLanjutkan) {
            System.out.println("Menu:");
            System.out.println("1. Tampilkan semua hewan");
            System.out.println("2. Tampilkan jumlah elemen dan posisi index hewan");
            System.out.println("3. Tambahkan nama hewan");
            System.out.println("4. Hapus nama hewan");
            System.out.println("5. Ubah nama hewan");
            System.out.println("6. Tampilkan indeks pertama dan terakhir");
            System.out.println("7. Keluar");

            //Memasukkan Pilihan Nomor Menu
            System.out.print("Pilih menu (1-7): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                //MENAMPILKAN ISI INDEX
                case 1:
                    System.out.println("Semua hewan:");
                    for (int i = 0; i < hewan.size(); i++) {
                        System.out.println(i + ". " + hewan.get(i));
                    }
                    break;

                //MENGHITUNG JUMLAH ELEMEN DARI NOMOR INDEX
                case 2:
                    System.out.print("Masukkan nomor hewan yang ingin dihitung: ");
                    int indexHewan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Jumlah elemen: " + hewan.size());
                    System.out.println("Nama hewan: " + hewan.get(indexHewan));
                    System.out.println("Posisi index hewan: " + indexHewan);
                    break;

                //MENAMBAHKAN HEWAN BARU
                case 3:
                    System.out.print("Masukkan nama hewan yang ingin ditambahkan: ");
                    String tambahan = scanner.nextLine();
                    hewan.add(tambahan);
                    System.out.println("Hewan berhasil ditambahkan!");
                    break;

                //MENGHAPUS NAMA HEWAN
                case 4:
                    System.out.print("Masukkan nomor hewan yang ingin dihapus: ");
                    int hapus = scanner.nextInt();
                    scanner.nextLine();
                    hewan.remove(hapus);
                    System.out.println("Hewan berhasil dihapus!");
                    break;

                //MENGUBAH HEWAN BEDASARKAN INDEX
                case 5:
                    System.out.print("Masukkan nomor hewan yang ingin diubah: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama hewan yang baru: ");
                    String namaBaru = scanner.nextLine();
                    hewan.set(index, namaBaru);
                    System.out.println("Hewan berhasil diubah!");
                    break;

                //MENAMPILKAN ISI INDEX PERTAMA DAN TERAKHIR
                case 6:
                    System.out.println("Indeks pertama: " + hewan.indexOf(hewan.get(0)));
                    System.out.println("Indeks terakhir: " + hewan.indexOf(hewan.get(hewan.size()-1)));
                    break;

                //EXIT
                case 7:
                    System.out.println("Terima kasih telah menggunakan program NamaHewan!");
                    System.out.println("Total ArrayList : " + hewan.size());
                    isLanjutkan = false;
                    break;
                default:
                    System.out.println("Menu tidak valid! Silakan pilih menu 1-6.");
                    break;
            }
            System.out.println();
        }
    }
}
