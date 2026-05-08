public class LinearSearchRandom {

    // Method to print array
    static void printArray(int arr[]) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // Linear Search Method
    static int linearSearch(int arr[], int key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = new int[10];

        // Generate random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        System.out.println("Array Elements:");
        printArray(arr);

        // Select random key from array
        int key = arr[(int)(Math.random() * arr.length)];

        System.out.println("\nElement to search: " + key);

        int result = linearSearch(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}




import java.util.Arrays;

public class BinarySearchRandom {

    // Method to print array
    static void printArray(int arr[]) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // Binary Search Method
    static int binarySearch(int arr[], int key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            else if (arr[mid] < key) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = new int[10];

        // Generate random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }

        // Sort array before binary search
        Arrays.sort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);

        // Select random key from array
        int key = arr[(int)(Math.random() * arr.length)];

        System.out.println("\nElement to search: " + key);

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
