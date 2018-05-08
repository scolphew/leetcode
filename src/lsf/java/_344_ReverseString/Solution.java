package lsf.java._344_ReverseString;

public class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i++] = word[j];
            word[j--] = temp;
        }
        return new String(word);
    }


    public String foo1(String s) {
        StringBuilder sb = new StringBuilder();
        return sb.append(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("12345"));
    }
}
