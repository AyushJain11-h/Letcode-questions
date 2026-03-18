import java.util.*;

class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int result = 0;
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            // probability = 1/count
            if (rand.nextInt(count) == 0) {
                result = curr.val;
            }
            curr = curr.next;
        }

        return result;
    }
}