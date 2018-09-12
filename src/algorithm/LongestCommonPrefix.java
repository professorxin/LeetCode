package algorithm;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        String result=strs[0];
        String temp="";
        for(int i=0;i<strs.length-1;i++){
            int length=strs[i].length()>strs[i+1].length()?strs[i+1].length():strs[i].length();
            for(int j=0;j<length;j++){
                if(strs[i].charAt(j)!=strs[i+1].charAt(j)){
                    break;
                }else{
                    temp+=strs[i].charAt(j);
                }
            }
            strs[i+1]=temp;
            result=temp;
            temp="";
        }
        return result;
    }



    public String longestCommonPrefixOther(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
