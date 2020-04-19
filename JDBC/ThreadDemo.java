import java.util.Scanner;

public class ThreadDemo {
    // 时间复杂度: O(2^n)
    private static long fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    private static class FibThread extends Thread {
        private int n;
        FibThread(int n) {
            this.n = n;
        }
        @Override
        public void run() {
            System.out.println(fib(n));
        }
    }
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            //System.out.println(fib(n));  // 这个是在主线程中直接计算
            // 重新启动一个线程，去计算 fib(n)
            // 主线程负责读取下一个数
            FibThread thread = new FibThread(n);
            thread.start();
        }*/



        MyRunnable mr1 = new MyRunnable();
        MyRunnable mr2 = new MyRunnable();
        // mr1 和 mr2 引用指向各自的 任务对象

        // 最终线程需要有线程对象
        Thread t1 = new Thread(mr1);    // mr1 指向的任务作为 t1 线程的任务
        Thread t2 = new Thread(mr1);    // mr1 指向的任务作为 t2 线程的任务
        Thread t3 = new Thread(mr2);    // mr2 指向的任务作为 t3 线程的任务




    }
     /*
    static class MyThread extends Thread {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // t1 和 t2 这两个引用指向了各自的线程对象
        // 线程最终要执行是 run 方法中的代码
    }
    */

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
        }
    }


}
