package gcd;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardGroup_914Test {
    CardGroup_914 obj = new CardGroup_914();
    @Test
    public void hasGroupsSizeX() {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        boolean res = obj.hasGroupsSizeX(nums);
        System.out.println(res);
    }
}