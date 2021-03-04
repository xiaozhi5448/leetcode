package sample;
import list.ListNode;
import java.util.Random;
public class RandomSelect {
    ListNode head = null;
    Random r = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public RandomSelect(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = 0;
        int index = 0;
        ListNode ptr = head;
        while(ptr != null){
            index++;
            if(r.nextFloat() < (float)1/index){
                res = ptr.getVal();
            }
            ptr = ptr.getNext();
        }
        return res;
    }
}
