package hard;

import GreedyStrategy.JumpGame;
import org.junit.Test;

public class JumpGameTest {

    @Test
    public void jump() {
        JumpGame jump = new JumpGame();
        int[] nums = {1,2,1,1,1};
        System.out.println(jump.jump(nums));
    }
}