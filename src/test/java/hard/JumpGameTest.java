package hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void jump() {
        JumpGame jump = new JumpGame();
        int[] nums = {2,3,1,1,4};
        jump.jump(nums);
    }
}