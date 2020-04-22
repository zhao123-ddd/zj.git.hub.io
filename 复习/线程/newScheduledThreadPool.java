package 复习.线程;
/*
定长线程池，支持定时或周期性执行任务
 */
import java.util.Random;
import java.util.concurrent.*;

public class newScheduledThreadPool {

    public static void main(String[] args)
    {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);//一池5线程
        ScheduledFuture<Integer> result = null;
        try
        {
            for (int i = 1; i <=15; i++)
            {
                result = service.schedule(() -> {
                    System.out.print(Thread.currentThread().getName());
                    return new Random().nextInt(30);
                }, 2, TimeUnit.SECONDS);
                System.out.println("*******result: "+result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }



}
