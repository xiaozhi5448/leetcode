package thread;

public class Q2 {
    static Integer res = 0;
    static int calStage(int i, int count, int total){
        int step = total/count;
        int stage = 0;
        for(int pivot = i * step+1; pivot <=(i+1)*step; pivot++){
            stage += pivot;
        }
        return stage;
    }
    public static void main(String[] args) {
        int threadCount = 5;
        int upper = 10000;
        Thread[] threads = new Thread[threadCount];
        for(int i = 0; i < 5; i++){
            final int t = i;
            threads[i] = new Thread(()->{
                int stage = calStage(t, threadCount, upper);
                synchronized (res){
                    res += stage;
                }
            });
        }
        for(int i = 0; i< threadCount; i++){
            threads[i].start();
        }
        try{
            for(int i = 0; i < threadCount; i++){
                threads[i].join();
            }
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " Interrupted!");
        }
        System.out.println(res);
    }
}
