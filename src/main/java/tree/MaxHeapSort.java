package tree;

public class MaxHeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 3, 1, 7,0};
        swap(arr,1,2);
        //System.out.println("      "+arr[1]);
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
        }

    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(int arr[]) {

        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[0]);
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void buildMaxHeap(int arr[]) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int arr[], int p, int size) {
        int max = p;
        int left = p * 2 + 1;
        int right = p * 2 + 2;
        if (left < size && arr[max] < arr[left]) {
            max = left;
        }
        if (right < size && arr[max] < arr[right]) {
            max = right;
        }

        if (max != p) {
            swap(arr, max, p);
            heapify(arr, max, size);
        }
    }
}
