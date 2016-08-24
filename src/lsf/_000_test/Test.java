package lsf._000_test;

/**
 * @author scolphew
 * @create 2016年08月08日
 */
class Test {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            i++;
            ++i;
            i=i+1;
            sum = i++;
            sum = ++i;
            sum = 1;
        }
        int[] a = {};
        System.out.println(sum);
    }
}
