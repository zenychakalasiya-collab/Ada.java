public class QuickSortRandom {

    // Method to print array
    static void printArray(int arr[]) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // Partition Method
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Display pass
        printArray(arr);

        return i + 1;
    }

    // Quick Sort Method
    static void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        int arr[] = new int[5];

        // Generate random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        System.out.println("Original Array:");
        printArray(arr);

        System.out.println("\nQuick Sort Steps:");
        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}
