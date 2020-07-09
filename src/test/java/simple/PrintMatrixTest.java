package simple;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PrintMatrixTest extends TestCase {
    ArrayList<Integer> array;
    Logger logger;
    int [][] nums= {{1, 2, 3}, {1, 2,3}};
    public void setUp() throws Exception {
        super.setUp();
        logger = LoggerFactory.getLogger(PrintMatrix.class);
    }
    @Test
    public void testSpiralOrder() {
       logger.info(String.format("%d",nums[0].length));


    }
}