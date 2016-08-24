package lsf._005_LongestPalindromicSubstring;

/**
 * @author scolphew
 * @create 2016年07月07日
 */
@SuppressWarnings("WeakerAccess")
public class Solution {
    @SuppressWarnings("SameParameterValue")
    public String longestPalindrome(String s) {
        if(s.length()<1)
            return s;
        int start = 0;
        int max_length = 1;
        for (int i = 0; i < s.length()-1;) {
            if(s.length() - i < max_length /2) break;

            int j=i,k=i;
            while (k<s.length()-1 && s.charAt(k+1)==s.charAt(k))
                k++;
            i=k+1;
            while (k < s.length()-1 && j >0 && s.charAt(k+1)==s.charAt(j-1)){
                j--;
                k++;
            }
            int new_len = k-j+1;
            if(new_len>max_length){
                System.out.println( j+" "+k );
                start = j;
                max_length = new_len;
            }
        }
        return s.substring(start,max_length+start);
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println("---------------");
        String a= s.longestPalindrome("22");
        System.out.println(a);
        Solution s2 =new Solution();
        String a2= s2.longestPalindrome("44");
        System.out.println(a2);
    }
}
