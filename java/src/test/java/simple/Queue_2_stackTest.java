package simple;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class Queue_2_stackTest {
    Queue_2_stack queue_2_stack;
    Logger logger;
    @Before
    public void init(){
        queue_2_stack = new Queue_2_stack();
        logger = LoggerFactory.getLogger(Queue_2_stack.class);
    }

    @Test
    public void test1(){
        queue_2_stack.appendTail(3);
        logger.info(String.format("%d",queue_2_stack.deleteHead()));
        logger.info(String.format("%d",queue_2_stack.deleteHead()));

    }

    @Test
    public void test2(){
        logger.info(String.format("%d", queue_2_stack.deleteHead()));
        queue_2_stack.appendTail(5);
        queue_2_stack.appendTail(2);
        logger.info(String.format("%d", queue_2_stack.deleteHead()));
        logger.info(String.format("%d", queue_2_stack.deleteHead()));
    }
}