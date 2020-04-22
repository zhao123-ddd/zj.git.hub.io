package 复习.线程;

import java.util.concurrent.*;

public class 线程 implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        线程 v=new 线程();
        FutureTask futureTask=new FutureTask(v);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }


    @Override
    public Object call() throws Exception {
        return 1;
    }
}
