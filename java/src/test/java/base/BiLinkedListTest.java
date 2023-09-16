package base;

import junit.framework.TestCase;

public class BiLinkedListTest extends TestCase {

    BiLinkedList<Integer> linkedList;

    public void setUp() throws Exception {
        linkedList = new BiLinkedList<>();
        for(int i = 0; i< 10; i++){
            linkedList.append(i);
        }
    }

    public void tearDown() throws Exception {
    }

    public void testRemoveNode() {
    }

    public void testAppend() {
    }

    public void testAddHeader() {
    }

    public void testTestAddHeader() {
    }

    public void testMoveToHeader() {
        BiLinkedListNode<Integer> node = linkedList.getByVal(3);
        linkedList.moveToHeader(node);
        System.out.println(linkedList);
    }

    public void testTestToString() {
        System.out.println(linkedList);
    }
}