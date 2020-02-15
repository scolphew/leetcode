package lsf.java._05_._592_FractionAdditionandSubtraction;

public class Solution {
    public String fractionAddition(String expression) {
        char[] chars = expression.toCharArray();
        int N = 2520;
        int num = 0;
        int flag = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                flag = 1;
            } else if (chars[i] == '-') {
                flag = -1;
            } else {
                int a, b;
                //第一个参数
                if (chars[i] != '1') {
                    //2-9
                    a = chars[i] - '0';
                } else {
                    if (i + 1 < chars.length && chars[i + 1] == '0') {
                        a = 10;//10
                        i++;
                    } else {
                        a = 1;//最后的1
                    }
                }
                i++;
                if (i >= chars.length || chars[i] != '/') {
                    b = 1;//末尾 或者 没有除数
                } else {
                    i++;
                    if (chars[i] != '1') {
                        b = chars[i] - '0'; //2-9除数
                    } else {
                        if (i + 1 < chars.length && chars[i + 1] == '0') {
                            b = 10;
                            i++;
                        } else {
                            b = 1;
                        }
                    }
                }
                num += flag * (a * N / b);
            }
        }
        if (num == 0) return "0/1";
        String ans;
        if (num < 0)

        {
            ans = "-";
            num = -num;
        } else

        {
            ans = "";
        }
        if (N % num == 0)

        {
            ans += "1/" + N / num;
        } else if (num % N == 0)

        {
            ans += num / N + "/1";
        } else

        {
            for (int i : new int[]{2, 2, 2, 3, 3, 5, 7}) {
                if (num % i == 0) {
                    num /= i;
                    N /= i;
                }
            }
            ans += num + "/" + N;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(s.fractionAddition("-1/2+1/2"));
        System.out.println(s.fractionAddition("1/3-1/2"));
        System.out.println(s.fractionAddition("5/3+1/3"));
        System.out.println(s.fractionAddition("5/7"));
        System.out.println(s.fractionAddition("7/3+5/2-3/10"));
        System.out.println(s.fractionAddition("7/3+5/2"));
        System.out.println(s.fractionAddition("1/1"));
    }


}
