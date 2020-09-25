package simple;

import junit.framework.TestCase;
import org.junit.Test;

public class HanMingDistanceTest extends TestCase {

    @Test
    public void test(){
        int x = 4, y = 1;
        HanMingDistance hanMingDistance = new HanMingDistance();
        System.out.println(hanMingDistance.hammingDistance(x, y));
    }

}