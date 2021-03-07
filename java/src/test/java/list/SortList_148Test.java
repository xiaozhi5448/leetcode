package list;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SortList_148Test {

    @Test
    public void sortList() {
        ListNode head = ListNode.buildFormList(new int[]{89,48,3,384,39,45});
        System.out.println("before: " + ListNode.str(head));
        SortList_148 util = new SortList_148();
        ListNode res = util.sortList(head);
        System.out.println( "after: " + ListNode.str(res));
    }
}