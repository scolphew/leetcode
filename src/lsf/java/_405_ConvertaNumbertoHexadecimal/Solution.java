package lsf.java._405_ConvertaNumbertoHexadecimal;

public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        char[] hexNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0)
            return "0";
        while (num != 0) {
            sb.insert(0, hexNum[num & 0xf]);
            num >>>= 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println( -10 & 15 );
        System.out.println( 10 & 15 );
    }
}
