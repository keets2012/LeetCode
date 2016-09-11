package tree;

public class PostOrder {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return ver(sequence, 0, sequence.length - 1);
    }

    public boolean ver(int[] s, int start, int root) {
        if (start >= root)
            return true;
        int i = root;
        while (i > start && s[i - 1] > s[root]) {
            i--;
        }
        for (int j = start; j < i - 1; j++) {
            if (s[j] > s[root])
                return false;
        }

        return ver(s, start, i - 1) && ver(s, i, root - 1);
    }
}
