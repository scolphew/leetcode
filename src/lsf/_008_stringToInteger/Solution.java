package lsf._008_stringToInteger;

/**
 * String 转为Int
 */
public class Solution {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.myAtoi("     --4rr"));
        System.out.println(s.myAtoi("        --4rr"));
    }

    public int myAtoi(String str) {
        int flag = 1, i = 0, len = str.length();
        //	StringBuffer sb=new StringBuffer();
//		for (int i = 0; i < str.length(); i++) {
//			char c=str.charAt(i);
//			switch (c) {
//			case '+':
//				break;
//			case '-':
//				flag*=-1;
//				break;
//			default:
//				if( (c>47&&c<58) )
//					sb.append( c );
//			}
//		}

        while (i < len && str.charAt(i) == ' ')
            ++i;
//		str=str.trim();

        //只判断下一位符号
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            flag = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        int sum = 0;
        for (; i < len; ++i) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                //超值了
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && c > '7')) {

//                	System.out.println("sum="+sum);
//                	System.out.println("c="+c);

                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    sum = sum * 10 + (c - '0');
                }
            } else {
                break;
            }
        }
        return flag * sum;
    }

}
