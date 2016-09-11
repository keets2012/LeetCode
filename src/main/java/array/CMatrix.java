package array;


import java.util.ArrayList;

public class CMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int w = matrix[0].length;
        int h = matrix.length;
        if (h == 0) {
            return list;
        }
        if (w == 0) {
            return list;
        }
        int circle = (Math.min(w, h) - 1) / 2 + 1;
        System.out.println("circle: " + circle);
        for (int i = 0; i < circle; i++) {
            for (int j = i; j < w - i; j++) {
                list.add(matrix[i][j]);
            }
            System.out.println(list.size());

            for (int j = i + 1; j < h - i; j++) {
                list.add(matrix[j][h - i - 1]);
            }
            System.out.println(list.size());

            for (int j = w - i - 2; j >= i && (h - i - 1 != i); j--) {
                list.add(matrix[h - i - 1][j]);
            }
            System.out.println(list.size());

            for (int q = h - i - 2; q > i && (w - i - 1 != i); q--) {
                list.add(matrix[q][w - i - 1]);
            }
            System.out.println(list.size());

        }
        return list;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2}, {4, 3}};
        System.out.println(printMatrix(a));
    }
}
