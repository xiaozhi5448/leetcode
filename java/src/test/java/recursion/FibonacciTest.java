package recursion;

import junit.framework.TestCase;

public class FibonacciTest extends TestCase {

    public void testFib() {
        Fibonacci obj = new Fibonacci();
        System.out.println(obj.fib(95));
    }
}