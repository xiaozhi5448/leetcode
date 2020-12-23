package recursion;

import junit.framework.TestCase;

public class MyPow_16Test extends TestCase {

    public void testMyPow() {
        MyPow_16 obj  = new MyPow_16();
        double res = obj.myPow(2.0, -2);
        System.out.println(res);
    }
}