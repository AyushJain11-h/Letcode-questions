import java.util.*;

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long minTime = Integer.MAX_VALUE;

        for (int w : workerTimes) {
            minTime = Math.min(minTime, w);
        }

        long right = minTime * (long) mountainHeight * (mountainHeight + 1) / 2;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {
        long reduced = 0;

        for (int w : workerTimes) {
            long x = (long)((Math.sqrt(1 + 8.0 * time / w) - 1) / 2);
            reduced += x;

            if (reduced >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
}