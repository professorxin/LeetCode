package algorithm;

public class ImplementStrStr {
    public int strStrOther(String s, String t) {
        if (t.isEmpty()) return 0;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                //如果j到了字符串的最后一位，就可以说明包含了
                if (j == t.length() - 1) return i;
        }
        return -1;
    }
}
