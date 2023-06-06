import java.util.Scanner;

class Sport {
    String nama;
    int harga;

    public Sport(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
    public String toString() {
        return this.nama + " --> " + this.harga + " Ribu ";
    }
}

class TokoSport {
    Node front, rear;
    int size;

    public TokoSport() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Sport sport) {
        Node node = new Node(sport);

        if (rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public Sport dequeue() {
        if (front == null) {
            return null;
        }
        Sport sport = front.sport;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return sport;
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        }else{
            return front;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Toko Sport");
            System.out.println("=============================");
            System.out.println("1. Tambahkan Barang");
            System.out.println("2. Beli Barang");
            System.out.println("3. Lihat Barang Yang Tersedia");
            System.out.println("4. Lihat Barang Terdepan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan Anda (1-5): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Barang: ");
                    scanner.nextLine();
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Harga Barang: ");
                    int harga = scanner.nextInt();
                    Sport komputer = new Sport(nama, harga);
                    enqueue(komputer);
                    System.out.println("Barang Berhasil Ditambahkan!");
                    break;
                case 2:
                    if (isEmpty()) {
                        System.out.println("Tidak Ada Barang Yang Tersedia");
                    } else {
                        Sport barangdibeli = dequeue();
                        System.out.println("Anda Membeli Barang:");
                        System.out.println(barangdibeli);
                    }
                    break;
                case 3:
                    if (isEmpty()) {
                        System.out.println("Tidak Ada Barang Yang Tersedia");
                    } else {
                        System.out.println("Barang Tersedia:");
                        Node current = front;
                        while (current != null) {
                            System.out.println(current.sport);
                            current = current.next;
                        }
                    }
                    break;
                case 4:
                    if(isEmpty()) {
                        System.out.println("Tidak Ada Data Yang Tersedia!");
                    } else {
                        Node frontSport = peek();
                        if (frontSport != null) {
                            System.out.println("Data Terdepan : ");
                            System.out.println("Nama : " + front.sport.nama);
                            System.out.println("Harga : " + front.sport.harga);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Terima Kasih Telah Berkunjung!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
            }
        } while (pilihan != 5);
    }

    class Node {
        Sport sport;
        Node next;

        public Node(Sport sport) {
            this.sport = sport;
            this.next = null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        TokoSport toko = new TokoSport();
        toko.menu();
 }
}