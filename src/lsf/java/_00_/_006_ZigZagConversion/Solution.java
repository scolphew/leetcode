package lsf.java._00_._006_ZigZagConversion;

/**
 * z字形输出
 * 例：
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 * 先竖直z字形
 * 再水平输出
 *
 * @author scolphew
 * @create 2016年07月07日
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        StringBuffer sb=new StringBuffer();
        int k = (2 * numRows -2);
        int c = (int)Math.ceil(s.length() / (double)k);
        for(int j = 0; j <= c ; j++){
            if(j * k < s.length())
                sb.append( s.charAt(j*k) );
        }
        for(int i = 1;i < numRows-1; i++){
            for(int j = 0; j <= c ; j++){
                if(j * k + i < s.length())
                    sb.append( s.charAt( i + j*k )  );
                if(j * k + 2 * numRows - 2 - i < s.length())
                    sb.append( s.charAt(j * k + 2 * numRows -2 - i )  );
            }
        }
        for(int j = 0; j <= c ; j++){
            if(j * k + numRows-1 < s.length())
                sb.append( s.charAt(j*k + numRows-1 ) );
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        String a=s.convert("ABCDEFG",1);
        System.out.println(a);
    }
}
