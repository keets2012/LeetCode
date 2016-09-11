package array;

public class RotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int r = array.length - 1;
        int l = 0;
        while (l <= r) {
            System.out.println("l:r"+l+" " +r);
            boolean f1 = false;
            boolean f2 = false;
            int mid = (l + r) / 2;
            if (array[l] >= array[mid]) {
                r = mid;
                f1 = true;
            }
            if (array[mid] >= array[r]) {
                l = mid;
                f2 = true;
            }
            if (!(f1 || f2)) {
                return minInorder(array, l, r);
            }
            if ((r - l == 1 || l == r)) {
                return array[l] < array[r] ? array[l] : array[r];
            }
        }

        return array[l] < array[r] ? array[l] : array[r];
    }

    private int minInorder(int[] array, int p1, int p2) {
        int min = array[p1];
        for (int i = p1 + 1; i <= p2; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
