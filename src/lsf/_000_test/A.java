package lsf._000_test;

/**
 * @author scolphew
 * @create 2016年08月08日
 */
public class A{
    public int f() {
        try{
            return 123;
        }catch (Exception e){
            return 123;
        }finally {
            System.out.println("12233333");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        int x=a.f();
        System.out.println(x);
        long l =1;
        String s = null;
        switch (s){

        }
    }
}

abstract class B extends A{
    public static int i;
    public int f(){
        return 123;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}



