import java.util.*;

class Solution {
    static class Node {
        int val, row, idx;
        Node(int val, int row, int idx) {
            this.val = val;
            this.row = row;
            this.idx = idx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        int max = Integer.MIN_VALUE;

        // Initialize heap with first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Node(val, i, 0));
            max = Math.max(max, val);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (true) {
            Node cur = minHeap.poll();
            int min = cur.val;

            // Update smallest range
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // Move forward in the same list
            if (cur.idx + 1 == nums.get(cur.row).size()) {
                break; // one list exhausted
            }

            int nextVal = nums.get(cur.row).get(cur.idx + 1);
            minHeap.offer(new Node(nextVal, cur.row, cur.idx + 1));
            max = Math.max(max, nextVal);
        }

        return new int[]{rangeStart, rangeEnd};
    }
}