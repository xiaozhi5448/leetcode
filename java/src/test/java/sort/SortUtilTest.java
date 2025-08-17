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
    int size = 100000;
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
        stopWatch.reset();

    }
    @Test
    public void testQuickSort() {
        SortUtil.costCalProcess(new SortUtil.SortOperation() {
            @Override
            public void sort(int[] nums) {
                SortUtil.quickSort(nums, 0, nums.length-1);
            }
        }, nums, "quicksort");
    }

    @Test
    public void testBubbleSort(){
        SortUtil.costCalProcess(new SortUtil.SortOperation() {
            @Override
            public void sort(int[] nums) {
                SortUtil.bubbleSort(nums);
            }
        }, nums, "bubblesort");
    }

    @Test
    public void testSelectSort(){
        SortUtil.costCalProcess(new SortUtil.SortOperation() {
            @Override
            public void sort(int[] nums) {
                SortUtil.selectSort(nums);
            }
        }, nums, "select sort");
    }

    @Test
    public void testInsertionSort(){
        stopWatch.start();
        util.insertionSort(nums);
        stopWatch.stop();
        logger.info("insertion sort cost: " + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    @Test
    public void testMergeSort(){
        stopWatch.start();
        util.mergeSort(nums);
        stopWatch.stop();
        logger.info("merge sort cost: " + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    @Test
    public void testHeapSort(){
        stopWatch.start();
        util.heapSort(nums);
        stopWatch.stop();
        logger.info("heap sort cost: " + stopWatch.getTime(TimeUnit.MILLISECONDS));
    }
}