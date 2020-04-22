package 复习.线程;
/*
固定个数线程池
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool= Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println(Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

    }

    }
}
