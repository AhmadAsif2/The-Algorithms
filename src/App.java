import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        // String builder 
        StringBuilder sb = new StringBuilder("Ahmad");

        sb.append(" Asif");
        sb.delete(6, sb.length());

        // System.out.println(sb.reverse());

        // Reversing the string using string builder
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - i - 1;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }

        System.out.println(sb);

        int[] arr = { 3, 7, 8, 5, 2, 1, 9 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println("Quick Sort");
        quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));

        int res = power(3);
        System.out.println(res);
    }

    // Recursive function
    static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    static int power(int n) {
        if (n == 0)
            return 1;

        return power(n - 1) * 2;
    }

    // Selection Sort
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // bubbleSort
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }

    // Merged Sort
    static void mergeSort(int[] arr, int start, int end) {

        if (start >= end) 
            return;

        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }   

    // Merge two Arrays
    static void merge(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int idx1 = start;
        int idx2 = mid + 1;

        int x = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= end) {
            merged[x++] = arr[idx2++];
        }

        for (int i=0, j=start; i<merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    } 
    
    // Quick Sort
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        
        // Assigning last element as pivot
        int pivot = arr[high];
        int i = low -1;

        for (int  j=low; j< high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int tmp = arr[i];
        arr[i] = pivot;
        pivot = tmp;

        return i;
    }

}

