import java.util.Scanner;

public class Segitiga<T extends Number> {
    private T alas;
    private T tinggi;

    public static void main(String[] args) {
        Segitiga<Integer> luasTipeInt = new Segitiga<>();
        Segitiga<Double> luasTipeDouble = new Segitiga<>();

        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        while (pilihan != 3) {
            System.out.println("Menu:");
            System.out.println("1. Hasil Dengan Tipe Integer");
            System.out.println("2. Hasil Dengan Tipe Double");
            System.out.println("3. Keluar");
            System.out.print("Pilihan anda: ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    luasTipeInt.input();
                    int hasilLuasInt = luasTipeInt.getResultAsInt();
                    System.out.println("Luas Segitiga Dengan Tipe Integer: " + hasilLuasInt);
                    break;
                case 2:
                    luasTipeDouble.input();
                    double hasilLuasDouble = luasTipeDouble.getResultAsDouble();
                    System.out.println("Luas Segitiga Dengan Tipe Double: " + hasilLuasDouble);
                    break;
                case 3:
                    System.out.println("Terima Kasih!!!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    break;
            }
            System.out.println();
        }
    }

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nilai Alas : ");
        this.alas = (T) Integer.valueOf(input.nextInt());
        System.out.print("Masukkan Nilai Tinggi : ");
        this.tinggi = (T) Integer.valueOf(input.nextInt());
    }

    public int getResultAsInt() {
        return (this.alas.intValue() * this.tinggi.intValue()) / 2;
    }

    public double getResultAsDouble() {
        return (this.alas.intValue() * this.tinggi.intValue()) / 2.0;
    }
}
