package lsf._000_test;

/**
 * @author scolphew
 */
class A{
    int f() {
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
    }
}

abstract class B extends A{
    public static int i;
    public int f(){
        return 123;
    }
}



