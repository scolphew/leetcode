package lsf.java._345_ReversVowelsofaString;

public class Solution {
    public String reverseVowels(String s) {
        int[] vowels = new int[127];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;
        vowels['A'] = 1;
        vowels['E'] = 1;
        vowels['I'] = 1;
        vowels['O'] = 1;
        vowels['U'] = 1;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && vowels[chars[left]] == 0) {
                left++;
            }
            while (left < right && vowels[chars[right]] == 0) {
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("aeiou"));
    }
}

