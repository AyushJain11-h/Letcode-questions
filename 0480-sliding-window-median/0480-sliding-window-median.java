import java.util.*;

class Solution {

    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Add first k elements
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        result[0] = getMedian(k);

        // Slide the window
        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);

            result[i - k + 1] = getMedian(k);
        }

        return result;
    }

    private void add(int num) {
        if (small.isEmpty() || num <= small.lastKey()) {
            small.put(num, small.getOrDefault(num, 0) + 1);
            smallSize++;
        } else {
            large.put(num, large.getOrDefault(num, 0) + 1);
            largeSize++;
        }

        balance();
    }

    private void remove(int num) {
        if (small.containsKey(num)) {
            removeFromMap(small, num);
            smallSize--;
        } else {
            removeFromMap(large, num);
            largeSize--;
        }

        balance();
    }

    private void removeFromMap(TreeMap<Integer, Integer> map, int num) {
        int count = map.get(num);

        if (count == 1) {
            map.remove(num);
        } else {
            map.put(num, count - 1);
        }
    }

    private void balance() {

        // small can have one more element than large
        while (smallSize > largeSize + 1) {
            int num = small.lastKey();

            removeFromMap(small, num);
            smallSize--;

            large.put(num, large.getOrDefault(num, 0) + 1);
            largeSize++;
        }

        while (smallSize < largeSize) {
            int num = large.firstKey();

            removeFromMap(large, num);
            largeSize--;

            small.put(num, small.getOrDefault(num, 0) + 1);
            smallSize++;
        }
    }

    private double getMedian(int k) {
        if (k % 2 == 1) {
            return (double) small.lastKey();
        }

        return ((double) small.lastKey() + (double) large.firstKey()) / 2.0;
    }
}