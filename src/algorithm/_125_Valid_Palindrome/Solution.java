package algorithm._125_Valid_Palindrome;


public class Solution {
/*
    //只考虑了英文字符串的回文，没有考虑符号的回文
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0) return true;
        for(int i=0,end=s.length()-1;i<end;i++,end--){
            while(!Character.isLetter(s.charAt(i))&&i<s.length()-1){
                System.out.println(s.charAt(i)+"======");
                i++;
            }
            while(!Character.isLetter(s.charAt(end))&&end>0){
                System.out.println(s.charAt(end)+"-----");
                end--;
            }
            if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(end))){
                if(i==end||i==end-1)
                    return true;
            }else{
                return false;
            }
        }
        return false;
    }*/

    //好像答案也没有考虑符号不同的问题，符号不同它仍然返回true

    public boolean isPalindromeOther1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        //定义头尾两个指针
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    public boolean isPalindromeOther2(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
                return false;
        }
        return true;
    }

}
