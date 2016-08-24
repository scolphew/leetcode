package lsf._009_PalindromeNumber;

/**
 * @author scolphew
 * @create 2016年07月07日
 */
public class Solution {
    public boolean isPalindrome(int x){
        if (x<0 || (x!=0 && x%10==0)) return false;//负数和末尾为0的 返回false
        int var = 0;
        while (x > var){
            var = var * 10 + x%10;
            x = x/10;
        }
        return var==x || x == var/10;
    }


    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.isPalindrome(1));
    }
}
