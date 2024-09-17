public class heapSort {
    // Function to heapify a subtree
    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest])
            largest = left;

        if (right < n && a[right] > a[largest])
            largest = right;

        if (largest != i) {
            // Swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, n, largest);
        }
    }

    // Function to implement heap sort
    static void heapSort(int a[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            // Move current root element to end
            // Swap a[0] with a[i]
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    // Function to print array elements
    static void printArr(int a[], int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }

    public static void main(String args[]) {
        int a[] = { 47, 9, 22, 42, 27, 25, 0 };
        int n = a.length;
        System.out.println("Before sorting array elements are - ");
        printArr(a, n);
        heapSort(a, n);
        System.out.println("\nAfter sorting array elements are - ");
        printArr(a, n);
    }
}