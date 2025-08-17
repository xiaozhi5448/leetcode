package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class CommonSolution {
    /**
     * 给你一个类：
     *
     * public class Foo {
     *   public void first() { print("first"); }
     *   public void second() { print("second"); }
     *   public void third() { print("third"); }
     * }
     * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
     *
     * 线程 A 将会调用 first() 方法
     * 线程 B 将会调用 second() 方法
     * 线程 C 将会调用 third() 方法
     * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
     */
    class Foo {

        CountDownLatch firstFlag;
        CountDownLatch secondFlag;

        public Foo() {
            firstFlag = new CountDownLatch(1);
            secondFlag = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFlag.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            firstFlag.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFlag.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            secondFlag.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
    /**
     * 两个不同的线程将会共用一个 FooBar 实例：
     *
     * 线程 A 将会调用 foo() 方法，而
     * 线程 B 将会调用 bar() 方法
     * 请设计修改程序，以确保 "foobar" 被输出 n 次。
     */
    class FooBar {
        private int n;

        AtomicInteger amt = new AtomicInteger(0);
        ReentrantLock lock;
        Condition emptyCondition;
        Condition fullCondition;

        public FooBar(int n) {
            this.n = n;
            lock = new ReentrantLock();
            emptyCondition = lock.newCondition();
            fullCondition = lock.newCondition();
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try{
                    lock.lock();
                    if(amt.get() != 0){
                        emptyCondition.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    amt.incrementAndGet();
                    fullCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try{
                    lock.lock();
                    if(amt.get()!= 1){
                        fullCondition.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    amt.decrementAndGet();
                    emptyCondition.signal();
                }finally {
                    lock.unlock();
                }

            }
        }
    }


    /**
     * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
     *
     * 例如，调用 printNumber(7) 将会输出 7 到控制台。
     * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
     *
     * 线程 A：调用 zero() ，只输出 0
     * 线程 B：调用 even() ，只输出偶数
     * 线程 C：调用 odd() ，只输出奇数
     * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
     *
     * 实现 ZeroEvenOdd 类：
     *
     * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
     * void zero(printNumber) 调用 printNumber 以输出一个 0 。
     * void even(printNumber) 调用printNumber 以输出偶数。
     * void odd(printNumber) 调用 printNumber 以输出奇数。
     */
    static class ZeroEvenOdd {
        private int n;
        AtomicBoolean zeroFlag = new AtomicBoolean(true);
        AtomicInteger curr = new AtomicInteger(1);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while(curr.get() <= n){
                    if(zeroFlag.get()){
                        printNumber.accept(0);
                        zeroFlag.set(false);
                        this.notifyAll();
                    }else{
                        this.wait();
                    }
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while(curr.get() <= n){
                    if(!zeroFlag.get() && curr.get() % 2==0){
                        printNumber.accept(curr.getAndIncrement());
                        zeroFlag.set(true);
                        this.notifyAll();
                    }else{
                        this.wait();
                    }
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while(curr.get() <= n){
                    if(!zeroFlag.get() && curr.get() % 2 == 1){
                        printNumber.accept(curr.getAndIncrement());
                        zeroFlag.set(true);
                        this.notifyAll();
                    }else{
                        this.wait();
                    }
                }
            }
        }
    }

    /**
     * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
     *
     * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
     *
     * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
     *
     * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
     *
     * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
     *
     * 换句话说:
     *
     * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
     * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
     * 书写满足这些限制条件的氢、氧线程同步代码。
     */

    class H2O {

        AtomicInteger hCount = new AtomicInteger(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized (this){
                while(hCount.get() == 2){
                    this.wait();
                }
                releaseHydrogen.run();
                hCount.incrementAndGet();
                this.notifyAll();
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            synchronized (this){
                while(hCount.get() != 0){
                    this.wait();
                }
                releaseOxygen.run();
                hCount.set(0);
                this.notifyAll();
            }

        }
    }

    class FizzBuzz {
        private int n;

        volatile  int curr = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            synchronized (this){
                while(curr <= n && !(curr % 3 == 0 && curr % 5 != 0)){
                    this.wait();
                }
                printFizz.run();
                curr++;
                this.notifyAll();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            synchronized (this){
                while(curr <= n && !(curr % 5 == 0 && curr % 3 != 0)){
                    this.wait();
                }
                printBuzz.run();
                curr++;
                this.notifyAll();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            synchronized (this){
                while(curr <= n && !(curr % 3 == 0 && curr % 5 == 0)){
                    this.wait();
                }
                printFizzBuzz.run();
                curr++;
                this.notifyAll();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            synchronized (this){
                while(curr <= n && curr % 3 == 0 || curr % 5 == 0){
                    this.wait();
                }
                printNumber.accept(curr);
                curr++;
                this.notifyAll();
            }
        }
    }

    // 多线程交叉打印26个字母
    private int index = 0;

    private void showCode(){
        int code = 'a' + index;
        System.out.print((char)code);
    }
    public void firstPrinter(){
        while(index < 26){
            synchronized (this){
                if(index >= 26){
                    break;
                }
                if(index % 3 != 1){
                    this.notifyAll();
                }else{
                    showCode();
                    index++;
                }
            }
        }
    }
    public void secondPrinter(){
        while(index < 26){
            synchronized (this){
                if(index >= 26){
                    break;
                }
                if(index % 3 != 2){
                    this.notifyAll();
                }else{
                    showCode();
                    index++;
                }
            }
        }
    }
    public void thirdPrinter(){
        while (index < 26){
            synchronized (this){
                if(index >= 26){
                    break;
                }
                if(index % 3 != 0){
                    this.notifyAll();
                }else{
                    showCode();
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        CommonSolution commonSolution = new CommonSolution();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, // 核心线程数
                3, // 最大线程数
                60, // 线程空闲超过该值, 超过核心线程数的线程会自动销毁
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(3), // 线程队列, 当核心线程数满了之后请求会进队列
                new ThreadPoolExecutor.CallerRunsPolicy()); // 当线程池线程数量与队列都被打满, 采用何种策略
        threadPoolExecutor.execute(commonSolution::firstPrinter);
        threadPoolExecutor.execute(commonSolution::secondPrinter);
        threadPoolExecutor.execute(commonSolution::thirdPrinter);
        threadPoolExecutor.shutdown();
    }
}
