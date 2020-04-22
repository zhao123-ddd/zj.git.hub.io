package 复习.线程;
/*
单线程化的线程池，只会用唯一的工作线程来执行任务，保证所有任务按序完成。
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor= Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            final int index=i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正在执行 "+index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
