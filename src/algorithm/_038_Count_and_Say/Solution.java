package algorithm._038_Count_and_Say;

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char say = s.charAt(0);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != say) {
                    sb.append(count).append(say);
                    say = s.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(say);
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        String ss = new Solution().countAndSay(6);
        System.out.println(ss);
    }
}
