package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Q2 {
    public static void main(String[] args) {
        int res = 0;
        final int threadCount = 5;
        final int upper = 10000;
        Thread[] threads = new Thread[threadCount];
        FutureTask<Integer>[] tasks = new FutureTask[threadCount];
        for(int i = 0; i < 5; i++){
            final int t = i;
            tasks[t] = new FutureTask<Integer>(()->{
                int step = upper/threadCount;
                int stage = 0;
                for(int pivot = t*step+1; pivot <= (t+1)*step; pivot++){
                    stage += pivot;
                }
                return stage;
            });
            threads[i] = new Thread(tasks[t]);
        }
        for(int i = 0; i< threadCount; i++){
            threads[i].start();
        }
        try{
            for(int i = 0; i < threadCount; i++){
                threads[i].join();
                res += tasks[i].get();
            }
        }catch (Exception e1){
            System.out.println(Thread.currentThread().getName() + " Interrupted!");
        }
        System.out.println(res);
    }
}
