public class SelectionSortRandom {

    // Method to print array
    static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Selection Sort Method
    static void selectionSort(int arr[]) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // Display pass
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);
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

        System.out.println("\nSelection Sort Passes:");
        selectionSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }
}
