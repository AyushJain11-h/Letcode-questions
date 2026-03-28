import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long total = 0;

        for (int num : target) {
            maxHeap.offer(num);
            total += num;
        }

        while (true) {
            int largest = maxHeap.poll();
            long rest = total - largest;

            // Base cases
            if (largest == 1 || rest == 1) return true;
            if (rest == 0 || largest < rest || largest % rest == 0) return false;

            int updated = (int)(largest % rest);

            maxHeap.offer(updated);
            total = rest + updated;
        }
    }
}