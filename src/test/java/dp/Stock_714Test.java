package dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class Stock_714Test {

    @Test
    public void maxProfit() {
        int[] prices = {1,3,2,8,4,9};
        Stock_714 obj = new Stock_714();
        int res = obj.maxProfit(prices, 2);
        System.out.println(res);
    }
}