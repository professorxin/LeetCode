package algorithm._008_String_to_Integer;

public class Solution {
/*    //没能解出来，主要是卡在正负号这里
    public int myAtoi(String str) {
        if(str==null||str.length()==0) return 0;
        long result=0;
        int a=0,flag=1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')continue;
            if(str.charAt(i)=='+'||str.charAt(i)=='-'){
                flag=str.charAt(i)=='+'?1:-1;
            }
            if(!Character.isDigit(str.charAt(i))){
                return (int)result;
            }else{
                a=str.charAt(i)-'0';
                result=result*10+a;
            }
            if(flag==1&&result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(flag==-1&&result*(-1)<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)result*flag;
    }*/

    //这道题目主要是要把前面的空格东西消除，正负号要能判别出来，然后在进行数字的判别取出

    //类似的解法
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }

    //不断消除元素，很好的思路
    public int myAtoiOther(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
