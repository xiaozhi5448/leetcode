package base;

import junit.framework.TestCase;

public class TripleStackTest extends TestCase {
    TripleStack tripleStack;
    public void testPush() {
        tripleStack = new TripleStack(2);
        tripleStack.push(0, 1);
        tripleStack.push(0, 2);
        tripleStack.push(0, 3);
        System.out.println(tripleStack.pop(0));
        System.out.println(tripleStack.pop(0));
        System.out.println(tripleStack.pop(0));
        System.out.println(tripleStack.peek(0));
    }
}