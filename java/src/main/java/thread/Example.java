package thread;

import thread.factory.NamingThreadFactory;

import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 16, 6000, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(50), new NamingThreadFactory("example"), new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i = 0; i < 10; i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " started !");
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    System.out.println(Thread.currentThread().getName()+ "finished!");
                }
            });
        }
        pool.shutdown();
    }
}
