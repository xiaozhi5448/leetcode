package gcd;

import org.junit.Test;

import static org.junit.Assert.*;

public class Kettle_365Test {
    Kettle_365 obj = new Kettle_365();
    @Test
    public void canMeasureWater() {
        System.out.println(obj.canMeasureWater(3, 5, 4));
        System.out.println(obj.canMeasureWater(0,0,1));

    }
}