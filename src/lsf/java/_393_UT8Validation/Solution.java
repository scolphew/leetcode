package lsf.java._393_UT8Validation;

public class Solution {
    public boolean validUtf8(int[] data) {
        int flag = 0;
        for (int i = 0; i < data.length; i++) {
            if (flag == 0) {
                if ((data[i] & 0b10000000) == 0)  //以0开头
                    continue;
                else if ((data[i] & 0b11111000) == 0b11110000)    // 11110开头
                    flag = 3;
                else if ((data[i] & 0b11110000) == 0b11100000) //1110 开头
                    flag = 2;
                else if ((data[i] & 0b11100000) == 0b11000000)    // 110开头
                    flag = 1;
                else
                    return false;
            } else {
                if ((data[i] & 0b11000000) == 0b10000000) // 10 开头
                    flag--;
                else
                    return false;
            }
        }
        return flag == 0;
    }


    public boolean validUtf8____2(int[] data) {
        int count = 0;
        for (int i : data) {
            if (i >= 248) return false;
            else if (i >= 192) {
                if (count != 0) return false;
                if (i >= 240) count = 3;
                else if (i >= 224) count = 2;
                else count = 1;
            } else if (i >= 128) {
                count--;
                if (count < 0) return false;
            } else if (count > 0) return false;
        }
        return count == 0;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().validUtf8(new int[]{
                115, 100, 102, 231, 154, 132, 13, 10
        }));
    }
}
