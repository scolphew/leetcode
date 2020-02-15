package lsf.java._04_._423_ReconstructOriginalDigitsfromEnglish;

/**
 * 0-9的英文小写，字母任意打乱之后，求原本的数字是什么，排序输出
 *
 * @author scolphew
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = s.originalDigits("zeroonetwothreefourfivesixseveneightnineten");
        System.out.println(ss);
    }

    public String originalDigits(String s) {
        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'z':
                    nums[0] += 1;
                    break;
                case 'x':
                    nums[6] += 1;
                    break;
                case 'g':
                    nums[8] += 1;
                    break;
                case 'w':
                    nums[2] += 1;
                    break;
                case 'h':
                    nums[3] += 1;
                    break; // 3,8
                case 's':
                    nums[7] += 1;
                    break; //6,7
                case 'u':
                    nums[4] += 1;
                    break;
                case 'f':
                    nums[5] += 1;
                    break;//4,5
                case 'i':
                    nums[9] += 1;
                    break;//9,5,6,8
                case 'o':
                    nums[1] += 1;
                    break;//1,0,2,4
            }
        }
        nums[7] -= nums[6];
        nums[3] -= nums[8];
        nums[5] -= nums[4];
        nums[9] -= nums[5] + nums[6] + nums[8];
        nums[1] -= nums[0] + nums[2] + nums[4];


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();

    }
}
