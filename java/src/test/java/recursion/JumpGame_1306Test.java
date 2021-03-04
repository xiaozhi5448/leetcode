package recursion;

import junit.framework.TestCase;

public class JumpGame_1306Test extends TestCase {

    public void testCanReach() {
        int[] arr = new int[]{4,2,3,0,3,1,2};
        JumpGame_1306 obj = new JumpGame_1306();
        boolean res = obj.canReach(arr, 5);
        System.out.println(res);
    }
}