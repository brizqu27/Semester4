import java.util.Arrays;

public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Membangun Heap maksimum
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Mengurutkan array dengan memindahkan akar (elemen terbesar) ke bagian belakang array
        for (int i = n - 1; i > 0; i--) {
            // Menukar elemen akar dengan elemen terakhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Memanggil heapify pada sub-array yang tersisa
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Inisialisasi akar sebagai elemen terbesar
        int left = 2 * i + 1; // Indeks anak kiri
        int right = 2 * i + 2; // Indeks anak kanan

        // Jika elemen anak kiri lebih besar dari akar
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Jika elemen anak kanan lebih besar dari akar
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Jika akar tidak lagi merupakan elemen terbesar
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Rekursif memanggil heapify pada sub-pohon yang terpengaruh
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 68, 85, 10, 30, 36, 65, 53, 92, 36, 19 };

        System.out.println("Array sebelum diurutkan: " + Arrays.toString(arr));

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Array setelah diurutkan: " + Arrays.toString(arr));
    }
}