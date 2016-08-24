package _000_;

/**
 * @author scolphew
 * @create 2016Äê07ÔÂ07ÈÕ
 */
public class test {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = f();

        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str2==str4);
    }

    public static String f(){
        return "Hello";
    }
}
