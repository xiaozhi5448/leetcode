package list;

import junit.framework.TestCase;
import org.junit.Assert;

public class ListSortUtilTest extends TestCase {

    public void testSortList() {
        ListSortUtil listSortUtil = new ListSortUtil();
        ListNode head = ListSortUtil.buildListNode(new int[]{4, 2, 1, 3});
        ListNode middle = listSortUtil.findMiddle(head);

        Assert.assertEquals(1, middle.getVal());
        head = ListSortUtil.buildListNode(new int[]{-1,5,3,4,0});
        ListNode res = listSortUtil.sortList(head);
        Assert.assertEquals(-1, res.getVal());

    }
}