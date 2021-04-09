package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Q3 {
    static int res = 0;
    static int addCount = 0;
    public static void main(String[] args) {
        Map<Integer, Integer> queue = new HashMap<>();
        ReentrantLock lock = new ReentrantLock();
        Condition emptyCond = lock.newCondition();
        final int upper = 100;
        boolean[] added = new boolean[100];
        Thread producer = new Thread(()->{
            for(int i = 1; i <= upper; i++){
                lock.lock();
                queue.put(i, i);
                if(queue.size() == 1){
                    emptyCond.signal();
                }
                lock.unlock();
            }
        });

        Thread consumer = new Thread(()->{
            while(true){
                try{
                    if(addCount == upper)
                        break;
                    lock.lock();
                    if(queue.isEmpty())
                        emptyCond.await();
                    for(int i = 1; i <= upper;i++){
                        if(!added[i-1] && queue.containsKey(i)){
                            added[i-1] = true;
                            res += queue.get(i);
                            queue.remove(i);
                            addCount++;
                        }
                    }
                    lock.unlock();
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName() + " Interrupted!");
                }

            }
        });
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        }catch (InterruptedException e){
           e.printStackTrace();
        }
        System.out.println(res);
    }
}
