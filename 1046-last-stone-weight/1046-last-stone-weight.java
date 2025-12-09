class Solution {
      public int lastStoneWeight(int[] stones) {
        // Create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continuously remove and smash the two heaviest stones
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // The heaviest stone
            int x = maxHeap.poll(); // The second heaviest stone

            if (x != y) {
                maxHeap.add(y - x); // Add the remaining stone back to the heap
            }
        }

        // Return the weight of the last remaining stone or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}