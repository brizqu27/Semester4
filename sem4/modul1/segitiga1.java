import java.util.Scanner;

public class segitiga1<T> {
    private T alas;
    private T tinggi;


    public void setAlas(T alas) {
        this.alas = alas;
    }

    public void setTinggi(T tinggi) {
        this.tinggi = tinggi;
    }

    public T getAlas() {
        return alas;
    }

    public T getTinggi() {
        return tinggi;
    }

    public <T> int getResultAsInt() {
        return (int) alas * (int) tinggi / 2;
    }

    public <T> double getResultAsDouble() {
        return (double) alas * (double) tinggi / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        segitiga1<Integer> hasilInt = new segitiga1<Integer>();
        segitiga1<Double> hasilDouble = new segitiga1<Double>();

        int alas, tinggi;
        double alas1, tinggi1;
        int pilih;
        System.out.println("1. Integer / 2. Double ");
        System.out.println("Masukkan pilih: ");
        pilih = input.nextInt();
        switch (pilih) {
            case 1:
                System.out.println("Masukkan alas: ");
                hasilInt.setAlas(input.nextInt());
                System.out.println("Masukkan tinggi: ");
                hasilInt.setTinggi(input.nextInt());
                System.out.println(hasilInt.getResultAsInt());
                break;
            case 2:
                System.out.println("Masukkan alas: ");
                hasilDouble.setAlas(input.nextDouble());
                System.out.println("Masukkan tinggi: ");
                hasilDouble.setTinggi(input.nextDouble());
                System.out.println(hasilDouble.getResultAsDouble());
                break;
            default:
                break;

        }
    }
}
