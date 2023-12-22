package Home;

public class sorting {
    public static void quickSort(String[][] arr, int low, int high, int columnIndex) { // O(1) -> konstan (bergantung pada if (low < high)
        if (low < high) {
            int partitionIndex = partition(arr, low, high, columnIndex); // Tpartition(n)

            // Rekursif untuk mengurutkan bagian kiri dan kanan dari pivot
            quickSort(arr, low, partitionIndex - 1, columnIndex); // Tquicksort(n/2)
            quickSort(arr, partitionIndex + 1, high, columnIndex); // Tquicksort (n/2)
        }
    }

    private static int partition(String[][] arr, int low, int high, int columnIndex) {
        String pivot = arr[high][columnIndex]; // 1
        int i = low - 1; // 1 + 1

        for (int j = low; j < high; j++) { // n + n
            // Membandingkan string, menggunakan compareTo
            if (arr[j][columnIndex].compareTo(pivot) <= 0) {
                i++; // n

                // Tukar arr[i] dan arr[j]
                String[] temp = arr[i]; // n
                arr[i] = arr[j]; // n
                arr[j] = temp; // n
            }
        }

        // Tukar arr[i + 1] dan arr[high] (pivot)
        String[] temp = arr[i + 1]; // 1 + 1
        arr[i + 1] = arr[high]; // 1 + 1
        arr[high] = temp; // 1

        return i + 1; // 1
    }
}
