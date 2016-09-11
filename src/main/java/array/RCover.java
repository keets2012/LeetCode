package array;


public class RCover {

    public static int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target * 2 == 2) {
            return 1;
        } else if (target * 2 == 4) {
            return 2;
        } else {
            return RectCover((target - 1)) + RectCover(target - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(RectCover(113));
    }
}
