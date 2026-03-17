import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a); // reverse lexicographical
                }
                return map.get(a) - map.get(b); // smaller freq first
            }
        );

        // Step 3: Keep only top k
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build result (reverse order)
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }
}