import java.util.HashMap;
import java.util.Scanner;

public class DataPraktikan {
    private HashMap<String, String> tabelData;
    private static HashMap<String, String> tabelSesiLogin;
    private String loggedInUser;

    public DataPraktikan() {
        tabelData = new HashMap<>();
        tabelSesiLogin = new HashMap<>();
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.startsWith("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        }
        return false;
    }

    public void tampil() {
        for (String nimPraktikan : tabelData.keySet()) {
            String namaAsisten = tabelData.get(nimPraktikan);
            System.out.println("NIM: " + nimPraktikan + " | Nama Asisten: " + namaAsisten);
        }
    }

    public void listNimPraktikan() {
        for (String nimPraktikan : tabelData.keySet()) {
            System.out.println("- " + nimPraktikan);
        }
    }

    public void listNamaAsisten() {
        for (String namaAsisten : tabelData.values()) {
            System.out.println("- " + namaAsisten);
        }
    }

    public void search(String namaAsisten) {
        System.out.println("Daftar NIM Praktikan Dengan Nama Asisten " + namaAsisten + ":");
        for (String nim : tabelData.keySet()) {
            if (tabelData.get(nim).equals(namaAsisten)) {
                System.out.println("- " + nim);
            }
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.remove(nimPraktikan);
            return true;
        }
        return false;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Edit Data Berhasil!");
        } else {
            System.out.println("Edit Data Gagal! Data Tidak Ditemukan, Silahkan Coba Lagi!");
        }
    }

        public static void Register(String email, String password) {
            tabelSesiLogin.put(email, password);
        }

        public boolean login() {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Masukkan Alamat Email: ");
                String email = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();

                if (validateEmail(email) && tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
                        loggedInUser = email;
                        System.out.println("-------------------------------------------");
                        System.out.println("Berhasil Login Sebagai " + email);
                        System.out.println("-------------------------------------------");

                        DataPraktikan dataPraktikan = new DataPraktikan();
                        Scanner ipt = new Scanner(System.in);
                        int menu;
                        do {
                            System.out.println("\n===== Aplikasi Data Praktikan =====");
                            System.out.println("1. Tambah Data Praktikan");
                            System.out.println("2. Tampilkan Data Praktikan");
                            System.out.println("3. Tampilkan List NIM Praktikan");
                            System.out.println("4. Tampilkan List Nama Asisten");
                            System.out.println("5. Tampilkan Data Praktikan Asisten");
                            System.out.println("6. Tampilkan Total Data Praktikan");
                            System.out.println("7. Edit Data Praktikan");
                            System.out.println("8. Hapus Data Praktikan");
                            System.out.println("9. Keluar");
                            System.out.print("Pilih Menu Anda: ");
                            menu = ipt.nextInt();

                            switch (menu) {
                                case 1:
                                    System.out.print("Masukkan NIM Praktikan: ");
                                    String nimPraktikan = scanner.nextLine();
                                    System.out.print("Masukkan Nama Asisten: ");
                                    String namaAsisten = scanner.nextLine();
                                    boolean tambahBerhasil = dataPraktikan.tambahData(nimPraktikan, namaAsisten);
                                    if (tambahBerhasil) {
                                        System.out.println("Data Berhasil Ditambahkan!");
                                    } else {
                                        System.out.println("Gagal Menambahkan Data! Pastikan NIM Dimulai Dengan 'IF' Dan Belum Terdaftar!");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Data Praktikan: ");
                                    dataPraktikan.tampil();
                                    break;
                                case 3:
                                    System.out.println("List NIM Praktikan:");
                                    dataPraktikan.listNimPraktikan();
                                    break;
                                case 4:
                                    System.out.println("List Nama Asisten:");
                                    dataPraktikan.listNamaAsisten();
                                    break;
                                case 5:
                                    System.out.print("Masukkan Nama Asisten: ");
                                    String found = scanner.nextLine();
                                    dataPraktikan.search(found);
                                    break;
                                case 6:
                                    int totalData = dataPraktikan.totalEmail();
                                    System.out.println("Total Data Praktikan: " + totalData);
                                    break;
                                case 7:
                                    System.out.print("Masukkan NIM Praktikan Yang Akan Diubah: ");
                                    String nimEdit = scanner.nextLine();
                                    System.out.print("Masukkan Nama Asisten Yang Baru: ");
                                    String namaEdit = scanner.nextLine();
                                    dataPraktikan.editData(nimEdit, namaEdit);
                                    break;
                                case 8:
                                    System.out.print("Masukkan NIM Praktikan Yang Akan Dihapus: ");
                                    String nimHapus = scanner.nextLine();
                                    boolean hapusBerhasil = dataPraktikan.hapusData(nimHapus);
                                    if (hapusBerhasil) {
                                        System.out.println("Data Berhasil Dihapus!");
                                    } else {
                                        System.out.println("Data Tidak Ditemukan!");
                                    }
                                    break;
                                case 9:
                                    logout();
                                    break;
                                default:
                                    System.out.println("Menu yang Anda Pilih Tidak Valid!");
                                    break;
                            }
                        } while (menu != 9);

                } else {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Gagal Login! Email Atau Password Tidak Valid!");
                    System.out.println("--------------------------------------------------");
                }
            }while(true);
        }

        public void logout () {
                System.out.println("---------------------------------------------------------");
                System.out.println("Berhasil Logout! Sampai Jumpa " + loggedInUser + "!");
                System.out.println("---------------------------------------------------------");
                System.exit(0);
        }

    private boolean validateEmail (String email){
            //Menggunakan ekspresi reguler untuk memvalidasi alamat email
            String emailRegex = "^[A-Za-z0-9+_.-]+@umm\\.ac\\.id$";
            return email.matches(emailRegex);
        }

    public static void main(String[] args) {
        DataPraktikan dataPraktikan = new DataPraktikan();
        DataPraktikan.Register("user1@umm.ac.id", "password1");
        DataPraktikan.Register("user2@umm.ac.id", "password2");
        dataPraktikan.login();

    }
}