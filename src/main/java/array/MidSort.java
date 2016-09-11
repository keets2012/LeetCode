package array;

public class MidSort {
    public void reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i - 1;
                while (j>=0&&array[j]%2==0) {
                    swap(array,j,j+1);
                    j--;
                }

            }
        }
    }
    public void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
