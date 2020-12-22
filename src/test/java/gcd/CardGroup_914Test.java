package gcd;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardGroup_914Test {
    CardGroup_914 obj = new CardGroup_914();
    @Test
    public void hasGroupsSizeX() {
        int[] nums = new int[]{1,1,1,2,2,2,3,3};
        obj.hasGroupsSizeX(nums);
    }
}