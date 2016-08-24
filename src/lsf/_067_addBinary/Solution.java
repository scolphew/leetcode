package lsf._067_addBinary;

import java.util.Random;

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
//		
//		String s1=s.锟斤拷锟斤拷锟�);
//		String s2=s.锟斤拷锟斤拷锟�);
//		System.out.println("a="+s1);
//		System.out.println("b="+s2);
//		int n=new Random().nextInt(9999999);
//		System.out.println("锟斤拷锟斤拷"+n+"锟介：");
//		
//		
//		Long time1= new Date().getTime();
//		for (int i = 0; i < n; i++) {
//			//System.out.println(s.addBinary(s1, s2));
//			s.addBinary(s1, s2);
//		}
//		Long time2= new Date().getTime();
//		System.out.println("+=锟斤拷锟斤拷时锟斤拷");
//		System.out.println(time2-time1);
//		Long time3= new Date().getTime();
//		for (int i = 0; i < n; i++) {
//			//System.out.println(s.addBinary(s1, s2));
//			s.addBinary2(s1, s2);
//		}
//		Long time4= new Date().getTime();
//		System.out.println("StringBuffer锟斤拷锟斤拷时锟斤拷");
//		System.out.println(time4-time3);
    }

    /*
    Given two binary strings, return their sum (also a binary string).
    锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷锟斤拷锟斤拷锟角碉拷锟杰和ｏ拷也锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
    For example,
    a = "11"
    b = "1"
    Return "100".
    */
    public String addBinary(String a, String b) {
        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷0  直锟斤拷锟斤拷锟�
        if (a.equals("0") && b.equals("0"))
            return "0";
        int a_len = a.length(), b_len = b.length();
        int len = a_len > b_len ? (a_len + 1) : (b_len + 1);//锟斤拷知之锟襟长讹拷锟筋长为 a锟斤拷b锟较筹拷锟侥筹拷锟斤拷+1
        int flag = 0;//锟斤拷位锟斤拷锟�
        int x1 = a_len - 1, x2 = b_len - 1;//a/b锟斤拷涌锟斤拷锟街革拷锟�
        int c[] = new int[len];//锟斤拷哟锟斤拷锟斤拷锟斤拷锟斤拷
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
        /**
         * 去锟斤拷锟斤拷锟斤拷锟斤拷前锟斤拷募锟斤拷锟�
         *
         */
        while (flag < c.length && c[flag] == 0) {
            //System.out.println(c[flag]+" "+flag);
            flag++;
        }
        /**
         * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷str
         */
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
        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷0  直锟斤拷锟斤拷锟�
        if (a.equals("0") && b.equals("0"))
            return "0";
        int a_len = a.length(), b_len = b.length();
        int len = a_len > b_len ? (a_len + 1) : (b_len + 1);//锟斤拷知之锟襟长讹拷锟筋长为 a锟斤拷b锟较筹拷锟侥筹拷锟斤拷+1
        int flag = 0;//锟斤拷位锟斤拷锟�
        int x1 = a_len - 1, x2 = b_len - 1;//a/b锟斤拷涌锟斤拷锟街革拷锟�
        int c[] = new int[len];//锟斤拷哟锟斤拷锟斤拷锟斤拷锟斤拷
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
        /**
         * 去锟斤拷锟斤拷锟斤拷锟斤拷前锟斤拷募锟斤拷锟�
         *
         */
        while (flag < c.length && c[flag] == 0) {
            //System.out.println(c[flag]+" "+flag);
            flag++;
        }
        /**
         * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷str
         */
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
