public class heapSortt {
    // Function to heapify a subtree. Here 'i' is the index of the root node in
    // array a[], and 'n' is the size of the heap.
    public static void heapify(int[] a, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }

        // If right child is larger than root
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }

        // If root is not largest
        if (largest != i) {
            // Swap a[i] with a[largest]
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(a, n, largest);
        }
    }

    // Function to implement the heap sort
    public static void heapSort(int[] a) {
        int n = a.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // One by one extract an element from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root element to the end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Heapify the reduced heap
            heapify(a, i, 0);
        }
    }

    // Function to print the array elements
    public static void printArr(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 47, 9, 22, 42, 27, 25, 0 };
        System.out.println("Before sorting array elements are - ");
        printArr(a);
        heapSort(a);
        System.out.println("After sorting array elements are - ");
        printArr(a);
    }
}
