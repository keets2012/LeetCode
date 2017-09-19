package str;

/**
 * 替换字符串，.换成_，识别大小写字母和数字
 * Created by keets on 2017/9/19.
 */
public class ReplaceStr {

    public static void main(String[] args) {
        // write your code here
        ReplaceStr main = new ReplaceStr();
        main.test("MY.ABCParse12");
        System.out.println();
    }


    public String test(String str) {
        StringBuilder sb = new StringBuilder("_");
        int i = 0;
        boolean endIsChar = false; //末尾是不是'_'号
        int length = str.length();
        while (i < length) {
            char itr = str.charAt(i);
            if (itr == '.') {
                if (!endIsChar) {
                    sb.append("_");
                    endIsChar = true;
                } else {
                    endIsChar = false;
                }
            } else if (itr >= 'A' && itr <= 'Z') {
                int j = i + 1;
                if (j < length) { //大写字母后有小写字母，前边加_
                    if (isSmallChar(str.charAt(j))) {
                        if (!endIsChar) {
                            sb.append("_");
                        }
                        endIsChar = false;
                    }
                }
                // System.out.println("ad big" + sb.toString());
                sb.append(itr);
                endIsChar = false;
            } else if (itr >= 'a' && itr <= 'z') {
                // System.out.println("add small" + sb.toString());
                sb.append(itr);
                int j = i + 1;
                endIsChar = false;
                if (j < length) { //小写字母之后跟着大小字母，后边加 _
                    if (isBigChar(str.charAt(j))) {
                        sb.append("_");
                        endIsChar = true;
                    }
                }
            } else if (itr >= '0' && itr <= '9') {
                int m = i - 1;
                if (m >= 0) {
                    if (!isNumber(str.charAt(m))) {
                        if (!endIsChar) {
                            sb.append("_");
                            endIsChar = false;
                        } else {
                            endIsChar = true;
                        }
                    }
                }
                sb.append(itr);
                endIsChar = false;

                int n = i + 1;
                if (n < length) {
                    if (!isNumber(str.charAt(n))) {
                        sb.append("_");
                        endIsChar = true;
                    }
                }
            }
            i++;
        }
        if (!endIsChar) {
            sb.append("_");
        }
        return sb.toString();
    }

    boolean isSmallChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    boolean isBigChar(char c) {
        return c >= 'A' && c <= 'Z';
    }

    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}

