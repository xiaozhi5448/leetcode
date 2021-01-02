package middle;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class SumOfSquareTest {
    SumOfSquare obj;
    Logger logger;
    @Before
    public void init(){
        logger = LoggerFactory.getLogger(SumOfSquareTest.class);
        obj = new SumOfSquare();
    }
    @Test
    public void numSquares() {
        int res = obj.numSquares(13);
        System.out.printf("%d\n", res);
        res = obj.numSquresDP(13);
        System.out.printf("%d\n", res);
    }
}