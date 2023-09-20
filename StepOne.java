import java.util.Random;

public class StepOne {

    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void mergeSort(long[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        long[] left = new long[mid];
        long[] right = new long[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] sizes = {62500, 125000, 250000, 375000};
        int numTests = 50;

        System.out.println("Tamanho do Vetor | Média de Tempo (Quicksort) | Média de Tempo (Mergesort)");

        for (int size : sizes) {
            long totalQuickSortTime = 0;
            long totalMergeSortTime = 0;

            for (int i = 0; i < numTests; i++) {
                // Criar um vetor aleatório de longs
                long[] randomArray = new long[size];
                Random random = new Random();
                for (int j = 0; j < size; j++) {
                    randomArray[j] = random.nextLong();
                }

                // Clonar o vetor para usar nos dois algoritmos
                long[] quickSortArray = randomArray.clone();
                long[] mergeSortArray = randomArray.clone();

                // Medir o tempo para o Quicksort
                long quickSortStartTime = System.nanoTime();
                quickSort(quickSortArray, 0, size - 1);
                long quickSortEndTime = System.nanoTime();
                long quickSortElapsedTime = quickSortEndTime - quickSortStartTime;
                totalQuickSortTime += quickSortElapsedTime;

                // Medir o tempo para o Mergesort
                long mergeSortStartTime = System.nanoTime();
                mergeSort(mergeSortArray);
                long mergeSortEndTime = System.nanoTime();
                long mergeSortElapsedTime = mergeSortEndTime - mergeSortStartTime;
                totalMergeSortTime += mergeSortElapsedTime;
            }

            // Calcular a média dos tempos
            long averageQuickSortTime = totalQuickSortTime / numTests;
            long averageMergeSortTime = totalMergeSortTime / numTests;

            // Imprimir os resultados
            System.out.println(size + " | " + averageQuickSortTime + " ns | " + averageMergeSortTime + " ns");
        }
    }
}
