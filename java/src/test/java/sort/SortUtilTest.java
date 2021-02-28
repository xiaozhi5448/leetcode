package sort;

import junit.framework.TestCase;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SortUtilTest {
    static SortUtil util;
    static Logger logger;
    int[] nums;
    static StopWatch stopWatch;
    int size = 10000;
    @BeforeClass
    public static void init(){
        util = new SortUtil();
        logger = LoggerFactory.getLogger(SortUtilTest.class);
        stopWatch = new StopWatch();
        logger.info("init!");
    }
    @Before
    public void generateRandoms(){
        nums = new int[size];
        for(int i = 0; i<size;i++){
            nums[i] = ThreadLocalRandom.current().nextInt(10000);
        }

    }
    @Test
    public void testQuickSort() {
        stopWatch.start();
        util.quickSort(nums, 0, size-1);
        stopWatch.stop();
        logger.info("cost: " + stopWatch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void testBubbleSort(){
        stopWatch.start();
        util.bubbleSort(nums);
        stopWatch.stop();
        logger.info("bubble sort cost: " + stopWatch.getTime(TimeUnit.SECONDS));

    }

    @Test
    public void testSelectSort(){
        stopWatch.start();
        util.selectSort(nums);
        stopWatch.stop();
        logger.info("select sort cost: " + stopWatch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void testInsertionSort(){
        stopWatch.start();
        util.insertionSort(nums);
        stopWatch.stop();
        logger.info("insertion sort cost: " + stopWatch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void testMergeSort(){
        stopWatch.start();
        util.mergeSort(nums);
        stopWatch.stop();
        logger.info("merge sort cost: " + stopWatch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void testHeapSort(){
        stopWatch.start();
        util.heapSort(nums);
        stopWatch.stop();
        logger.info("heap sort cost: " + stopWatch.getTime(TimeUnit.SECONDS));
    }
}