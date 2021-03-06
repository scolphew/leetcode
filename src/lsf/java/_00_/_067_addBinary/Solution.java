package lsf.java._00_._067_addBinary;

import java.util.Random;

@SuppressWarnings("WeakerAccess")
public class Solution {

    public String suijishu() {
        Random random = new Random();
        int n = random.nextInt(50);
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = random.nextInt(2);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("11", "11"));
        System.out.println(s.addBinary("14", "14"));
    }

    /*
    Given two binary strings, return their sum (also a binary string).
    阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熻鍑ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓瑙掔鎷烽敓鏉板拰锝忔嫹涔熼敓鏂ゆ嫹涓€阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熻鍑ゆ嫹阌熸枻鎷?
    For example,
    a = "11"
    b = "1"
    Return "100".
    */
    public String addBinary(String a, String b) {
        //阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷?  鐩撮敓鏂ゆ嫹阌熸枻鎷烽敓锟?
        if (a.equals("0") && b.equals("0"))
            return "0";
        int a_len = a.length(), b_len = b.length();
        int len = a_len > b_len ? (a_len + 1) : (b_len + 1);//阌熸枻鎷风煡涔嬮敓瑗熼昵璁规嫹阌熺璎闀夸负 a阌熸枻鎷穊阌熻缉绛规嫹阌熶茎绛规嫹阌熸枻鎷?1
        int flag = 0;//阌熸枻鎷蜂綅阌熸枻鎷烽敓锟?
        int x1 = a_len - 1, x2 = b_len - 1;//a/b阌熸枻鎷锋秾阌熸枻鎷烽敓琛楅潻鎷烽敓锟?
        int c[] = new int[len];//阌熸枻鎷峰摕阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹
        for (int i = len - 1; i >= 0; --x1, --x2, --i) {
            int sum = flag;
            if (x1 >= 0) {
                sum += (a.charAt(x1) - 48);
            }
            if (x2 >= 0)
                sum += (b.charAt(x2) - 48);
            switch (sum) {
                case 0:
                    c[i] = 0;
                    flag = 0;
                    break;
                case 1:
                    c[i] = 1;
                    flag = 0;
                    break;
                case 2:
                    c[i] = 0;
                    flag = 1;
                    break;
                case 3:
                    c[i] = 1;
                    flag = 1;
                    break;
                default:
                    break;
            }
        }
        String str = "";
        flag = 0;
        //System.out.println(c.length);
        while (flag < c.length && c[flag] == 0) {
            //System.out.println(c[flag]+" "+flag);
            flag++;
        }
        for (int i = flag; i < c.length; i++) {
            str += c[i];
        }
        return str;
//		StringBuffer sb=new StringBuffer();
//		for (int i = flag; i < c.length; i++) {
//			sb.append(c[i]);
//		}
//      return sb.toString();

    }

    public String addBinary2(String a, String b) {
        //阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷?  鐩撮敓鏂ゆ嫹阌熸枻鎷烽敓锟?
        if (a.equals("0") && b.equals("0"))
            return "0";
        int a_len = a.length(), b_len = b.length();
        int len = a_len > b_len ? (a_len + 1) : (b_len + 1);//阌熸枻鎷风煡涔嬮敓瑗熼昵璁规嫹阌熺璎闀夸负 a阌熸枻鎷穊阌熻缉绛规嫹阌熶茎绛规嫹阌熸枻鎷?1
        int flag = 0;//阌熸枻鎷蜂綅阌熸枻鎷烽敓锟?
        int x1 = a_len - 1, x2 = b_len - 1;//a/b阌熸枻鎷锋秾阌熸枻鎷烽敓琛楅潻鎷烽敓锟?
        int c[] = new int[len];//阌熸枻鎷峰摕阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹
        for (int i = len - 1; i >= 0; --x1, --x2, --i) {
            int sum = flag;
            if (x1 >= 0) sum += (a.charAt(x1) - 48);
            if (x2 >= 0) sum += (b.charAt(x2) - 48);
            switch (sum) {
                case 0:
                    c[i] = 0;
                    flag = 0;
                    break;
                case 1:
                    c[i] = 1;
                    flag = 0;
                    break;
                case 2:
                    c[i] = 0;
                    flag = 1;
                    break;
                case 3:
                    c[i] = 1;
                    flag = 1;
                    break;
                default:
                    break;
            }
        }
        String str = "";
        flag = 0;
        //System.out.println(c.length);
        while (flag < c.length && c[flag] == 0) {
            //System.out.println(c[flag]+" "+flag);
            flag++;
        }
        //		for (int i = flag; i < c.length; i++) {
//			str+=c[i];
//		}
//		return str;
        StringBuffer sb = new StringBuffer();
        for (int i = flag; i < c.length; i++) {
            sb.append(c[i]);
        }
        return sb.toString();

    }

}
