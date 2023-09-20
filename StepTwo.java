import java.util.*;

public class StepTwo {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] randomArray = new int[n];
        int[] sortedArray = new int[n];

        // Preencher o vetor aleatório
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(10000); // Valor máximo arbitrário
        }

        // Preencher o vetor ordenado
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i;
        }

        long totalTimeRandom = 0;
        long totalTimeSorted = 0;
        int numTests = 10;

        for (int i = 0; i < numTests; i++) {
            // Clone os vetores para manter os dados inalterados
            int[] randomArrayCopy = randomArray.clone();
            int[] sortedArrayCopy = sortedArray.clone();

            // Medir o tempo para o vetor aleatório
            long startTime = System.nanoTime();
            quickSort(randomArrayCopy, 0, n - 1);
            long endTime = System.nanoTime();
            totalTimeRandom += endTime - startTime;

            // Medir o tempo para o vetor ordenado
            startTime = System.nanoTime();
            quickSort(sortedArrayCopy, 0, n - 1);
            endTime = System.nanoTime();
            totalTimeSorted += endTime - startTime;
        }

        // Calcular a média dos tempos
        long averageTimeRandom = totalTimeRandom / numTests;
        long averageTimeSorted = totalTimeSorted / numTests;

        System.out.println("Tempo médio para vetor aleatório: " + averageTimeRandom + " nanossegundos");
        System.out.println("Tempo médio para vetor ordenado: " + averageTimeSorted + " nanossegundos");
    }
}

