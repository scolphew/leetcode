package lsf._000_test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author scolphew
 * @create 2016年08月08日
 */
public class MyTestCallable implements Callable<String> {

    private int id;

    public MyTestCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "Result is " + id++;
    }

    public static void main(String[] args) {
        MyTestCallable myTestCallable = new MyTestCallable(1);

        //Future<String> future = new
        FutureTask<String> futureTask = new FutureTask<>(myTestCallable);
        new Thread(futureTask).start();

        String str=null;
        try {
            str = futureTask.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
